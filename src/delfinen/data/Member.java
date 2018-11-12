/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import java.util.ArrayList;

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
    private ArrayList <Integer> yearsPaid;
    private MemberStatus memberstatus;
    private Membership membership;
    private Membertype membertype;

    public Member(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, Membership membership, Membertype membertype)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.birthyear = birthyear;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.memberstatus = memberstatus;
        this.membership = membership;
        this.membertype = membertype;
        this.yearsPaid = new ArrayList<>();
    }

    public int getAge(int year)
    {
        int age = year - birthyear;
        return age;
        
        /*int day = Integer.parseInt(ssn.substring(0,2));
        int month = Integer.parseInt(ssn.substring(2,4));
        int year = Integer.parseInt(ssn.substring(4,6));*/
        
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

    public void setMembership(Membership membership)
    {
        this.membership = membership;
    }

    public void setMembertype(Membertype membertype)
    {
        this.membertype = membertype;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
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

    public Membertype getMembertype()
    {
        return membertype;
    }
    
}
