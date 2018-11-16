/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import delfinen.logic.CompetitionResult;
import delfinen.logic.CompetitionSwimmer;
import delfinen.logic.Disciplin;
import delfinen.logic.TrainingResult;
import delfinen.logic.Member;
import delfinen.logic.MemberStatus;
import delfinen.logic.Team;
import java.util.ArrayList;

/**
 *
 * @author Annika Ehlers
 */
public interface DataAccessor {
    ArrayList<Member> getMembers() throws DataException; 
    Member getMember(String ssn) throws DataException;
    Member getMember(String firstname, String lastname);
    ArrayList<TrainingResult> getTop5(Disciplin disciplin, Team team);
    ArrayList<TrainingResult> getTrainingResult(String ssn, Disciplin d);
    ArrayList<TrainingResult> getTrainingResult(Disciplin d);
    ArrayList<CompetitionResult> getCompetitionResult(String ssn);
    ArrayList<CompetitionResult> getCompetitionResult(Disciplin d);
    ArrayList<CompetitionSwimmer> getComptitionSwimmers();
    void updateMember(String ssn, String change, String field);
    //void createMember(String firstname, String lastname, String ssn, int birthyear, String address, String zipcode, String phone, MemberStatus memberstatus, int team_id);
    ArrayList<Team> getTeams();
}
