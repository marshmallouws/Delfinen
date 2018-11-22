package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDatabase;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerMember extends Controller {

    private DBConnector c;
    private DataAccessorDatabase data;

    public ControllerMember() {
        try {
            c = new DBConnector();
            data = new DataAccessorDatabase(c);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param ssn used to search for member
     * @return a member
     */
    public Member getMember(String ssn) {
        try {
            Member member = data.getMember(ssn);
            return member;
        } catch (Exception ex) {
            System.out.println("Member not found");
            return null;

        }

    }

    /**
     *
     * @return a list of members
     */
    public ArrayList<Member> getMembers() {
        try {
            ArrayList<Member> members = data.getMembers();
            return members;

        } catch (Exception ex) {
            System.out.println("Members not found");
            return null;

        }
    }
}
