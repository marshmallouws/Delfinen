package delfinen.logic;

import java.util.ArrayList;

public interface Controller
{

    public Member getMember(String ssn);
    
    public ArrayList<Member> getMembers();

    public ArrayList<TrainingResult> getTrainingResult(Member m, Disciplin d);

}
