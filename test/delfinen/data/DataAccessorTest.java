/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import delfinen.logic.CompetitionResult;
import delfinen.logic.Disciplin;
import delfinen.logic.TrainingResult;
import delfinen.logic.Member;
import delfinen.logic.MemberStatus;
import delfinen.logic.Team;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Annika Ehlers
 */
public class DataAccessorTest {

    private DataAccessorDatabase da;
    private DBConnector c;

    public DataAccessorTest() {
        try {
            c = new DBConnector();
        } catch (SQLException ex) {
            ex.getMessage();
        }

        da = new DataAccessorDatabase(c);
    }

    /**
     * Test of getMembers method, of class DataAccessor.
     */
    @Test
    public void testGetMembers() throws DataException {
        assertNotNull(da.getMembers());
        int expected = 12;
        int actual = da.getMembers().size();
        assertEquals(expected, actual);
    }

    /**
     * Test of getMember method, of class DataAccessor.
     */
    @Test
    public void testGetMember_String() throws DataException {
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
    
    @Test
    public void testCreateMember(){
        String first = "Lise";
        String last = "Lotte";
        String ssn = "1506951234";
        int year = 1998;
        String add = "Hejvej 1";
        String zip = "2550";
        String phone = "53388469";
        MemberStatus s = MemberStatus.ACTIVE;
        int team = 1;
        
        Member m = null;
        da.createMember(first, last, ssn, year, add, zip, phone, s, team);
        try {
            m = da.getMember("1506951234");
        } catch (DataException ex) {
            ex.printStackTrace();
        }
        
        assertEquals(m.getFirstname(), first);
        assertEquals(m.getLastname(), last);
        assertEquals(m.getSsn(), ssn);
        
        da.removeMember(m);
    }
    
    /*
    @Test
    public void testCreateTrainingResult(){
        Member m = null;
        try {
            m = da.getMember("1506952222");
        } catch (DataException ex) {
            ex.printStackTrace();
        }
        String date = "2013-11-21";
        String time = "00:09:11";
        
        da.createTrainingResult(m, Disciplin.CRAWL, date, time);
        ArrayList<TrainingResult> r = da.getTrainingResult(m.getSsn(), Disciplin.CRAWL);
        TrainingResult t = r.get(r.size()-1);
        
        assertEquals(t.getTime(), time);
        assertEquals(t.getMember().getSsn(), m.getSsn());
        
    } */
    
    /*
    @Test
    public void testCreateCompetitionResult(){
        Member m = null; 
        try {
            m = da.getMember("0809021121");
        } catch (DataException ex) {
            ex.printStackTrace();
        }
        
        String time = "00:05:56";
        da.createCompetitionResult(m, "Sundby bad", 8, time, Disciplin.CRAWL);
        ArrayList<CompetitionResult> c = da.getCompetitionResult(m.getSsn());
        CompetitionResult r = c.get(c.size()-1);
        
        assertEquals(r.getTime(), time);
        assertEquals(r.getMember().getSsn(), m.getSsn());
    } */
    
    @Test 
    public void testGetTeams(){
        ArrayList<Team> teams = da.getTeams();
        int expected = 2;
        int actual = teams.size();
        
        assertEquals(actual, expected);
    }
    
    @Test
    public void testUpdateMember(){
        String change = "Peiter";
        Member m = null;
        String name = "";
        try {
            m = da.getMember("0412038089");
            da.updateMember(m.getSsn(), change, "firstname");
            name = m.getFirstname();
        } catch (DataException ex) {
            ex.printStackTrace();
        }
        
        assertEquals(m.getFirstname(), change);
        
        //da.updateMember(m.getSsn(), name, "firstname");
    }
    
    @Test
    public void testPayment(){
        Member m = null;
        int year = 0;
        try {
            m = da.getMember("1506952222");
        } catch (DataException ex) {
            fail();
        }
        year = m.getLastPayment();
        assertNotNull(m);
        da.updatePayment(m.getSsn(), 2020);
        
        //assertEquals(m.getLastPayment(), 2020);
        //da.updatePayment(m.getSsn(), year);
        
    }
    
}
