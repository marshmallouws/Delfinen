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

    public void makeTeams()
    {

        ArrayList<Team> teams = data.getTeams();
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

}
