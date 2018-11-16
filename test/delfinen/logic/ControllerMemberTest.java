package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessor;
import delfinen.data.DataAccessorDataBase;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerMemberTest
{

    private ControllerMember controller;
    private DataAccessor data;

    public ControllerMemberTest() throws SQLException
    {
        data = new DataAccessorDataBase(new DBConnector());
        controller = new ControllerMember(data);

    }

    @Test
    public void testGetMember()
    {
        try
        {
            assertNotNull(controller.getMember("1506952222"));
            Member m = controller.getMember("1506952222");
            assertEquals("Oline", m.getFirstname());
            assertEquals("Sørensen", m.getLastname());
            assertEquals(Membership.SENIOR, m.getMembership());
        } catch (Exception ex)
        {
            fail(ex.getMessage());

        }

    }

    @Test
    public void testNegativeGetMember()
    {

        Member m = controller.getMember("0804950338");
        assertNull(m);

    }

    @Test
    public void testGetMembers()
    {
        try
        {
            assertNotNull(controller.getMembers());
            ArrayList<Member> m = controller.getMembers();
            assertEquals("Oline", m.get(0).getFirstname());
            assertEquals("Sørensen", m.get(0).getLastname());
            assertEquals("2670", m.get(1).getZipcode());
            assertEquals("Mosebakken 53", m.get(1).getAddress());
            assertEquals(12, m.size());
        } catch (Exception ex)
        {
            fail(ex.getMessage());

        }
    }
    
    @Test
    public void testGetTrainingResult()
    {
        try
        {
            Member m = controller.getMember("1506952222");
            assertNotNull(controller.getTrainingResult(m, Disciplin.CRAWL));
            ArrayList<TrainingResult> test = controller.getTrainingResult(m, Disciplin.CRAWL);
            assertEquals(Disciplin.CRAWL, test.get(0).getDisciplin());
            assertEquals("00:01:55", test.get(0).getTime());
            assertEquals("2018-11-13", test.get(0).getDate());
            assertEquals(2, test.size());
            
        } catch (Exception ex)
        {
            fail(ex.getMessage());

        }
    }
    
    
    @Test
    public void testGetCompeptitionResult()
    {
        try
        {
            Member m = controller.getMember("1507053333");
            assertNotNull(controller.getCompetitionResult(m));
            ArrayList<CompetitionResult> test = controller.getCompetitionResult(m);
            assertEquals(Disciplin.CRAWL, test.get(0).getDisciplin());
            assertEquals("00:02:01", test.get(0).getTime());
            assertEquals("Holbæk svømmehal", test.get(0).getCompetition());
            assertEquals(1, test.size());
            
        } catch (Exception ex)
        {
            fail(ex.getMessage());

        }
    }

 

}
