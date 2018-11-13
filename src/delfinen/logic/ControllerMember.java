package delfinen.logic;

import delfinen.data.CompetitionSwimmer;
import delfinen.data.DataAccessor;
import delfinen.data.Member;


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

}
