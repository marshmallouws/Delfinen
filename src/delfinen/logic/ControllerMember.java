package delfinen.logic;

import delfinen.data.DataAccessor;
import java.util.ArrayList;
import java.util.Calendar;

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

    public double calculateS(Member m)
    {
        try
        {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            
            if(m.getAge(year) < 0){
                throw new IllegalArgumentException();
            }

            if (m.getMemberstatus().equals(MemberStatus.PASSIVE))
            {
                return 500;
            } else
            {
                if (m.getAge(year) < 18)
                {
                    return 1000;
                } else if (m.getAge(year) > 60)
                {
                    return 1600 * 0.75;
                } else
                {
                    return 1600;
                }
            }
        } catch (Exception ex)
        {
            throw new IllegalArgumentException(ex);

        }

    }

}
