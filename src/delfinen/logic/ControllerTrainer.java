package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDatabase;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerTrainer implements Controller
{
    
    private DBConnector c;
    private DataAccessorDatabase data;
    
    public ControllerTrainer()
    {
        try
        {
            c = new DBConnector();
            data = new DataAccessorDatabase(c);
            
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    public ArrayList<CompetitionSwimmer> getSwimmers()
    {
        try
        {
            ArrayList<CompetitionSwimmer> swimmers = data.getComptitionSwimmers();
            return swimmers;
            
        } catch (Exception ex)
        {
            System.out.println("Swimmers not found");
            return null;
            
        }
    }
    
    @Override
    public ArrayList<TrainingResult> getTrainingResult(Member s, Disciplin d)
    {
        try
        {
            ArrayList<TrainingResult> tr = data.getTrainingResult(s.getSsn(), d);
            return tr;
            
        } catch (Exception ex)
        {
            System.out.println("No training results found");
            return null;
        }
    }
    
    @Override
    public void updateMember(Member m, String field, String change)
    {
        data.updateMember(m.getSsn(), change, field);
    }
    
    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(Member s)
    {
        try
        {
            ArrayList<CompetitionResult> cr = data.getCompetitionResult(s.getSsn());
            return cr;
            
        } catch (Exception ex)
        {
            System.out.println("No training results found");
            return null;
        }
    }
    
    public ArrayList<Team> getTeams()
    {
        return data.getTeams();
        
    }
    
    public void makeTeams(ArrayList<Team> teams)
    {
        
        ArrayList<CompetitionSwimmer> swimmers = data.getComptitionSwimmers();
        
        for (CompetitionSwimmer s : swimmers)
        {
            
            if (s.getMembership().equals(Membership.JUNIOR))
            {
                teams.get(1).addSwimmer(s);
            } else
            {
                teams.get(0).addSwimmer(s);
            }
            
        }
        
    }
    
    public ArrayList<TrainingResult> top5(Team team, Disciplin d)
    {
        
        return data.getTop5(d, team);
    }
    
    public void registerTraining(CompetitionSwimmer s, String date, String time, Disciplin d)
    {
        data.createTrainingResult(s, d, date, time); 
    }
    
    public void registerCompetition(CompetitionSwimmer s, String competition, int rank, String time, Disciplin disciplin)
    {
        data.createCompetitionResult(s, competition, rank, time, disciplin);
    }
    
}
