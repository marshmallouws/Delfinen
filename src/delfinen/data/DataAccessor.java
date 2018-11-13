   
package delfinen.data;

import java.util.List;

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
    
    public List<Member> getMembers()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Member getMember(String ssn)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CompetitionSwimmer getComptitionSwimmer()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
