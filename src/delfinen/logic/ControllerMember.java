package delfinen.logic;

import delfinen.data.CompetitionSwimmer;
import delfinen.data.DataAccessor;
import delfinen.data.Member;
import delfinen.data.MemberStatus;
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

        Member member = data.getMember(ssn);
        return member;

    }

    @Override
    public CompetitionSwimmer getCompetitionSwimmer(String ssn)
    {
        CompetitionSwimmer swimmer = data.getComptitionSwimmer();
        return swimmer;
    }

     public double calculateS(Member m)
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);

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
    }
}
