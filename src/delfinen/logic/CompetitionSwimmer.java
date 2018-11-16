
package delfinen.logic;

import java.util.ArrayList;

public class CompetitionSwimmer extends Member
{
    private ArrayList<TrainingResult> training;
    private ArrayList<CompetitionResult> competition;
    
    public CompetitionSwimmer(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus)
    {
        super(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus);
        this.training = new ArrayList<>();
        this.competition = new ArrayList<>();     
    }

    public ArrayList<TrainingResult> getTraining()
    {
        return training;
    }

    public ArrayList<CompetitionResult> getCompetition()
    {
        return competition;
    }
    
    public void addTraining(TrainingResult t)
    {
        training.add(t);
    }
    
}
