package delfinen.logic;

import java.util.ArrayList;

public class Team {

    private String teamname;
    private ArrayList<CompetitionSwimmer> swimmers;

    public Team(String teamname) {
        this.teamname = teamname;
        this.swimmers = new ArrayList<>();
    }

    public String getTeamname() {
        return teamname;
    }

    public ArrayList<CompetitionSwimmer> getSwimmers() {
        return swimmers;
    }

    public void addSwimmer(CompetitionSwimmer s) {
        swimmers.add(s);
    }

    public void removeSwimmer(String swimmername) {
        for (CompetitionSwimmer s : swimmers) {
            String name = s.getFirstname() + s.getLastname();

            if (swimmername == name) {
                swimmers.remove(s);
            }
        }
    }

}
