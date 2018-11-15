package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessor;
import delfinen.data.DataAccessorDataBase;
import delfinen.data.Member;
import delfinen.data.MemberStatus;
import delfinen.data.MemberType;
import java.sql.SQLException;
import java.util.ArrayList;
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
            assertNotNull(controller.getMember("0912951530"));
            Member m = controller.getMember("0912951530");
            assertEquals("Frederikke", m.getFirstname());
            assertEquals("Nilsson", m.getLastname());
            assertEquals(MemberType.NONCOMPETITIVE, m.getMemberType());
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
            assertEquals("Frederikke", m.get(0).getFirstname());
            assertEquals("Nilsson", m.get(0).getLastname());
            assertEquals("2635", m.get(1).getZipcode());
            assertEquals("Vejlegården 6", m.get(1).getAddress());
            assertEquals(2, m.size());
        } catch (Exception ex)
        {
            fail(ex.getMessage());

        }
    }

    @Test
    public void testCalculateS()
    {
        try
        {
            Member m = controller.getMember("0912951530");
            double test = controller.calculateS(m);
            assertEquals(1600, test, 0);
            
            Member m2 = new Member("Sonja", "Hansen", "0609190532", 2001, "Højbjergvej 2", "4600", "42446221", MemberStatus.ACTIVE, MemberType.COMPETITIVE);
            double test2 = controller.calculateS(m2);
            assertEquals(1000, test2, 0);

            m.setMemberstatus(MemberStatus.PASSIVE);
            double test3 = controller.calculateS(m);
            assertEquals(500, test3, 0);

        } catch (Exception ex)
        {
            fail(ex.getMessage());
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCalculateS()
    {

        Member m = new Member("Sonja", "Hansen", "0609190532", 2019, "Højbjergvej 2", "4600", "42446221", MemberStatus.ACTIVE, MemberType.COMPETITIVE);
        controller.calculateS(m);

    }

}
