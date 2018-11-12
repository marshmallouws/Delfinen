
package delfinen.data;

/**
 *
 * @author sofieamalielandt
 */
public class DataAccessor
{ 
    
    private DBConnector connector = null;

    public DataAccessor(DBConnector connector)
    {
        this.connector = connector;
    }
    
}
