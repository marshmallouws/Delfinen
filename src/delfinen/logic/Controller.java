package delfinen.logic;

import delfinen.data.CompetitionSwimmer;
import delfinen.data.Member;


public interface Controller
{

    public Member getMember(String ssn);

    public CompetitionSwimmer getCompetitionSwimmer(String ssn);
    
  

}
