package delfinen.logic;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompetitionSwimmer extends Member
{
    private ControllerTrainer c;
    private ArrayList<TrainingResult> trainingCrawl;
    private ArrayList<TrainingResult> trainingBackCrawl;
    private ArrayList<TrainingResult> trainingButterfly;
    private ArrayList<TrainingResult> trainingBreastStroke;
    private ArrayList<CompetitionResult> competition;

    public CompetitionSwimmer(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, int lastPayment) throws SQLException
    {
        super(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus, lastPayment);
        
        this.c = c;
        this.trainingCrawl = new ArrayList<>(); //c.getTrainingResult(this, Disciplin.CRAWL);
        this.trainingBackCrawl = new ArrayList<>(); //c.getTrainingResult(this, Disciplin.BACKCRAWL);
        this.trainingButterfly = new ArrayList<>(); //c.getTrainingResult(this, Disciplin.BUTTERFLY);
        this.trainingBreastStroke = new ArrayList<>(); //c.getTrainingResult(this, Disciplin.BREASTSTROKE);
        this.competition = new ArrayList<>(); //c.getCompetitionResult(this);
    }

    public ArrayList<TrainingResult> getTrainingCrawl()
    {
        return trainingCrawl;
    }

    public ArrayList<TrainingResult> getTrainingBackCrawl()
    {
        return trainingBackCrawl;
    }

    public ArrayList<TrainingResult> getTrainingButterfly()
    {
        return trainingButterfly;
    }

    public ArrayList<TrainingResult> getTrainingBreastStroke()
    {
        return trainingBreastStroke;
    }

    public ArrayList<CompetitionResult> getCompetition()
    {
        return competition;
    }

    public void addTrainingResult(String date, String time, Disciplin d)
    {
        c.registerTraining(this, date, time, d);
    
    }
}
