
package delfinen.logic;

import delfinen.logic.CompetitionResult;
import delfinen.logic.TrainingResult;
import delfinen.logic.Member;
import java.util.ArrayList;

public class CompetitionSwimmer
{
    private Member member;
    private ArrayList<TrainingResult> trainings;
    private ArrayList<CompetitionResult> competitions;
    
    public CompetitionSwimmer(Member member, ArrayList<TrainingResult> trainings, ArrayList<CompetitionResult> competitions)
    {
        this.member = member;
        this.trainings = trainings;
        this.competitions = competitions;
    }
    
    public Member getMember()
    {
        return member;
    }

    public ArrayList<TrainingResult> getTrainings()
    {
        return trainings;
    }

    public ArrayList<CompetitionResult> getCompetitions()
    {
        return competitions;
    }

    
}
