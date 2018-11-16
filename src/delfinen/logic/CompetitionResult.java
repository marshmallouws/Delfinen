
package delfinen.logic;



public class CompetitionResult
{
    private Member m;
    private String competition;
    private int rank;
    private String time;
    private Disciplin disciplin;

    public CompetitionResult(Member m, String competition, int rank, String time, Disciplin disciplin)
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

    public String getTime()
    {
        return time;
    }

    public Disciplin getDisciplin()
    {
        return disciplin;
    }
    
}
