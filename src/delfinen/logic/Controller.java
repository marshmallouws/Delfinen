package delfinen.logic;

import delfinen.data.Member;
import java.util.ArrayList;

public interface Controller
{

    public Member getMember(String ssn);
    
    public ArrayList<Member> getMembers();

   

}
