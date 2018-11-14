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
public interface DataAccessor {
    ArrayList<Member> getMembers(); 
    Member getMember(String ssn);
    Member getMember(String firstname, String lastname);
    ArrayList<TrainingResult> getTop5(Disciplin disciplin, Membership membership);
    ArrayList<TrainingResult> getTrainingResult(String firstname, String lastname, Disciplin d);
    ArrayList<TrainingResult> getTrainingResult(Disciplin d);
    ArrayList<CompetitionResult> getCompetitionResult(String firstname, String lastname, Disciplin d);
    ArrayList<CompetitionResult> getCompetitionResult(Disciplin d);
}
