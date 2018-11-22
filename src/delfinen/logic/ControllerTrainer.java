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

    /**
     *
     * @return a list of competitionSwimmers
     */
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

    public void addResults(CompetitionSwimmer s)
    {

        s.getTrainingBackCrawl().addAll(getTrainingResult(s, Disciplin.BACKCRAWL));
        s.getTrainingCrawl().addAll(getTrainingResult(s, Disciplin.CRAWL));
        s.getTrainingButterfly().addAll(getTrainingResult(s, Disciplin.BUTTERFLY));
        s.getTrainingBreastStroke().addAll(getTrainingResult(s, Disciplin.BREASTSTROKE));
        s.getCompetition().addAll(getCompetitionResult(s));
    }

    /**
     *
     * @param s used to search for member
     * @param d used to search for specific discipline
     * @return a list of trainingresult for a member in a specific discipline
     */
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

    /**
     *
     * @param m used to search for member
     * @param field that is going to be updated
     * @param change used to tell what change there is going to be
     */
    @Override
    public String updateMember(Member m, String field, String change)
    {
        String error = "";
        String zipTrim = "";
        String phoneTrim = "";

        switch (field)
        {
            case "firstname":

                if (change.length() > 40 || change.isEmpty())
                {
                    error += "Firstname must be between 1 - 40 characters";
                }
                break;

            case "lastname":

                if (change.length() > 40 || change.isEmpty())
                {
                    error += " Lastname must be between 1 - 40 characters";
                }
                break;

            case "address":

                if (change.length() > 50 || change.isEmpty())
                {
                    error += " Address must be between 1 and 50 characters";
                }
                break;

            case "zipcode":

                zipTrim = change.trim();

                try
                {
                    Integer.parseInt(zipTrim);
                } catch (NumberFormatException e)
                {
                    error += " Zipcode must be 4 digits";
                }

                if (zipTrim.length() == 4)
                {
                    change = zipTrim;
                } else
                {
                    error += " Zipcode must be 4 digits";
                }
                break;

            case "phone":

                phoneTrim = change.trim();

                try
                {
                    Integer.parseInt(phoneTrim);
                } catch (NumberFormatException e)
                {
                    error += " Phone number must be 8 digits";
                }

                if (phoneTrim.length() == 8)
                {
                    change = phoneTrim;
                } else
                {
                    error += " Phone number must be 8 digits";
                }
                break;

            case "memberstatus":

                change = change;
                break;
        }

        if (error.isEmpty())
        {
            data.updateMember(m.getSsn(), change, field);
            return error;
        }

        return error;
    }

    /**
     *
     * @param s used to search for member
     * @return a list of a members competitionsresults
     */
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

    /**
     *
     * @return a list of teams
     */
    public ArrayList<Team> getTeams()
    {
        return data.getTeams();

    }

    /**
     *
     * @param teams used to put member on team
     */
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

    /**
     *
     * @param team used to search for team
     * @param d used to search for specific discpline
     * @return a top 5 list for a team in a specific discpline
     */
    public ArrayList<TrainingResult> top5(Team team, Disciplin d)
    {

        return data.getTop5(d, team);
    }

    /**
     *
     * @param s used to search for competitionSwimmer
     * @param date used to tell the date of a training
     * @param time used to tell time-result from training
     * @param d used to tell what discpline the result is from
     */
    public void registerTraining(CompetitionSwimmer s, String date, String time, Disciplin d)
    {
        data.createTrainingResult(s, d, date, time);
    }

    /**
     *
     * @param s used to search for competitionSwimmer
     * @param competition used to tell where the competition is located
     * @param rank used to tell the competitionswimmers rank
     * @param time used to tell the time-result from competition
     * @param disciplin used to tell what discipline the result is from
     */
    public void registerCompetition(CompetitionSwimmer s, String competition, int rank, String time, Disciplin disciplin)
    {
        data.createCompetitionResult(s, competition, rank, time, disciplin);
    }

}
