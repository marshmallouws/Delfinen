/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import java.util.ArrayList;

/**
 *
 * @author Annika Ehlers
 */
public interface DataAccessorInterface {
    ArrayList<Member> getMembers(); 
    Member getMember(String ssn);
    Member getMember(String firstname, String lastname);
    ArrayList<Member> getTop5(String style);
}
