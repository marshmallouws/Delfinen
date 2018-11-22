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
import java.util.Calendar;

/**
 *
 * @author sofieamalielandt
 */
public class DataAccessorDatabase  {

    private DBConnector connector = null;

    public DataAccessorDatabase(DBConnector connector) {
        this.connector = connector;
    }

    /**
     * 
     * @param query a query in MySQL format.
     * @return 0 if the query fails and 1 if the query succeeds
     */
    private int updateDatabase(String query) throws DataException {
        int rs = 0;
        try {
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return rs;
    }

    /**
     * 
     * @param query a query in MySQL format.
     * @return ResultSet with the data that the query retrieves.
     */
    private ResultSet query(String query) throws DataException {
        ResultSet rs = null;
        try {
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return rs;
    }

    /**
     * 
     * @param rs ResultSet with data
     * @return ArrayList of members
     */
    private ArrayList<Member> retrieveMembersData(ResultSet rs) throws DataException {
        String ssn = "";
        String firstname = "";
        String lastname = "";
        int birthyear = 0;
        String address = "";
        String zipcode = "";
        String phone = "";
        int lastPayment = 0;
        String status = "";
        int team_id = 0;

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
                lastPayment = rs.getInt("last_payment");
                status = rs.getString("memberstatus");
                team_id = rs.getInt("team_id");

                MemberStatus stat = MemberStatus.valueOf(status.toUpperCase());

                if (team_id == 0) {
                    members.add(new Member(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat, lastPayment));
                } else {
                    members.add(new CompetitionSwimmer(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat, lastPayment));
                }
            }
        } catch (SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return members;
    }
    
     /**
     * 
     * @param rs ResultSet with data
     * @return ArrayList of CompetitionSwimmers
     */
    private ArrayList<CompetitionSwimmer> retrieveCompSwimmerData(ResultSet rs) throws DataException {
        ArrayList<CompetitionSwimmer> c = new ArrayList<>();
        
        String ssn = "";
        String firstname = "";
        String lastname = "";
        int birthyear = 0;
        String address = "";
        String zipcode = "";
        String phone = "";
        int lastPayment = 0;
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
                lastPayment = rs.getInt("last_payment");
                status = rs.getString("memberstatus");
                team_id = rs.getInt("team_id");

                MemberStatus stat = MemberStatus.valueOf(status.toUpperCase());

                if (team_id != 0) {
                    c.add(new CompetitionSwimmer(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat, lastPayment));
                }
            }
        } catch (SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return c;
    }

    /**
     * 
     * @return ArrayList of all members in the database
     * @throws DataException
     */
    public ArrayList<Member> getMembers() throws DataException {
        String query = "SELECT * FROM member;"; 

        ResultSet r = query(query);
        ArrayList<Member> members = retrieveMembersData(r);
        return members;
    }
    
    /**
     * 
     * @return an ArrayList of all CompetitionSwimmers in the database
     */

    public ArrayList<CompetitionSwimmer> getComptitionSwimmers() throws DataException {
        String query = "SELECT * FROM member;"; 
        
        ResultSet r = query(query);
        ArrayList<CompetitionSwimmer> sw = retrieveCompSwimmerData(r);
        return sw;
    }

    /**
     * 
     * @param ssn is used to search for a specific Member
     * @return the member with the given ssn.
     * @throws DataException 
     */

    public Member getMember(String ssn) throws DataException {
        String query = "SELECT * FROM member "
                + "WHERE ssn ='" + ssn + "';";
        
        ResultSet r = query(query);
        ArrayList<Member> members = retrieveMembersData(r);
        CompetitionSwimmer c = null;

        if (members.get(0) instanceof CompetitionSwimmer) {
            try {
                Member m = members.get(0);
                return new CompetitionSwimmer(m.getFirstname(), m.getLastname(), m.getSsn(),
                        m.getBirthyear(), m.getAddress(), m.getZipcode(), m.getPhone(), m.getMemberstatus(), m.getLastPayment());
            } catch (SQLException ex) {
                System.out.println("Competitionswimmer not found");
                return null;
            }
        } else {
            return members.get(0);
        }
    }
    
