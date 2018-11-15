/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import delfinen.logic.CompetitionResult;
import delfinen.logic.Disciplin;
import delfinen.logic.TrainingResult;
import delfinen.logic.Membership;
import delfinen.logic.Member;
import java.util.ArrayList;

/**
 *
 * @author Annika Ehlers
 */
public interface DataAccessor {
    ArrayList<Member> getMembers() throws DataException; 
    Member getMember(String ssn) throws DataException;
    Member getMember(String firstname, String lastname);
    ArrayList<TrainingResult> getTop5(Disciplin disciplin, Membership membership);
    ArrayList<TrainingResult> getTrainingResult(String ssn, Disciplin d);
    ArrayList<TrainingResult> getTrainingResult(Disciplin d);
    ArrayList<CompetitionResult> getCompetitionResult(String ssn, Disciplin d);
    ArrayList<CompetitionResult> getCompetitionResult(Disciplin d);
    ArrayList<Member> getComptitionSwimmers();
    
}
