   
package delfinen.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofieamalielandt
 */
public class DataAccessor
{ 
    
    private DBConnector connector = null;

    public DataAccessor(DBConnector connector)
    {
        this.connector = connector;
    }
    
    public ArrayList<Member> getMembers()
    {
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
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

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
                
                MemberStatus stat = MemberStatus.valueOf(status);
                Membership mem = Membership.valueOf(membership);
                MemberType ty = MemberType.valueOf(type);
                
                members.add(new Member(firstname, lastname, ssn, birthyear, address, zipcode, phone, stat, mem, ty));
            }
                
        }catch (SQLException ex){
            
            }
        return members;
    }
    

    public Member getMember(String ssn)
    {
        String query = "SELECT ssn, firstname, lastname, birthyear, "
                + "address, zipcode, phone, memberstatus, membership, membertype FROM member WHERE ssn = '" + ssn + "';";
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
            System.out.println("med");
            Connection connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                System.out.println("dig");
                ssn2 = rs.getString("ssn");
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
                birthyear = rs.getInt("birthyear");
                address = rs.getString("adress");
                zipcode = rs.getString("zipcode");
                phone = rs.getString("phone");
                status = rs.getString("memberstatus");
                membership = rs.getString("membership");
                type = rs.getString("membertype");
                
                MemberStatus stat = MemberStatus.valueOf(status);
                Membership mem = Membership.valueOf(membership);
                MemberType ty = MemberType.valueOf(type);
                
                member = new Member(firstname, lastname, ssn2, birthyear, address, zipcode, phone, stat, mem, ty);
            }
                
        }catch (SQLException ex){
            
            }
        if(member == null){
            //throw new DataException();
            Member m = new Member("a", "b", "1", 1990, "a","e", "e", MemberStatus.ACTIVE, Membership.JUNIOR, MemberType.COMPETITIVE);
            return m;
        }
        
        return member;
    }
        

    public CompetitionSwimmer getComptitionSwimmer()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
