/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDatabase;
import delfinen.data.DataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Annika Ehlers
 */
public class ControllerAdmin extends Controller {

    private DBConnector c;
    private DataAccessorDatabase data;

    public ControllerAdmin() {
        try {
            c = new DBConnector();
            data = new DataAccessorDatabase(c);
        } catch (SQLException ex) {
            System.out.println("Could not connect to database");;
        }
    }

    public ArrayList<Member> seeMembers() {
        ArrayList<Member> m = null;
        try {
            m = data.getMembers();
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }
        return m;
    }

    /**
     *
     * @param m search for member that is going to be deleted
     */
    public void deleteMember(Member m) {
        try {
            data.removeMember(m);
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }
    }

    /**
     *
     * @param firstname to create firstname
     * @param lastname to create lastname
     * @param ssn to create ssn
     * @param birthyear to create birthyear
     * @param address to create address
     * @param zipcode to create zipcode
     * @param phone to create phone
     * @param memberstatus to create memberstatus
     * @param team_id to create team id
     */
    public String createMember(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, int team_id) {
        String error = "";

        if (firstname.length() > 40 || firstname.isEmpty()) {
            error += "Firstname must be between 1 - 40 characters";
        }
        if (lastname.length() > 40 || firstname.isEmpty()) {
            error += "Lastname must be between 1 - 40 characters";
        }

        String trim = ssn.trim();

        try {
            Integer.parseInt(trim);
        } catch (NumberFormatException e) {
            error += "SSN must be 10 digits";
        }

        if (trim.length() == 10) {
            ssn = trim;
        } else {
            error += "SSN must be 10 digits";
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);

        if (birthyear < (year - 100) || birthyear >= year) {
            error += "Birthyear must be 4 digits";
        }

        if (address.length() > 50 || address.isEmpty()) {
            error += "Address must be between 1 and 50 characters";
        }

        String zipTrim = zipcode.trim();

        try {
            Integer.parseInt(zipTrim);
        } catch (NumberFormatException e) {
            error += "Zipcode must be 4 digits";
        }

        if (zipTrim.length() == 4) {
            zipcode = zipTrim;
        } else {
            error += "Zipcode must be 4 digits";
        }

        String phoneTrim = phone.trim();

        try {
            Integer.parseInt(phoneTrim);
        } catch (NumberFormatException e) {
            error += "Phone number must be 8 digits";
        }

        if (phoneTrim.length() == 8) {
            phone = phoneTrim;
        } else {
            error += "Phone number must be 8 digits";
        }

        if (error.isEmpty()) {
            try {
                data.createMember(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus, team_id);
            } catch (DataException ex) {
                System.out.println("Could not retrieve data from database.");
            }
            return error;
        }
        return error;
    }

    /**
     *
     * @param year used to search for currentyear
     * @return a list of members in arrears
     */
    public ArrayList<Member> seeMembersInArrears(int year) {
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Member> arrears = new ArrayList<>();
        try {
            members = data.getMembers();
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }

        //int year = Calendar.getInstance().get(Calendar.YEAR);
        for (Member m : members) {
            if (!(m.getYearsPaid().contains(year))) {
                arrears.add(m);
            }
        }

        return arrears;
    }

    /**
     *
     * @param m used to search for member
     * @param year used to pay for current year
     */
    public void payForCurrentYear(Member m, int year) {
        ArrayList<Integer> yearsPaid = m.getYearsPaid();
        int last = yearsPaid.size() - 1;
        if (year % yearsPaid.get(last) != 1) {
            throw new IllegalArgumentException();
        }
        try {
            data.updatePayment(m.getSsn(), year);
            m.setYearsPaid(year);
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }
    }

    public Member getMember(String ssn) {
        Member m = null;
        try {
            m = data.getMember(ssn);
        } catch (Exception ex) {
            System.out.println("Could not retrieve data from database.");
        }
        return m;
    }
}
