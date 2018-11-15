package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessor;
import delfinen.data.DataAccessorDataBase;
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
            assertNotNull(controller.getMember("1506952222"));
            Member m = controller.getMember("1506952222");
            assertEquals("Oline", m.getFirstname());
            assertEquals("Sørensen", m.getLastname());
            assertEquals(MemberType.COMPETITIVE, m.getMemberType());
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
            assertEquals("Oline", m.get(0).getFirstname());
            assertEquals("Sørensen", m.get(0).getLastname());
            assertEquals("2670", m.get(1).getZipcode());
            assertEquals("Mosebakken 53", m.get(1).getAddress());
            assertEquals(12, m.size());
        } catch (Exception ex)
        {
            fail(ex.getMessage());

        }
    }

 

}
