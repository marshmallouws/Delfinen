   
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
            return rs;
        } catch (SQLException ex){
            System.out.println("Connection not working");
        }
        return null;
    }
    
    public ArrayList<Member> getMembers(){
        String query = "SELECT ssn, firstname, lastname, birthyear, address,"
                + "zipcode, phone, memberstatus, membership, membertype FROM member;";
        ArrayList<Member> members = new ArrayList<>();
        
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
        
        try {
            ResultSet rs = query(query);

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
                
        } catch (SQLException ex){
            
            }
        return members;
    }

    public Member getMember(String ssn) {
        String query = "SELECT ssn, firstname, lastname, birthyear, "
                + "address, zipcode, phone, memberstatus, membership, membertype FROM member WHERE ssn ='" + ssn + "';";
        Member member = null;
        System.out.println("Hej");
       
        String ssn2 = "";
        String firstname = "";
        String lastname = "";
        int birthyear = 0;
        String address = "";
        String zipcode = "";
        String phone = "";
        String status = "";
        String membership = "";
        String type = "";
        
        try {
            ResultSet rs = query(query);

            while(rs.next()){
                
                ssn2 = rs.getString("ssn");
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
                System.out.println("difjs");
                
                member = new Member(firstname, lastname, ssn2, birthyear, address, zipcode, phone, stat, mem, ty);
                
            }
                
        }catch (SQLException ex){
            System.out.println(ex.getCause());    
        }
        
        return member;
    }
        

    public CompetitionSwimmer getComptitionSwimmer(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Member getMember(String firstname, String lastname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Member> getTop5(String style) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
