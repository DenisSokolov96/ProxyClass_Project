import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DynamicInvocationHandler implements InvocationHandler {

    private Object obj;

    public DynamicInvocationHandler(Object obj){
        this.obj=obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //получение метода при выполнении
        Method meth = obj.getClass().getMethod(method.getName(), (Class<?>[]) method.getGenericParameterTypes());

        //получение аннотации у метода
        Logged getLog = meth.getAnnotation(Logged.class);
        try {
            Logger logger = LogManager.getLogger(getLog.logClass());
            switch (getLog.logMethodType()) {
                case INFO:
                    logger.info(meth);
                    break;
                case ERROR:
                    logger.error(meth);
                    break;
                case WARN:
                    logger.warn(meth);
                    break;
            }
        }catch (NullPointerException e){}

        return method.invoke(obj, args);
    }
}
