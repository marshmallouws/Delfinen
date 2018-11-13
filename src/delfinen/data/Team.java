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

    public void addMember(Member m)
    {
        members.add(m);
    }

    public void removeMember(String membername)
    {

        for (Member m : members)
        {
            String name = m.getFirstname() + m.getLastname();
            if (membername == name)
            {
                members.remove(m);
            }
        }
    }

}
