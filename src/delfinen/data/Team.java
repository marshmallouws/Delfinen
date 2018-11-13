
package delfinen.data;

import java.util.ArrayList;

public class Team
{
    private String teamname;
    private ArrayList<Member> members;

    public Team(String teamname)
    {
        this.teamname = teamname;
        this.members = new ArrayList<>();
    }

    public String getTeamname()
    {
        return teamname;
    }

    public ArrayList<Member> getMembers()
    {
        return members;
    }
    
    
}
