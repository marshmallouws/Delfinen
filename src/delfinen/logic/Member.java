/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.logic;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author sofieamalielandt
 */
public class Member
{

    private String firstname;
    private String lastname;
    private int birthyear;
    private String ssn;
    private String address;
    private String zipcode;
    private String phone;
    private ArrayList<Integer> yearsPaid;
    private MemberStatus memberstatus;
    private Membership membership;
    private static int year;
    private int lastPayment;

    public Member(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, int lastPayment)
    {
        this.year = Calendar.getInstance().get(Calendar.YEAR);
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.birthyear = birthyear;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.memberstatus = memberstatus;
        this.yearsPaid = new ArrayList<>();
        this.lastPayment = lastPayment;
        makeYears();

        if (this.getAge() >= 18)
        {
            this.membership = Membership.SENIOR;
        } else
        {
            this.membership = Membership.JUNIOR;
        }

    }

    private void makeYears()
    {
        for (int i = birthyear; i < lastPayment; ++i)
        {
            yearsPaid.add(i);
        }
        yearsPaid.add(lastPayment);

    }

    public int getAge()
    {
        int age = year - birthyear;
        return age;

        /*int day = Integer.parseInt(ssn.substring(0,2));
        int month = Integer.parseInt(ssn.substring(2,4));
        int year = Integer.parseInt(ssn.substring(4,6));*/
    }
    
    public void setYearsPaid(int year){
        int last = yearsPaid.size()-1;
        if(year % yearsPaid.get(last) != 1){
            throw new IllegalArgumentException();
        } else {
            yearsPaid.add(year);
        }
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public int getBirthyear()
    {
        return birthyear;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setMemberstatus(MemberStatus memberstatus)
    {
        this.memberstatus = memberstatus;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getName()
    {

        return firstname + " " + lastname;
    }

    public String getSsn()
    {
        return ssn;
    }

    public String getAddress()
    {
        return address;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public String getPhone()
    {
        return phone;
    }

    public ArrayList<Integer> getYearsPaid()
    {
        return yearsPaid;
    }

    public MemberStatus getMemberstatus()
    {
        return memberstatus;
    }

    public Membership getMembership()
    {
        return membership;
    }

    public int getLastPayment()
    {
        return lastPayment;
    }

    public double calculateS()
    {
        try
        {
            if (this.getAge() < 0)
            {
                throw new IllegalArgumentException();
            }

            if (this.getMemberstatus().equals(MemberStatus.PASSIVE))
            {
                return 500;
            } else
            {
                if (this.getAge() < 18)
                {
                    return 1000;
                } else if (this.getAge() > 60)
                {
                    return 1600 * 0.75;
                } else
                {
                    return 1600;
                }
            }
        } catch (Exception ex)
        {
            throw new IllegalArgumentException(ex);

        }

    }

    @Override
    public String toString()
    {
        return "Member: " + "firstname: " + firstname + ", lastname: " + lastname + ", birthyear: " + birthyear + ", ssn: " + ssn + ", address: " + address + ", zipcode: " + zipcode + ", phone: " + phone + ", yearsPaid: " + yearsPaid + ", memberstatus: " + memberstatus + ", membership: " + membership;
    }

}
