/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Annika Ehlers
 */
public class MemberTest {
    
    public MemberTest() {
    }
    

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int year = 0;
        Member instance = null;
        int expResult = 0;
        int result = instance.getAge(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Member.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Member instance = null;
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZipcode method, of class Member.
     */
    @Test
    public void testSetZipcode() {
        System.out.println("setZipcode");
        String zipcode = "";
        Member instance = null;
        instance.setZipcode(zipcode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Member.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Member instance = null;
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMemberstatus method, of class Member.
     */
    @Test
    public void testSetMemberstatus() {
        System.out.println("setMemberstatus");
        MemberStatus memberstatus = null;
        Member instance = null;
        instance.setMemberstatus(memberstatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMembertype method, of class Member.
     */
    @Test
    public void testSetMembertype() {
        System.out.println("setMembertype");
        MemberType membertype = null;
        Member instance = null;
        instance.setMembertype(membertype);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class Member.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        Member instance = null;
        String expResult = "";
        String result = instance.getFirstname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class Member.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        Member instance = null;
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSsn method, of class Member.
     */
    @Test
    public void testGetSsn() {
        System.out.println("getSsn");
        Member instance = null;
        String expResult = "";
        String result = instance.getSsn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Member.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Member instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZipcode method, of class Member.
     */
    @Test
    public void testGetZipcode() {
        System.out.println("getZipcode");
        Member instance = null;
        String expResult = "";
        String result = instance.getZipcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Member.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Member instance = null;
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYearsPaid method, of class Member.
     */
    @Test
    public void testGetYearsPaid() {
        System.out.println("getYearsPaid");
        Member instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getYearsPaid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemberstatus method, of class Member.
     */
    @Test
    public void testGetMemberstatus() {
        System.out.println("getMemberstatus");
        Member instance = null;
        MemberStatus expResult = null;
        MemberStatus result = instance.getMemberstatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMembership method, of class Member.
     */
    @Test
    public void testGetMembership() {
        System.out.println("getMembership");
        Member instance = null;
        Membership expResult = null;
        Membership result = instance.getMembership();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMembertype method, of class Member.
     */
    @Test
    public void testGetMembertype() {
        System.out.println("getMembertype");
        Member instance = null;
        MemberType expResult = null;
        MemberType result = instance.getMemberType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
