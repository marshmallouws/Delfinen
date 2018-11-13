package delfinen.data;

public class DataException extends Exception
{

    public DataException()
    {
    }

    public DataException(String string)
    {
        super(string);
    }

    public DataException(String string, Throwable thrwbl)
    {
        super(string, thrwbl);
    }

    public DataException(Throwable thrwbl)
    {
        super(thrwbl);
    }
}
