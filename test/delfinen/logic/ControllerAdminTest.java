/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Annika Ehlers
 */
public class ControllerAdminTest {
    private ControllerAdmin c;
    
    public ControllerAdminTest() {
        c = new ControllerAdmin();
    }

    /**
     * Test of getTrainingResult method, of class ControllerAdmin.
     */
    @Test
    public void TestGetTrainingResult() {
        Member m = c.getMember("1506952222");
        ArrayList<TrainingResult> r = c.getTrainingResult(m, Disciplin.CRAWL);
        
        String time = "00:01:55";
        assertEquals(r.size(), 2);
        assertEquals(r.get(0).getTime(), time);
    }

    /**
     * Test of getCompetitionResult method, of class ControllerAdmin.
     */
    @Test
    public void testGetCompetitionResult() {
        Member m = c.getMember("0412038089");
        ArrayList<CompetitionResult> r = c.getCompetitionResult(m);
        
        String time = "00:05:01";
        assertEquals(r.size(), 2);
        assertEquals(r.get(0).getTime(), time);
    }
    
    /**
     * Test of updateMember method, of class ControllerAdmin.
     */
    @Test
    public void TestUpdateMember() {
        try{
            Member m = c.getMember("1506952222");
            c.updateMember(m, "zipcode", "1234");
        } catch (IllegalArgumentException ex){
            
        }
    }

    /**
     * Test of seeMembers method, of class ControllerAdmin.
     */
    @Test
    public void testSeeMembers() {
        ArrayList<Member> members = c.seeMembers();
        assertNotNull(members);
        assertEquals(members.size(), 12);
        assertEquals(members.get(0).getSsn(),"1506952222");
    }
    

    /**
     * Test of createMember method, of class ControllerAdmin.
     */
    @Test
    public void testCreateMember() {
        Member m = null;
        try {
            String firstname = "Hans";
            String lastname = "Sørensen";
            String ssn = "1234567890";
            int birthyear = 1990;
            String address = "Hejvej 1";
            String zip = "1234";
            String phone = "54455445";
            int team = 1;
            MemberStatus a = MemberStatus.ACTIVE;
            
            c.createMember(firstname, lastname, ssn, birthyear, address, zip, phone, a, team);
            m = c.getMember(ssn);
        } catch (IllegalArgumentException ex) {
            fail();
        }
        
        c.deleteMember(m);
    }
    
    /**
     * Test of createMember method, of class ControllerAdmin.
     */
    @Test
    public void NegativeTestCreateMember() {
        Member m = null;
        try {
            String firstname = "Hans";
            String lastname = "Sørensen";
            String ssn = "1234567891";
            int birthyear = 1990;
            String address = "Hejvej 1";
            String zip = "22222";
            String phone = "54455445";
            int team = 1;
            MemberStatus a = MemberStatus.ACTIVE;
            
            c.createMember(firstname, lastname, ssn, birthyear, address, zip, phone, a, team);
            fail();
        } catch (IllegalArgumentException ex) {
            //Expected
        }
    }

    /**
     * Test of seeMembersInArrears method, of class ControllerAdmin.
     */
    @Test
    public void testSeeMembersInArrears() {
        ArrayList<Member> m = c.seeMembersInArrears(2018);
        assertNotNull(m);
        assertEquals(m.size(), 11);
        
    }

    /**
     * Test of payForCurrentYear method, of class ControllerAdmin.
     */
    @Test
    public void testPayForCurrentYear() {
        Member m = c.getMember("1506952222");
        c.payForCurrentYear(m, 2018);
        ArrayList<Integer> years = m.getYearsPaid();
        int last = years.size()-1;
        assertEquals((int)years.get(last), 2018);
    }
    
}
