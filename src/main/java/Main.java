import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        PrintInfo print = new PrintInfo();

        IMyPrintClass iprint = (IMyPrintClass) Proxy.newProxyInstance
                (print.getClass().getClassLoader(),
                        print.getClass().getInterfaces(),
                        new DynamicInvocationHandler(print));

        iprint.printInfo();//
        iprint.add("Hello Proxy");
        iprint.printInfo();//"Hello Proxy"
        iprint.del();
        iprint.printInfo();//
        System.out.println("-----------");

        ClassGetInfo info = new ClassGetInfo();
        info.getMyClassInfo(print.getClass().getName());

    }
}
