package delfinen.logic;

import delfinen.data.DataAccessor;
import java.util.ArrayList;

public class ControllerMember implements Controller
{

    private DataAccessor data;

    public ControllerMember(DataAccessor data)
    {
        this.data = data;
    }

    public Member getMember(String ssn)
    {
        try
        {
            Member member = data.getMember(ssn);
            return member;
        } catch (Exception ex)
        {
            System.out.println("Member not found");
            return null;

        }

    }

    public ArrayList<Member> getMembers()
    {
        try
        {
            ArrayList<Member> members = data.getMembers();
            return members;

        } catch (Exception ex)
        {
            System.out.println("Members not found");
            return null;

        }
    }

    @Override
    public ArrayList<TrainingResult> getTrainingResult(Member s, Disciplin d)
    {
        try
        {
            ArrayList<TrainingResult> tr = data.getTrainingResult(s.getSsn(), d);
            return tr;

        } catch (Exception ex)
        {
            System.out.println("No training results found");
            return null;
        }

    }

    @Override
    public void updateMember(Member m, String field, String change)
    {
       data.updateMember(m.getSsn(), change, field); 
    }

    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(Member s)
    {
         try
        {
            ArrayList<CompetitionResult> cr = data.getCompetitionResult(s.getSsn());
            return cr;

        } catch (Exception ex)
        {
            System.out.println("No training results found");
            return null;
        }
    }

}