    /**
     * 
     * @param firstname used to search for Member
     * @param lastname used to search for Member
     * @return Member with the given first- and lastname
     */
    public Member getMember(String firstname, String lastname) throws DataException {
        String query = "SELECT * FROM member "
                + "WHERE firstname = '" + firstname + "' AND lastname ='" + lastname + "';";

        ResultSet r = query(query);
        ArrayList<Member> members = retrieveMembersData(r);
        return members.get(0);
    }

    /**
     * 
     * @param disciplin used to tell which discipline the top 5 is from
     * @param team used to say if it is senior or junior team
     * @return a list of top 5 training results with given parameters
     */
    public ArrayList<TrainingResult> getTop5(Disciplin disciplin, Team team) throws DataException {
        String query = "SELECT member_id, MIN(sw_time) AS time, sw_date, firstname, lastname, ssn, birthyear, "
                + "address, zipcode, phone, memberstatus, last_payment, team_id "
                + "FROM training_result "
                + "JOIN member ON member_id = member.id "
                + "JOIN team ON team_id = team.id "
                + "WHERE discipline = '" + disciplin + "'"
                + "AND team_name = '" + team.getTeamname() + "' "
                + "GROUP BY member_id, firstname, team_name, sw_date "
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
    /**
     * 
     * @param ssn used to search for members training result
     * @param d used to search  in specific disciplin
     * @return a list of training result
     */

    public ArrayList<TrainingResult> getTrainingResult(String ssn, Disciplin d) throws DataException {
        String query = "SELECT member.*, sw_time, sw_date, discipline FROM member "
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

    /**
     * 
     * @param d Used to search for training result in specific disciplin
     * @return a list of training result in specific disciplin
     */
    public ArrayList<TrainingResult> getTrainingResult(Disciplin d) throws DataException {
        String query = "SELECT member.*, sw_time, sw_date, discipline FROM member "
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
    /**
     * 
     * @param ssn used to search for member competitionresult
     * @return a list of member competitionresult
     */
    public ArrayList<CompetitionResult> getCompetitionResult(String ssn) throws DataException {
        String query = "SELECT member.*, competition, sw_rank, sw_time, discipline FROM member "
                + "JOIN comp_result ON member_id = member.id "
                + "WHERE ssn = '" + ssn + "' "
                + "ORDER BY sw_time ASC; ";

        ResultSet r = query(query);

        ArrayList<CompetitionResult> res = new ArrayList<>();
        ArrayList<Member> members = retrieveMembersData(r);
        
        String d = "";
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
                d = r.getString("discipline");
                rank = r.getInt("sw_rank");
                
                Disciplin dis = Disciplin.valueOf(d.toUpperCase());
                res.add(new CompetitionResult(members.get(i), name, rank, time, dis));

                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res;
    }
    
    /**
     * 
     * @param d used to search for competionsresult in a specific disciplin
     * @return  a list of competitionresults in specific disciplin
     */
    public ArrayList<CompetitionResult> getCompetitionResult(Disciplin d) throws DataException {
        String query = "SELECT member.*, competition, sw_rank, sw_time, discipline FROM member "
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
    
    /**
     * 
     * @param ssn used to search for member
     * @param change used to tell what change there is going to be
     * @param field the field that is going to be updated
     */

    public void updateMember(String ssn, String change, String field) throws DataException {
        String query = "UPDATE member SET " + field + " = '" + change + "' WHERE ssn = '" + ssn + "';";
        updateDatabase(query);
    }
    
    /**
     * 
     * @param ssn used to search for member which payment should be updated
     * @param year is used to find which year the member wants to pay for
     */
    public void updatePayment(String ssn, int year) throws DataException {
        String query = "UPDATE member SET last_payment = " + year + " WHERE ssn = '" + ssn + "';";
        updateDatabase(query);
    }
    
    /**
     * 
     * @param firstname create firstname
     * @param lastname create lastname
     * @param ssn create ssn
     * @param birthyear create birthyear
     * @param address create address
     * @param zipcode create zipcode
     * @param phone create phone
     * @param memberstatus create memberstatus
     * @param team_id create team id
     */
    
    public void createMember(String firstname, String lastname, String ssn, int birthyear, String address, 
                                String zipcode, String phone, MemberStatus memberstatus, int team_id) throws DataException {
        String query = "";
        int lastPayment = Calendar.getInstance().get(Calendar.YEAR);
        
        if(team_id == 0){
            query = "INSERT INTO member (id, firstname, lastname, ssn, birthyear, "
                + "address, zipcode, phone, last_payment, memberstatus, team_id)"
                + " VALUES (NULL, '" + firstname + "', '" + lastname +  "', '" + ssn + "', "
                + birthyear + ", '" + address + "', '" + zipcode +  "', '" + phone + "', "
                + lastPayment + ", '" + memberstatus.toString() + "', NULL);";
        } else {
            query = "INSERT INTO member (id, firstname, lastname, ssn, birthyear, "
                + "address, zipcode, phone, last_payment, memberstatus, team_id)"
                + " VALUES (NULL, '" + firstname + "', '" + lastname +  "', '" + ssn + "', "
                + birthyear + ", '" + address + "', '" + zipcode +  "', '" + phone + "', "
                + lastPayment + ", '" + memberstatus.toString() + "', " + team_id + ");";
        }

        updateDatabase(query);
        
    }
    
    /**
     * 
     * @param m the specific member
     * @param d the disciplin of training result
     * @param date date of training result
     * @param time time of training result
     */
    public void createTrainingResult(Member m, Disciplin d, String date, String time) throws DataException {
        Time t = Time.valueOf(time);
        Date nDate = Date.valueOf(date);
        
        int id = 0;
        
        String idQuery = "SELECT id FROM member WHERE ssn = " + m.getSsn() + ";";
        
        ResultSet r = query(idQuery);
        
        try{
            if(r.next()){
                id = r.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        String query = "INSERT INTO training_result (discipline, sw_date, sw_time, member_id) "
                + "VALUES ('" + d + "', '" + nDate + "', '" + t + "', " + id + ");"; 
        updateDatabase(query);
    }
    
    /**
     * 
     * @param m the specific member
     * @param competition where the competition is located
     * @param rank rank of competitionresult
     * @param time time of competionresult
     * @param disciplin the specific disciplins competitionresullt
     */
    public void createCompetitionResult(Member m, String competition, int rank, String time, Disciplin disciplin) throws DataException {
        Time t = Time.valueOf(time);
        
        int id = 0;
        
        String idQuery = "SELECT id FROM member WHERE ssn = " + m.getSsn() + ";";
        
        ResultSet r = query(idQuery);
        
        try{
            if(r.next()){
                id = r.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        String query = "INSERT INTO comp_result (competition, discipline, sw_rank, sw_time, member_id)"
                + "VALUES('" + competition + "', '" + disciplin.toString() + "', " + rank + ", '" + t + "', " + id + ");";
        updateDatabase(query);
        
    }
    
    /**
     * 
     * @return a list of teams
     */
    public ArrayList<Team> getTeams() throws DataException {
        String query = "SELECT * FROM team;";
        ArrayList<Team> teams = new ArrayList<>();
        ResultSet r = query(query);
        
        String teamName = "";
        int teamId = 0;
           
         try {
            while(r.next()){
                teamName = r.getString("team_name");
                //teamId = r.getInt("team_id");
                
                teams.add(new Team(teamName));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return teams;
    }
    
    /**
     * 
     * @param m which member to remove
     */
    public void removeMember(Member m) throws DataException {
        String query = "DELETE FROM member WHERE ssn = '" + m.getSsn() + "';"; 
        updateDatabase(query);
    }
}
