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

/**
 *
 * @author Annika Ehlers
 */
public class ControllerAdmin implements Controller
{

    private DBConnector c;
    private DataAccessorDatabase data;

    public ControllerAdmin()
    {
        try
        {
            c = new DBConnector();
            data = new DataAccessorDatabase(c);

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * 
     * @param s used to find member
     * @param d used to find specific discipline
     * @return the members trainingsresults for at specific discipline
     */
    @Override
    public ArrayList<TrainingResult> getTrainingResult(Member s, Disciplin d)
    {
        try
        {
            return data.getTrainingResult(s.getSsn(), d);
        } catch (IllegalArgumentException ex)
        {
            System.out.println("SSN or disciplin does not exist");
            return null;
        }
    }

    /**
     * 
     * @param s used to search for member
     * @return a members competitionsresults
     */
    @Override
    public ArrayList<CompetitionResult> getCompetitionResult(Member s)
    {
        try
        {
            return data.getCompetitionResult(s.getSsn());
        } catch (IllegalArgumentException ex)
        {
            System.out.println("SSN not found");
            return null;
        }
    }
    
    /**
     * 
     * @param m used to to search for member
     * @param field that is going to be updated
     * @param change used to tell what change there is going to be
     */
    @Override
    public void updateMember(Member m, String field, String change)
    {
        data.updateMember(m.getSsn(), change, field);
    }

    public ArrayList<Member> seeMembers()
    {
        try
        {
            return data.getMembers();
        } catch (DataException ex)
        {
            return null;
        }
    }
    /**
     * 
     * @param m search for member that is going to be deleted
     */
    public void deleteMember(Member m)
    {
        data.removeMember(m);
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
    public void createMember(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, int team_id)
    {
        if (firstname.length() > 40 || firstname.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        if (lastname.length() > 40 || firstname.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        String trim = ssn.trim();

        try
        {
            Integer.parseInt(trim);
        } catch (NumberFormatException e)
        {
            e.getMessage();
        }

        if (String.valueOf(trim).length() == 10)
        {
            ssn = trim;
        } else
        {
            throw new IllegalArgumentException();
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);

        if (birthyear < (year - 100) || birthyear >= year)
        {
            throw new IllegalArgumentException();
        }

        if (address.length() > 50 || address.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        String zipTrim = zipcode.trim();

        try
        {
            Integer.parseInt(zipTrim);
        } catch (NumberFormatException e)
        {
            e.getMessage();
        }

        if (String.valueOf(zipTrim).length() == 4)
        {
            zipcode = zipTrim;
        } else
        {
            throw new IllegalArgumentException();
        }

        String phoneTrim = phone.trim();

        try
        {
            Integer.parseInt(phoneTrim);
        } catch (NumberFormatException e)
        {
            e.getMessage();
        }

        if (String.valueOf(phoneTrim).length() == 8)
        {
            phone = phoneTrim;
        } else
        {
            throw new IllegalArgumentException();
        }

        data.createMember(firstname, lastname, ssn, birthyear, address, zipcode, phone, memberstatus, team_id);
    }
    
    /**
     * 
     * @param year used to search for currentyear
     * @return a list of members in arrears
     */
    public ArrayList<Member> seeMembersInArrears(int year)
    {
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Member> arrears = new ArrayList<>();
        try
        {
            members = data.getMembers();
        } catch (DataException ex)
        {
            ex.getStackTrace();
        }

        //int year = Calendar.getInstance().get(Calendar.YEAR);

        for (Member m : members)
        {
            if (!(m.getYearsPaid().contains(year)))
            {
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
    public void payForCurrentYear(Member m, int year)
    {
        data.updatePayment(m.getSsn(), year);
    }
    
    public Member getMember(String ssn)
    {
        try
        {
            Member member = data.getMember(ssn);
            return member;
        } catch (Exception ex)
        {
            System.out.println("Member not found");
            return null;

        }

    }

}
