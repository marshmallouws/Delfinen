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

    @Override
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

    @Override
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
    public ArrayList<TrainingResult> getTrainingResult(CompetitionSwimmer s, Disciplin d)
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
    public void updateMemberString(Member m, String change, String field)
    {
       data.updateMember(m.getSsn(), change, field); 
    }

    @Override
    public void updateMemberInt(Member m, String field, int change)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
