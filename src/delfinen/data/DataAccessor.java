package delfinen.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author sofieamalielandt
 */
public class DataAccessor implements DataAccessorInterface {

    private DBConnector connector = null;

    public DataAccessor(DBConnector connector) {
        this.connector = connector;
    }

    private ResultSet query(String query) {
        ResultSet rs = null;
        try {
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Query not working");
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    private ArrayList<Member> membersData(ResultSet rs) {
        String ssn = "";
        String firstname = "";
        String lastname = "";
        int birthyear = 0;
        String address = "";
        String zipcode = "";
        String phone = "";
        String status = "";
        String membership = "";
        String type = "";

        ArrayList<Member> members = new ArrayList<>();

        try {
            while (rs.next()) {
                ssn = rs.getString("ssn");
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
                birthyear = rs.getInt("birthyear");
                address = rs.getString("address");
                zipcode = rs.getString("zipcode");
                phone = rs.getString("phone");
                status = rs.getString("memberstatus");
                membership = rs.getString("membership");
                type = rs.getString("membertype");

                MemberStatus stat = MemberStatus.valueOf(status.toUpperCase());
                Membership mem = Membership.valueOf(membership.toUpperCase());
                MemberType ty = MemberType.valueOf(type.toUpperCase());

                members.add(new Member(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat, mem, ty));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return members;
    }

    public ArrayList<Member> getMembers() {
        String query = "SELECT ssn, firstname, lastname, birthyear, address,"
                + "zipcode, phone, memberstatus, membership, membertype FROM member;";

        ResultSet r = query(query);
        ArrayList<Member> members = membersData(r);
        return members;
    }

    public Member getMember(String ssn) {
        String query = "SELECT ssn, firstname, lastname, birthyear, "
                + "address, zipcode, phone, memberstatus, membership, membertype FROM member WHERE ssn ='" + ssn + "';";
        ResultSet r = query(query);
        ArrayList<Member> members = membersData(r);
        return members.get(0);
    }

    public CompetitionSwimmer getComptitionSwimmer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Member getMember(String firstname, String lastname) {
        String query = "SELECT ssn, firstname, lastname, birthyear, "
                + "address, zipcode, phone, memberstatus, membership, membertype FROM member WHERE "
                + "firstname = '" + firstname + "' AND lastname ='" + lastname + "';";

        ResultSet r = query(query);
        ArrayList<Member> members = membersData(r);
        return members.get(0);
    }

    @Override
    //TODO - strip arraylist to size 5
    public ArrayList<TrainingResult> getTop5(Disciplin disciplin, Membership membership) {
        String query = "SELECT training_result.sw_time, training_result.sw_date, discipline, "
                + "member.firstname, lastname, ssn, birthyear, address, zipcode, "
                + "phone, memberstatus, membership, membertype "
                + "FROM member "
                + "JOIN training_result ON member_id = member.id "
                + "INNER JOIN "
                + "(SELECT firstname, MIN(sw_time) AS time FROM member "
                + "JOIN training_result ON member_id = member.id "
                + "GROUP BY firstname) top_time "
                + "ON member.firstname = top_time.firstname "
                + "AND training_result.sw_time = top_time.time "
                + "WHERE discipline = '" + disciplin.toString() + "';";

        ResultSet r = query(query);

        ArrayList<TrainingResult> res = new ArrayList<>();
        ArrayList<Member> members = membersData(r);

        Time time = null;
        Date date = null;
        int i = 0;

        try {
            r.beforeFirst();
            while (r.next()) {
                if (i > members.size()) {
                    break;
                }

                time = r.getTime("sw_time");
                date = r.getDate("sw_date");

                res.add(new TrainingResult(members.get(i), disciplin, date, time));

                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if(res.size() < 5){
            return (ArrayList<TrainingResult>) res.subList(0, 6);
        }

        return res;
    }

    @Override
    public ArrayList<TrainingResult> getTrainingResult(String firstname, String lastname, Disciplin d) {
        String query = "SELECT ssn, firstname, lastname, birthyear, address, zipcode, phone, "
                + "memberstatus, membership, membertype, sw_time, sw_date, discipline "
                + "FROM member "
                + "JOIN training_result ON member_id = member.id "
                + "WHERE firstname = '" + firstname + "' AND lastname = '" + lastname + "' "
                + "AND discipline = '" + d + "' "
                + "ORDER BY sw_time ASC;";
        
        ResultSet r = query(query);

        ArrayList<TrainingResult> res = new ArrayList<>();
        ArrayList<Member> members = membersData(r);

        Time time = null;
        Date date = null;
        int i = 0;

        try {
            r.beforeFirst();
            while (r.next()) {
                if (i > members.size()) {
                    break;
                }

                time = r.getTime("sw_time");
                date = r.getDate("sw_date");

                res.add(new TrainingResult(members.get(i), d, date, time));

                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res;
    }

    @Override
    public ArrayList<TrainingResult> getTrainingResult(Disciplin d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(String firstname, String lastname, Disciplin d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(Disciplin d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}