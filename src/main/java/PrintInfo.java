public class PrintInfo implements IMyPrintClass {

    private StringBuilder str;

    PrintInfo() {
        str = new StringBuilder("");
    }

    @Logged(logMethodType = LogType.INFO, logClass = PrintInfo.class)
    public void printInfo() {
        System.out.println(str);
    }

    @Logged(logMethodType = LogType.ERROR, logClass = PrintInfo.class)
    public void del() {
        str.setLength(0);
    }

    @Logged(logMethodType = LogType.WARN, logClass = PrintInfo.class)
    public void add(String str_message) {
        if (str.length()==0)
            str.append(str_message);
        else str.append("\n"+str_message);
    }
}
