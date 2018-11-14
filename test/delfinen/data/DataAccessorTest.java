/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
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
public class DataAccessorTest {
    private DataAccessor da;
    private DBConnector c;
    
    public DataAccessorTest() {
        try {
            DBConnector c = new DBConnector();
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
        try{
            assertNotNull(da.getMembers());
            int expected = 7;
            int actual = da.getMembers().size();
            assertEquals(expected, actual);
        } catch (DataException ex){
            fail(ex.getMessage());
        }
    }

    /**
     * Test of getMember method, of class DataAccessor.
     */
    @Test
    public void testGetMember_String() {
        try{
            
            Member m = da.getMember("0912951530");
            assertNotNull(m);
            String firstname = "Frederikke";
            String lastname = "Nilsson";
            int birthyear = 1995;
            String address = "Mosebakken 53";
            String zipcode = "2670";
            String phone = "91562665";
            MemberStatus status = MemberStatus.ACTIVE;
            Membership m_ship = Membership.SENIOR;
            MemberType type = MemberType.NONCOMPETITIVE;
            
            assertEquals(m.getFirstname(), firstname);
            assertEquals(m.getLastname(), lastname);
            assertEquals(m.getBirthyear(), birthyear);
            assertEquals(m.getAddress(), address);
            assertEquals(m.getZipcode(), zipcode);
            assertEquals(m.getPhone(), phone);
            assertEquals(m.getMemberType(), type);
            assertEquals(m.getMembership(), m_ship);
            assertEquals(m.getMemberstatus(), status);
            
        } catch (DataException ex){
            ex.getMessage();
        }
    }

    /**
     * Test of getMember method, of class DataAccessor.
     */
    @Test
    public void testGetMember_String_String() {
        Member m = da.getMember("Frederik", "Nilsson");
        
        String firstname = "Frederikke";
            String lastname = "Nilsson";
            int birthyear = 1995;
            String address = "Mosebakken 53";
            String zipcode = "2670";
            String phone = "91562665";
            MemberStatus status = MemberStatus.ACTIVE;
            Membership m_ship = Membership.SENIOR;
            MemberType type = MemberType.NONCOMPETITIVE;
            
            assertEquals(m.getFirstname(), firstname);
            assertEquals(m.getLastname(), lastname);
            assertEquals(m.getBirthyear(), birthyear);
            assertEquals(m.getAddress(), address);
            assertEquals(m.getZipcode(), zipcode);
            assertEquals(m.getPhone(), phone);
            assertEquals(m.getMemberType(), type);
            assertEquals(m.getMembership(), m_ship);
            assertEquals(m.getMemberstatus(), status);
        
    }

    /**
     * Test of getTop5 method, of class DataAccessor.
     */
    @Test
    public void testGetTop5() {
      
    }

    /**
     * Test of getTrainingResult method, of class DataAccessor.
     */
    @Test
    public void testGetTrainingResult_3args() {
        
    }

    /**
     * Test of getTrainingResult method, of class DataAccessor.
     */
    @Test
    public void testGetTrainingResult_Disciplin() {
        
    }

    /**
     * Test of getCompetitionResult method, of class DataAccessor.
     */
    @Test
    public void testGetCompetitionResult_3args() {
        
    }

    /**
     * Test of getCompetitionResult method, of class DataAccessor.
     */
    @Test
    public void testGetCompetitionResult_Disciplin() {
        
    }
    
}
