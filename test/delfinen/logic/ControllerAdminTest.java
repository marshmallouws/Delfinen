/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.DataAccessorDatabase;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Annika Ehlers
 */
public class ControllerAdminTest {
    private ControllerAdmin c;
    private DataAccessorDatabase a;
    
    public ControllerAdminTest() {
        c = new ControllerAdmin();
    }

    /**
     * Test of getTrainingResult method, of class ControllerAdmin.
     */
    @Test
    public void testGetTrainingResult() {
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
    public void testUpdateMember() {
        try{
            Member m = c.getMember("1506952222");
            c.updateMember(m, "zipcode", "abcd");
            fail(); 
        } catch (IllegalArgumentException ex){
             //Expected   
        }
        
    }

    /**
     * Test of seeMembers method, of class ControllerAdmin.
     */
    @Test
    public void testSeeMembers() {
        System.out.println("seeMembers");
        ControllerAdmin instance = new ControllerAdmin();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.seeMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMember method, of class ControllerAdmin.
     */
    @Test
    public void testDeleteMember() {
        System.out.println("deleteMember");
        Member m = null;
        ControllerAdmin instance = new ControllerAdmin();
        instance.deleteMember(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMember method, of class ControllerAdmin.
     */
    @Test
    public void testCreateMember() {
        System.out.println("createMember");
        String firstname = "";
        String lastname = "";
        String ssn = "";
        int birthyear = 0;
        String address = "";
        String zipcode = "";
        String phone = "";
        MemberStatus memberstatus = null;
        int team_id = 0;
        ControllerAdmin instance = new ControllerAdmin();
        instance.createMember(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus, team_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seeMembersInArrears method, of class ControllerAdmin.
     */
    @Test
    public void testSeeMembersInArrears() {
        System.out.println("seeMembersInArrears");
        int year = 0;
        ControllerAdmin instance = new ControllerAdmin();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.seeMembersInArrears(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payForCurrentYear method, of class ControllerAdmin.
     */
    @Test
    public void testPayForCurrentYear() {
        System.out.println("payForCurrentYear");
        Member m = null;
        int year = 0;
        ControllerAdmin instance = new ControllerAdmin();
        instance.payForCurrentYear(m, year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
