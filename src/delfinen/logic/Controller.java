package delfinen.logic;

import java.util.ArrayList;

public interface Controller
{

    public ArrayList<TrainingResult> getTrainingResult(Member s, Disciplin d);
    
    public ArrayList<CompetitionResult> getCompetitionResult(Member s);

    public void updateMember (Member m, String field, String change);
    
    
}
