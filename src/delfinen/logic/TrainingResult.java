
package delfinen.logic;

public class TrainingResult
{
    private Member m;
    private Disciplin d;
    private String date;
    private String time;

    public TrainingResult(Member m, Disciplin d, String date, String time)
    {
        this.m = m;
        this.d = d;
        this.date = date;
        this.time = time;
    }

    public Member getMember()
    {
        return m;
    }

    public Disciplin getDisciplin()
    {
        return d;
    }

    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }
}
