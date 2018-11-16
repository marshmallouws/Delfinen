/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessor;
import delfinen.data.DataAccessorDataBase;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sofieamalielandt
 */
public class MemberTest
{
     private ControllerMember controller;
    private DataAccessor data;
    
    public MemberTest() throws SQLException
    {
        data = new DataAccessorDataBase(new DBConnector());
        controller = new ControllerMember(data);
    }
    
     @Test
    public void testCalculateS()
    {
        try
        {
            Member m = controller.getMember("1506952222");
            double test = m.calculateS();
            assertEquals(1600, test, 0);
            
            Member m2 = controller.getMember("1111079930");
            double test2 = m2.calculateS();
            assertEquals(1000, test2, 0);

            m.setMemberstatus(MemberStatus.PASSIVE);
            double test3 = m.calculateS();
            assertEquals(500, test3, 0);

        } catch (Exception ex)
        {
            fail(ex.getMessage());
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCalculateS()
    {

        Member m = new Member("Sonja", "Hansen", "0609190532", 2019, "Højbjergvej 2", "4600", "42446221", MemberStatus.ACTIVE);
        m.calculateS();

    }

    
}
