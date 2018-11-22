package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDatabase;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerMember implements Controller
{

    private DBConnector c;
    private DataAccessorDatabase data;

    public ControllerMember()
    {
        try
        {
            c = new DBConnector();
            data = new DataAccessorDatabase(c);

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    /**
     * 
     * @param ssn used to search for member
     * @return a member
     */
    public Member getMember(String ssn)
    {
        try
        {
            Member member = data.getMember(ssn);
            return member;
        } catch (Exception ex)
        {
            System.out.println("Member not found");
            return null;

        }

    }
    
    /**
     * 
     * @return a list of members
     */
    public ArrayList<Member> getMembers()
    {
        try
        {
            ArrayList<Member> members = data.getMembers();
            return members;

        } catch (Exception ex)
        {
            System.out.println("Members not found");
            return null;

        }
    }
    /**
     * 
     * @param s used to search for member
     * @param d used to search for specific discipline
     * @return a list of a member' trainingresults
     */
    @Override
    public ArrayList<TrainingResult> getTrainingResult(Member s, Disciplin d)
    {
        try
        {
            ArrayList<TrainingResult> tr = data.getTrainingResult(s.getSsn(), d);
            return tr;

        } catch (Exception ex)
        {
            System.out.println("No training results found");
            return null;
        }

    }

    /**
     * 
     * @param m used to search for member
     * @param change used to tell what change there is going to be
     * @param field that is going to be updated
     */
    @Override
    public void updateMember(Member m, String change, String field)
    {
        data.updateMember(m.getSsn(), change, field);
    }

    /**
     * 
     * @param s used to search for member
     * @return a list of a member' competitionsresults
     */
    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(Member s)
    {
        try
        {
            ArrayList<CompetitionResult> cr = data.getCompetitionResult(s.getSsn());
            return cr;

        } catch (Exception ex)
        {
            System.out.println("No training results found");
            return null;
        }
    }

}
