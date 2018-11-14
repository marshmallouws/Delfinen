package delfinen.logic;

import delfinen.data.CompetitionSwimmer;
import delfinen.data.DataAccessorDataBase;
import delfinen.data.Member;
import java.util.ArrayList;

public class ControllerTrainer implements Controller
{
    
    private DataAccessorDataBase data;

    public ControllerTrainer(DataAccessorDataBase data)
    {
        this.data = data;
    }

    @Override
    public Member getMember(String ssn)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public ArrayList<Member> getMembers()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompetitionSwimmer getCompetitionSwimmer(String ssn)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
