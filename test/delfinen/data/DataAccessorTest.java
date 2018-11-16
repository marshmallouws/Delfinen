/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import delfinen.logic.CompetitionResult;
import delfinen.logic.Disciplin;
import delfinen.logic.TrainingResult;
import delfinen.logic.Membership;
import delfinen.logic.Member;
import delfinen.logic.Team;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Annika Ehlers
 */
public class DataAccessorTest {

    private DataAccessor da;
    private DBConnector c;

    public DataAccessorTest() {
        try {
            c = new DBConnector();
        } catch (SQLException ex) {
            ex.getMessage();
        }

        da = new DataAccessorDataBase(c);
    }

    /**
     * Test of getMembers method, of class DataAccessor.
     */
    @Test
    public void testGetMembers() {
        try {
            assertNotNull(da.getMembers());
            int expected = 12;
            int actual = da.getMembers().size();
            assertEquals(expected, actual);
        } catch (DataException ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getMember method, of class DataAccessor.
     */
    @Test
    public void testGetMember_String() {
        try {

            Member m = da.getMember("2202014547");
            assertNotNull(m);
            String firstname = "Søren";
            String lastname = "Andersen";
            int birthyear = 2001;
            String address = "Nørregade";
            String zipcode = "2150";
            String phone = "91562665";

            assertEquals(m.getFirstname(), firstname);
            assertEquals(m.getLastname(), lastname);
            assertEquals(m.getBirthyear(), birthyear);
            assertEquals(m.getAddress(), address);
            assertEquals(m.getZipcode(), zipcode);
            assertEquals(m.getPhone(), phone);

        } catch (DataException ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getMember method, of class DataAccessor.
     */
    @Test
    public void testGetMember_String_String() {
        Member m = da.getMember("Naja", "Hansen");
        
        String ssn = "1111079930";
        String firstname = "Naja";
        String lastname = "Hansen";
        int birthyear = 2007;
        String address = "Mosevej 53"; 
        String zipcode = "2670";
        String phone = "91562665"; 
        
        assertEquals(m.getSsn(), ssn);
        assertEquals(m.getFirstname(), firstname);
        assertEquals(m.getLastname(), lastname);
        assertEquals(m.getBirthyear(), birthyear);
        assertEquals(m.getAddress(), address);
        assertEquals(m.getZipcode(), zipcode);
        assertEquals(m.getPhone(), phone);
    }

    /**
     * Test of getTop5 method, of class DataAccessor.
     */
    //Doesn't work
    @Test
    public void testGetTop5() {
        Team t = da.getTeams().get(0);
        
        ArrayList<TrainingResult> top5 = da.getTop5(Disciplin.CRAWL, t);
        
        assertEquals(top5.size(), 5);
        assertEquals(top5.get(0).getMember().getFirstname(), "Lisbeth");
        assertEquals(top5.get(0).getMember().getLastname(), "Knudsen");
    }

    /**
     * Test of getTrainingResult method, of class DataAccessor.
     */
    @Test
    public void testGetTrainingResult_3args() {
        ArrayList<TrainingResult> res = da.getTrainingResult("1506952222", Disciplin.CRAWL);
        
        String time1 = "00:01:55";
        String time2 = "00:02:30";
        assertEquals(res.get(0).getTime(), time1);
        assertEquals(res.get(1).getTime(), time2);
        
    }

    /**
     * Test of getTrainingResult method, of class DataAccessor.
     */
    @Test
    public void testGetTrainingResult_Disciplin() {
        ArrayList<TrainingResult> res = da.getTrainingResult(Disciplin.CRAWL);
        
        String time1 = "00:01:48";
        assertEquals(res.size(), 21);
        assertEquals(res.get(0).getTime(), time1);
    }

    /**
     * Test of getCompetitionResult method, of class DataAccessor.
     */
    @Test
    public void testGetCompetitionResult_3args() {
        
        ArrayList<CompetitionResult> res = da.getCompetitionResult("0412038089");
        
        String time = "00:05:01";
        assertEquals(res.get(0).getTime(), time);
    }

    /**
     * Test of getCompetitionResult method, of class DataAccessor.
     */
    @Test
    public void testGetCompetitionResult_Disciplin() {
        ArrayList<CompetitionResult> res = da.getCompetitionResult(Disciplin.CRAWL);
        
        String time1 = "00:01:50";
        assertEquals(res.size(), 6);
        assertEquals(res.get(0).getTime(), time1);
    }
}
