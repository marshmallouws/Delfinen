package delfinen.logic;

import delfinen.data.Member;
import java.util.Calendar;

public class SubscriptionCalculator
{

    public double calculateS(Member m)
    {
        int year = Calendar.getInstance().get(Calendar.YEAR);

        if (m.getMemberstatus().equals("PASSIVE"))
        {
            return 500;
        } else
        {
            if (m.getAge(year) < 18)
            {
                return 1000;
            } else if (m.getAge(year) > 60)
            {
                return 1600 * 0.75;
            } else
            {
                return 1600;
            }
        }
    }
}
