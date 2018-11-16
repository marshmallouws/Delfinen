package delfinen.logic;

import java.util.ArrayList;

public interface Controller
{

    public Member getMember(String ssn);
    
    public ArrayList<Member> getMembers();

    public ArrayList<TrainingResult> getTrainingResult(CompetitionSwimmer s, Disciplin d);

    public void updateMemberString (Member m, String field, String change);
    
    public void updateMemberInt (Member m, String field, int change);
    
}
