/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessor;
import delfinen.data.Member;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Annika Ehlers
 */
public class Main {
    
    public static void main(String[] args) {
        
        DataAccessor dao = null;
        
        try {
            DBConnector DB = new DBConnector();
            dao = new DataAccessor(DB);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println(dao.getMember("0912951530"));
        ArrayList<Member> members = dao.getMembers();
        
        for(Member m: members){
            System.out.println(m.getFirstname());
        }
        
        System.out.println(dao.getMember("1012021670").getFirstname());
        
        
        
        
        
    }
    
}
