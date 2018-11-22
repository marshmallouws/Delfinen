package delfinen.logic;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompetitionSwimmer extends Member {

    private ControllerTrainer c;
    private ArrayList<TrainingResult> trainingCrawl;
    private ArrayList<TrainingResult> trainingBackCrawl;
    private ArrayList<TrainingResult> trainingButterfly;
    private ArrayList<TrainingResult> trainingBreastStroke;
    private ArrayList<CompetitionResult> competition;

    public CompetitionSwimmer(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, int lastPayment) throws SQLException {
        super(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus, lastPayment);

        this.c = c;
        this.trainingCrawl = new ArrayList<>();
        this.trainingBackCrawl = new ArrayList<>();
        this.trainingButterfly = new ArrayList<>();
        this.trainingBreastStroke = new ArrayList<>();
        this.competition = new ArrayList<>();
    }

    public ArrayList<TrainingResult> getTrainingCrawl() {
        return trainingCrawl;
    }

    public ArrayList<TrainingResult> getTrainingBackCrawl() {
        return trainingBackCrawl;
    }

    public ArrayList<TrainingResult> getTrainingButterfly() {
        return trainingButterfly;
    }

    public ArrayList<TrainingResult> getTrainingBreastStroke() {
        return trainingBreastStroke;
    }

    public ArrayList<CompetitionResult> getCompetition() {
        return competition;
    }

    public void addTrainingResult(String date, String time, Disciplin d) {
        c.registerTraining(this, date, time, d);

    }
}
