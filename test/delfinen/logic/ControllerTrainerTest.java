package delfinen.logic;

import delfinen.data.DataAccessorDatabase;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTrainerTest
{

    private ControllerTrainer controller;
    private DataAccessorDatabase data;

    public ControllerTrainerTest() throws SQLException
    {
        controller = new ControllerTrainer();

    }

    /**
     * Test of getSwimmers method, of class ControllerTrainer.
     */
    @Test
    public void testGetSwimmers()
    {
        try
        {
            assertNotNull(controller.getSwimmers());
            ArrayList<CompetitionSwimmer> s = controller.getSwimmers();
            assertEquals("Åge", s.get(1).getFirstname());
            assertEquals("Olsen", s.get(1).getLastname());
            assertEquals("2670", s.get(2).getZipcode());
            assertEquals("Mosebakken 53", s.get(2).getAddress());
            assertEquals(2017, s.get(2).getLastPayment());
            assertEquals(11, s.size());
        } catch (Exception ex)
        {
            fail(ex.getMessage());

        }
    }

    /**
     * Test of updateMember method, of class ControllerTrainer.
     */
    @Test
    public void testUpdateMember()
    {
        System.out.println("updateMember");
        Member m = null;
        String field = "";
        String change = "";
        ControllerTrainer instance = new ControllerTrainer();
        instance.updateMember(m, field, change);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeams method, of class ControllerTrainer.
     */
    @Test
    public void testGetTeams()
    {
        try
        {
            assertNotNull(controller.getTeams());
            ArrayList<Team> teams = controller.getTeams();
            assertEquals("junior", teams.get(1).getTeamname());
            assertEquals("senior", teams.get(0).getTeamname());
            assertEquals(2, teams.size());
        } catch (Exception ex)
        {
            fail(ex.getMessage());
        }

    }

    /**
     * Test of makeTeams method, of class ControllerTrainer.
     */
    @Test
    public void testMakeTeams()
    {
        System.out.println("makeTeams");
        ArrayList<Team> teams = null;
        ControllerTrainer instance = new ControllerTrainer();
        instance.makeTeams(teams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of top5 method, of class ControllerTrainer.
     */
    @Test
    public void testTop5()
    {
        try
        {
            ArrayList<Team> teams = controller.getTeams();
            ArrayList<TrainingResult> t = controller.top5(teams.get(1), Disciplin.BACKCRAWL);
            assertEquals("2018-10-13", t.get(0).getDate());
            assertEquals("00:02:20", t.get(0).getTime());
            assertEquals("Åge", t.get(1).getMember().getFirstname());
        } catch (Exception ex)
        {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of registerTraining method, of class ControllerTrainer.
     */
    @Test
    public void testRegisterTraining()
    {
        System.out.println("registerTraining");
        CompetitionSwimmer s = null;
        String date = "";
        String time = "";
        Disciplin d = null;
        ControllerTrainer instance = new ControllerTrainer();
        instance.registerTraining(s, date, time, d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerCompetition method, of class ControllerTrainer.
     */
    @Test
    public void testRegisterCompetition()
    {
        System.out.println("registerCompetition");
        CompetitionSwimmer s = null;
        String competition = "";
        int rank = 0;
        String time = "";
        Disciplin disciplin = null;
        ControllerTrainer instance = new ControllerTrainer();
        instance.registerCompetition(s, competition, rank, time, disciplin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
