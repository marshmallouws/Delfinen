   
package delfinen.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sofieamalielandt
 */
public class DataAccessor implements DataAccessorInterface{ 
    
    private DBConnector connector = null;

    public DataAccessor(DBConnector connector){
        this.connector = connector;
    }
    
    private ResultSet query(String query){
        ResultSet rs = null;
        try{
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex){
            System.out.println("Query not working");
        }
        return rs;
    }
    
    
    private ArrayList<Member> membersData(ResultSet rs){
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
            while(rs.next()){
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
            
        }
        return members;
    }
    
    public ArrayList<Member> getMembers(){
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

    public CompetitionSwimmer getComptitionSwimmer(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Member getMember(String firstname, String lastname) {
        String query = "SELECT ssn, firstname, lastname, birthyear, "
                + "address, zipcode, phone, memberstatus, membership, membertype FROM member WHERE "
                + "firstname = '" +  firstname + "' AND lastname ='" + lastname + "';";
        
        ResultSet r = query(query);
        ArrayList<Member> members = membersData(r);
        return members.get(0);
    }

    @Override
    public ArrayList<Member> getTop5(String style) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
