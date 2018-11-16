package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessor;
import delfinen.data.DataAccessorDataBase;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompetitionSwimmer extends Member
{

    private DataAccessor data;

    private ArrayList<TrainingResult> trainingCrawl;
    private ArrayList<TrainingResult> trainingBackCrawl;
    private ArrayList<TrainingResult> trainingButterfly;
    private ArrayList<TrainingResult> trainingBreastStroke;
    private ArrayList<CompetitionResult> competition;

    public CompetitionSwimmer(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus) throws SQLException
    {
        super(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus);
        data = new DataAccessorDataBase(new DBConnector());
        this.trainingCrawl = data.getTrainingResult(this.getSsn(), Disciplin.CRAWL);
        this.trainingBackCrawl = data.getTrainingResult(this.getSsn(), Disciplin.BACKCRAWL);
        this.trainingButterfly = data.getTrainingResult(this.getSsn(), Disciplin.BUTTERFLY);
        this.trainingBreastStroke = data.getTrainingResult(this.getSsn(), Disciplin.BREASTSTROKE);
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

}
