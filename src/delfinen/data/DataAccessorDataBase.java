package delfinen.data;

import delfinen.logic.CompetitionResult;
import delfinen.logic.CompetitionSwimmer;
import delfinen.logic.Disciplin;
import delfinen.logic.TrainingResult;
import delfinen.logic.MemberStatus;
import delfinen.logic.Member;
import delfinen.logic.Team;
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
public class DataAccessorDataBase implements DataAccessor {

    private DBConnector connector = null;

    public DataAccessorDataBase(DBConnector connector) {
        this.connector = connector;
    }

    private int updateDatabase(String query) {
        int rs = 0;
        try {
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Query not working");
            System.out.println(ex.getMessage());
        }
        return rs;
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

    private ArrayList<Member> retrieveMembersData(ResultSet rs) {
        String ssn = "";
        String firstname = "";
        String lastname = "";
        int birthyear = 0;
        String address = "";
        String zipcode = "";
        String phone = "";
        String status = "";
        int team_id = 0;

        ArrayList<Member> members = new ArrayList<>();
        ArrayList<CompetitionSwimmer> com_sw = new ArrayList<>();

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
                team_id = rs.getInt("team_id");

                MemberStatus stat = MemberStatus.valueOf(status.toUpperCase());

                if (team_id == 0) {
                    members.add(new Member(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat));
                } else {
                    members.add(new CompetitionSwimmer(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return members;
    }
    
    private ArrayList<CompetitionSwimmer> retrieveCompSwimmerData(ResultSet rs){
        ArrayList<CompetitionSwimmer> c = new ArrayList<>();
        
        String ssn = "";
        String firstname = "";
        String lastname = "";
        int birthyear = 0;
        String address = "";
        String zipcode = "";
        String phone = "";
        String status = "";
        int team_id = 0;

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
                team_id = rs.getInt("team_id");

                MemberStatus stat = MemberStatus.valueOf(status.toUpperCase());

                if (team_id != 0) {
                    c.add(new CompetitionSwimmer(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    @Override
    public ArrayList<Member> getMembers() throws DataException {
        String query = "SELECT ssn, firstname, lastname, birthyear, address,"
                + "zipcode, phone, memberstatus, team_id FROM member;";

        ResultSet r = query(query);
        ArrayList<Member> members = retrieveMembersData(r);
        return members;
    }
    
    @Override
    public ArrayList<CompetitionSwimmer> getComptitionSwimmers() {
        String query = "SELECT ssn, firstname, lastname, birthyear, address, "
                + "zipcode, phone, memberstatus, team_id FROM member;";
        
        ResultSet r = query(query);
        ArrayList<CompetitionSwimmer> sw = retrieveCompSwimmerData(r);
        return sw;
    }

    @Override
    public Member getMember(String ssn) throws DataException {
        String query = "SELECT ssn, firstname, lastname, birthyear, "
                + "address, zipcode, phone, memberstatus, team_id FROM member WHERE ssn ='" + ssn + "';";
        ResultSet r = query(query);
        ArrayList<Member> members = retrieveMembersData(r);

        if (members.get(0) instanceof CompetitionSwimmer) {
            Member m = members.get(0);
            return new CompetitionSwimmer(m.getFirstname(), m.getLastname(), m.getSsn(),
                    m.getBirthyear(), m.getAddress(), m.getZipcode(), m.getPhone(), m.getMemberstatus());
        } else {
            return members.get(0);
        }
    }
    
    @Override
    public Member getMember(String firstname, String lastname) {
        String query = "SELECT ssn, firstname, lastname, birthyear, "
                + "address, zipcode, phone, memberstatus, team_id FROM member WHERE "
                + "firstname = '" + firstname + "' AND lastname ='" + lastname + "';";

        ResultSet r = query(query);
        ArrayList<Member> members = retrieveMembersData(r);
        return members.get(0);
    }

    @Override
    //TODO - strip arraylist to size 5
    public ArrayList<TrainingResult> getTop5(Disciplin disciplin, Team team) {
        String query = "SELECT MIN(sw_time) AS time, sw_date, firstname, lastname, ssn, birthyear, "
                + "address, zipcode, phone, memberstatus, team_id "
                + "FROM training_result "
                + "JOIN member ON member_id = member.id "
                + "WHERE discipline = '" + disciplin + "'"
                + "AND team_name = '" + team.getTeamname() + "' "
                + "GROUP BY member_id "
                + "ORDER BY MIN(sw_time);";

        ResultSet r = query(query);

        ArrayList<TrainingResult> res = new ArrayList<>();
        ArrayList<Member> members = retrieveMembersData(r);

        String time = null;
        String date = null;
        int i = 0;

        try {
            r.beforeFirst();
            while (r.next()) {
                if (i > members.size()) {
                    break;
                }

                time = r.getString("time");
                date = r.getString("sw_date");

                res.add(new TrainingResult(members.get(i), disciplin, date, time));

                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (res.size() > 5) {
            ArrayList<TrainingResult> res5 = new ArrayList<>();
            res5.add(res.get(0));
            res5.add(res.get(1));
            res5.add(res.get(2));
            res5.add(res.get(3));
            res5.add(res.get(4));

            return res5;
        }

        return res;
    }

    @Override
    public ArrayList<TrainingResult> getTrainingResult(String ssn, Disciplin d) {
        String query = "SELECT ssn, firstname, lastname, birthyear, address, zipcode, phone, "
                + "memberstatus, sw_time, sw_date, team_id, discipline "
                + "FROM member "
                + "JOIN training_result ON member_id = member.id "
                + "WHERE ssn = '" + ssn + "' "
                + "AND discipline = '" + d + "' "
                + "ORDER BY sw_time ASC;";

        ResultSet r = query(query);

        ArrayList<TrainingResult> res = new ArrayList<>();
        ArrayList<Member> members = retrieveMembersData(r);

        String time = null;
        String date = null;
        int i = 0;

        try {
            r.beforeFirst();
            while (r.next()) {
                if (i > members.size()) {
                    break;
                }

                time = r.getString("sw_time");
                date = r.getString("sw_date");

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
        String query = "SELECT ssn, firstname, lastname, birthyear, address, zipcode, phone, "
                + "memberstatus, sw_time, sw_date, discipline "
                + "FROM member "
                + "JOIN training_result ON member_id = member.id "
                + "WHERE discipline = '" + d + "' "
                + "ORDER BY sw_time ASC;";
        ResultSet r = query(query);

        ArrayList<TrainingResult> res = new ArrayList<>();
        ArrayList<Member> members = retrieveMembersData(r);

        String time = null;
        String date = null;
        int i = 0;

        try {
            r.beforeFirst();
            while (r.next()) {
                if (i > members.size()) {
                    break;
                }

                time = r.getString("sw_time");
                date = r.getString("sw_date");

                res.add(new TrainingResult(members.get(i), d, date, time));

                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res;
    }

    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(String ssn, Disciplin d) {
        String query = "SELECT ssn, firstname, lastname, birthyear, address, zipcode, phone, "
                + "memberstatus, competition, sw_rank, sw_time, discipline, team_id "
                + "FROM member "
                + "JOIN comp_result ON member_id = member.id "
                + "WHERE ssn = '" + ssn + "' "
                + "AND discipline = '" + d + "';";

        ResultSet r = query(query);

        ArrayList<CompetitionResult> res = new ArrayList<>();
        ArrayList<Member> members = retrieveMembersData(r);

        String time = null;
        String name = "";
        int rank = 0;
        int i = 0;

        try {
            r.beforeFirst();
            while (r.next()) {
                if (i > members.size()) {
                    break;
                }

                time = r.getString("sw_time");
                name = r.getString("competition");

                res.add(new CompetitionResult(members.get(i), name, rank, time, d));

                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res;
    }

    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(Disciplin d) {
        String query = "SELECT ssn, firstname, lastname, birthyear, address, zipcode, phone, "
                + "memberstatus, competition, sw_rank, sw_time, discipline, team_id "
                + "FROM member "
                + "JOIN comp_result ON member_id = member.id "
                + "WHERE discipline = '" + d + "' "
                + "ORDER BY sw_time ASC; ";

        ResultSet r = query(query);

        ArrayList<CompetitionResult> res = new ArrayList<>();
        ArrayList<Member> members = retrieveMembersData(r);
        String time = null;
        String name = "";
        int rank = 0;
        int i = 0;

        try {
            r.beforeFirst();
            while (r.next()) {
                if (i > members.size()) {
                    break;
                }

                time = r.getString("sw_time");
                name = r.getString("competition");

                res.add(new CompetitionResult(members.get(i), name, rank, time, d));

                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res;
    }

    @Override
    public void updateMember(String ssn, String change, String field) {
        String query = "UPDATE member SET " + field + " = '" + change + "' WHERE ssn = '" + ssn + "';";
        updateDatabase(query);
    }

}
