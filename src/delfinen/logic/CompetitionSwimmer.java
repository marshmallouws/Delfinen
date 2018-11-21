package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDatabase;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompetitionSwimmer extends Member
{

    private DataAccessorDatabase data;

    private ArrayList<TrainingResult> trainingCrawl;
    private ArrayList<TrainingResult> trainingBackCrawl;
    private ArrayList<TrainingResult> trainingButterfly;
    private ArrayList<TrainingResult> trainingBreastStroke;
    private ArrayList<CompetitionResult> competition;

    public CompetitionSwimmer(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, int lastPayment) throws SQLException
    {
        super(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus, lastPayment);
        
        this.trainingCrawl = new ArrayList<>();
        this.trainingBackCrawl = new ArrayList<>();
        this.trainingButterfly = new ArrayList<>();
        this.trainingBreastStroke = new ArrayList<>();
        this.competition = new ArrayList<>();
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

    public void addTrainingResult(TrainingResult r)
    {
        if(r.getDisciplin().equals(Disciplin.CRAWL))
        {
            trainingCrawl.add(r);
        }
        else if(r.getDisciplin().equals(Disciplin.BACKCRAWL))
        {
            trainingBackCrawl.add(r);
        }
        if(r.getDisciplin().equals(Disciplin.BREASTSTROKE))
        {
            trainingBreastStroke.add(r);
        }
        else
        {
            trainingButterfly.add(r);
        }
    }
}
