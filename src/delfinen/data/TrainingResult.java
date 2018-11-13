
package delfinen.data;

import java.sql.Date;
import java.sql.Time;


public class TrainingResult
{
    private Member m;
    private Disciplin d;
    private Date date;
    private Time time;

    public TrainingResult(Member m, Disciplin d, Date date, Time time)
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

    public Date getDate()
    {
        return date;
    }

    public Time getTime()
    {
        return time;
    }
}
