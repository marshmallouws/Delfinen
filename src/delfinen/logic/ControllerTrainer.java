package delfinen.logic;

import delfinen.data.DataAccessorDataBase;
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
    public ArrayList<TrainingResult> getTrainingResult(Member s, Disciplin d)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMember(Member m, String field, String change)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(Member s)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   

}
