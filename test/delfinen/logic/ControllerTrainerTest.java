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

    @Test
    public void testMakeTeams()
    {
        try
        {
            ArrayList<Team> teams = controller.getTeams();
            assertEquals(true, teams.get(0).getSwimmers().isEmpty());
            assertEquals(true, teams.get(1).getSwimmers().isEmpty());
            controller.makeTeams(teams);
            assertEquals(false, teams.get(0).getSwimmers().isEmpty());
            assertEquals(false, teams.get(1).getSwimmers().isEmpty());
            assertEquals(Membership.JUNIOR, teams.get(1).getSwimmers().get(0).getMembership());
            assertEquals(Membership.SENIOR, teams.get(0).getSwimmers().get(0).getMembership());
        } catch (Exception ex)
        {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testTop5()
    {
        try
        {
            ArrayList<Team> teams = controller.getTeams();
            ArrayList<TrainingResult> t = controller.top5(teams.get(1), Disciplin.BACKCRAWL);
            assertEquals("2017-11-10", t.get(0).getDate());
            assertEquals("00:01:00", t.get(0).getTime());
            assertEquals("Hans", t.get(1).getMember().getFirstname());

            ArrayList<TrainingResult> t1 = controller.top5(teams.get(0), Disciplin.BUTTERFLY);
            assertEquals("2018-11-13", t1.get(0).getDate());
            assertEquals("00:04:30", t1.get(0).getTime());
            assertEquals("Åge", t1.get(1).getMember().getFirstname());

            ArrayList<TrainingResult> t2 = controller.top5(teams.get(0), Disciplin.BREASTSTROKE);
            assertEquals("2018-11-13", t2.get(1).getDate());
            assertEquals("00:06:21", t2.get(2).getTime());
            assertEquals("1804955455", t2.get(2).getMember().getSsn());

            ArrayList<TrainingResult> t3 = controller.top5(teams.get(1), Disciplin.CRAWL);
            assertEquals("2017-11-10", t3.get(4).getDate());
            assertEquals("00:01:55", t3.get(1).getTime());
            assertEquals("2202014547", t3.get(1).getMember().getSsn());
        } catch (Exception ex)
        {
            fail(ex.getMessage());
        }
    }

}
