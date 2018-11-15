/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen;

import delfinen.data.CompetitionResult;
import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDataBase;
import delfinen.data.DataException;
import delfinen.data.Disciplin;
import delfinen.data.Member;
import delfinen.data.Membership;
import delfinen.data.TrainingResult;
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
        try {
            DataAccessorDataBase dao = null;
            
            try {
                DBConnector DB = new DBConnector();
                dao = new DataAccessorDataBase(DB);
            } catch (SQLException ex) {
                ex.getMessage();
            }
            
            
            try {
                System.out.println(dao.getMember("1506952222").getFirstname());
            } catch (DataException ex) {
                ex.getMessage();
            }
            
            //System.out.println(dao.getMember("0912951530"));
            ArrayList<Member> members = dao.getMembers();
            
            System.out.println("_________________________________________");
            System.out.println("All members");
            for (Member m : members) {
                System.out.println(m.getFirstname());
            }
            
            /*
            System.out.println("_________________________________________");
            System.out.println("GetMember(ssn)");
            System.out.println(dao.getMember("1012021670").getAddress());
            */
            
            System.out.println("_________________________________________");
            System.out.println("GetMember(name)");
            System.out.println(dao.getMember("Annika", "Ehlers").getFirstname());
            
            //System.out.println(dao.getTop5(Disciplin.CRAWL, Membership.JUNIOR));
            
            System.out.println("__________________________________________");
            System.out.println("GetTrainingresult(name, dis)");
            ArrayList<TrainingResult> result = dao.getTrainingResult("Annika", "Ehlers", Disciplin.CRAWL);
            for(TrainingResult r: result ){
                System.out.println(r.getTime());
            }
            
            System.out.println("__________________________________________");
            System.out.println("Get trainingresult(disciplin)");
            ArrayList<TrainingResult> res = dao.getTrainingResult(Disciplin.CRAWL);
            
            for(TrainingResult r: res) {
                System.out.println(r.getMember().getFirstname() + "  " + r.getTime());
            }
            
            System.out.println("___________________________________________");
            System.out.println("Get competitionresult");
            ArrayList<CompetitionResult> resu = dao.getCompetitionResult(Disciplin.CRAWL);
            for(CompetitionResult re : resu){
                System.out.println(re.getCompetition());
            }
            
            System.out.println("____________________________________________");
            System.out.println("Get competitionresult");
            ArrayList <CompetitionResult> resul = dao.getCompetitionResult("Peter", "Jakobsen", Disciplin.CRAWL);
            for(CompetitionResult er : resul){
                System.out.println(er.getCompetition());
            }
            
            /*
            System.out.println("_____________________________________________");
            System.out.println("Get competition swimmers");
            ArrayList<Member> r = dao.getComptitionSwimmer();
            for(Member m: r){
            System.out.println(m.getFirstname());
            } */
            
            System.out.println("____________________________________________");
            System.out.println("Get top 5");
            ArrayList<TrainingResult> top5 = dao.getTop5(Disciplin.CRAWL, Membership.SENIOR);
            
            for(TrainingResult t: top5){
                System.out.println(t.getMember().getFirstname() + " - " +  t.getTime());
            }
            
        } catch (DataException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
