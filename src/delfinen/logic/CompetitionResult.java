
package delfinen.logic;

import delfinen.logic.Disciplin;
import delfinen.logic.Member;
import java.sql.Time;


public class CompetitionResult
{
    private Member m;
    private String competition;
    private int rank;
    private Time time;
    private Disciplin disciplin;

    public CompetitionResult(Member m, String competition, int rank, Time time, Disciplin disciplin)
    {
        this.m = m;
        this.competition = competition;
        this.rank = rank;
        this.time = time;
        this.disciplin = disciplin;
    }

    public Member getMember()
    {
        return m;
    }

    public String getCompetition()
    {
        return competition;
    }

    public int getRank()
    {
        return rank;
    }

    public Time getTime()
    {
        return time;
    }

    public Disciplin getDisciplin()
    {
        return disciplin;
    }
    
}
