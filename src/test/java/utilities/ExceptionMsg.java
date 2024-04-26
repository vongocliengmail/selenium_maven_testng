package utilities;

public class ExceptionMsg extends Exception {

    /*
     * Method for throwing exception as message
     * @param message
     * @throws ExceptionMessage
     */
    public ExceptionMsg(String message) throws ExceptionMsg {
        super(message);
    }

}
