package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDatabase;
import delfinen.data.DataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerTrainer extends Controller {

    private DBConnector c;
    private DataAccessorDatabase data;

    public ControllerTrainer() {
        try {
            c = new DBConnector();
            data = new DataAccessorDatabase(c);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     *
     * @return a list of competitionSwimmers
     */
    public ArrayList<CompetitionSwimmer> getSwimmers() {
        try {
            ArrayList<CompetitionSwimmer> swimmers = data.getComptitionSwimmers();
            return swimmers;

        } catch (Exception ex) {
            System.out.println("Swimmers not found");
            return null;

        }
    }

    public void addResults(CompetitionSwimmer s) {

        s.getTrainingBackCrawl().addAll(getTrainingResult(s, Disciplin.BACKCRAWL));
        s.getTrainingCrawl().addAll(getTrainingResult(s, Disciplin.CRAWL));
        s.getTrainingButterfly().addAll(getTrainingResult(s, Disciplin.BUTTERFLY));
        s.getTrainingBreastStroke().addAll(getTrainingResult(s, Disciplin.BREASTSTROKE));
        s.getCompetition().addAll(getCompetitionResult(s));
    }

    /**
     *
     * @return a list of teams
     */
    public ArrayList<Team> getTeams() {
        ArrayList<Team> t = null;
        try {
            t = data.getTeams();
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }
        return t;
    }

    /**
     *
     * @param teams used to put member on team
     */
    public void makeTeams(ArrayList<Team> teams) {

        ArrayList<CompetitionSwimmer> swimmers = null;
        try {
            swimmers = data.getComptitionSwimmers();
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }

        for (CompetitionSwimmer s : swimmers) {

            if (s.getMembership().equals(Membership.JUNIOR)) {
                teams.get(1).addSwimmer(s);
            } else {
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
    public ArrayList<TrainingResult> top5(Team team, Disciplin d) {
        ArrayList<TrainingResult> t = null;
        try {
            t = data.getTop5(d, team);
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }
        return t;
    }

    /**
     *
     * @param s used to search for competitionSwimmer
     * @param date used to tell the date of a training
     * @param time used to tell time-result from training
     * @param d used to tell what discpline the result is from
     */
    public void registerTraining(CompetitionSwimmer s, String date, String time, Disciplin d) {
        try {
            data.createTrainingResult(s, d, date, time);
        } catch (DataException ex) {
            System.out.println("Could not write to database.");
        }
    }

    /**
     *
     * @param s used to search for competitionSwimmer
     * @param competition used to tell where the competition is located
     * @param rank used to tell the competitionswimmers rank
     * @param time used to tell the time-result from competition
     * @param disciplin used to tell what discipline the result is from
     */
    public void registerCompetition(CompetitionSwimmer s, String competition, int rank, String time, Disciplin disciplin) {
        try {
            data.createCompetitionResult(s, competition, rank, time, disciplin);
        } catch (DataException ex) {
            System.out.println("Could not write to database.");
        }
    }

}
