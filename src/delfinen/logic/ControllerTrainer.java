package delfinen.logic;

import delfinen.data.CompetitionSwimmer;
import delfinen.data.DataAccessor;
import delfinen.data.Member;

public class ControllerTrainer implements Controller
{
    
    private DataAccessor data;

    public ControllerTrainer(DataAccessor data)
    {
        this.data = data;
    }

    @Override
    public Member getMember(String ssn)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompetitionSwimmer getCompetitionSwimmer(String ssn)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
