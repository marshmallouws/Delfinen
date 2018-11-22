/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen;

import delfinen.logic.CompetitionResult;
import delfinen.data.DBConnector;
import delfinen.data.DataAccessorDatabase;
import delfinen.data.DataException;
import delfinen.logic.CompetitionSwimmer;
import delfinen.logic.ControllerAdmin;
import delfinen.logic.Disciplin;
import delfinen.logic.Member;
import delfinen.logic.MemberStatus;
import delfinen.logic.Team;
import delfinen.logic.TrainingResult;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Annika Ehlers
 */
public class Main
{
    public static void main(String[] args) {
        try {
            DataAccessorDatabase dao = null;
            
            try {
                DBConnector DB = new DBConnector();
                dao = new DataAccessorDatabase(DB);
            } catch (SQLException ex) {
                ex.getMessage();
            }
            
            ControllerAdmin admin = new ControllerAdmin();
            ArrayList<Member> members = dao.getMembers();

            System.out.println("_________________________________________");
            System.out.println("All members");
            for (Member m : members)
            {
                System.out.println(m.getFirstname());
            }

            ArrayList<Member> sw = dao.getMembers();

            System.out.println("_________________________________________");
            System.out.println("GetMember(ssn)");
            Member m = dao.getMember("1506952222");
            System.out.println(m.getAddress());
            System.out.println(m instanceof CompetitionSwimmer);

            System.out.println("_________________________________________");
            System.out.println("GetMember(name)");
            System.out.println(dao.getMember("Annika", "Ehlers").getFirstname());

            System.out.println("__________________________________________");
            System.out.println("GetTrainingresult(name, dis)");
            ArrayList<TrainingResult> result = dao.getTrainingResult("1506952222", Disciplin.CRAWL);
            for (TrainingResult r : result)
            {
                System.out.println(r.getTime());
            }

            System.out.println("__________________________________________");
            System.out.println("Get trainingresult(disciplin)");
            ArrayList<TrainingResult> res = dao.getTrainingResult(Disciplin.CRAWL);

            for (TrainingResult r : res)
            {
                System.out.println(r.getMember().getFirstname() + "  " + r.getTime());
            }

            System.out.println("___________________________________________");
            System.out.println("Get competitionresult");
            ArrayList<CompetitionResult> resu = dao.getCompetitionResult(Disciplin.CRAWL);
            for (CompetitionResult re : resu)
            {
                System.out.println(re.getCompetition());
            }

            System.out.println("____________________________________________");
            System.out.println("Get competitionresult");
            ArrayList<CompetitionResult> resul = dao.getCompetitionResult("0412038089");
            for (CompetitionResult er : resul)
            {
                System.out.println(er.getCompetition());
            }

            /*System.out.println("____________________________________________");
            System.out.println("Get top 5");
            Team team = new Team("Senior");
            ArrayList<TrainingResult> top5 = dao.getTop5(Disciplin.CRAWL, team);

            for (TrainingResult t : top5)
            {
                System.out.println(t.getMember().getFirstname() + " - " + t.getTime());
            }*/

            System.out.println("_____________________________________________");
            System.out.println("Update member");
            dao.updateMember("1506952222", "Olina", "firstname");
            dao.updateMember("1506952222", "2400", "zipcode");
            dao.updateMember("1506952222", "Ellevej 6", "address");
            dao.updateMember("1506952222", "20141614", "phone");

            System.out.println("_____________________________________________");
            System.out.println("Get competitionSwimmer");
            ArrayList<CompetitionSwimmer> d = dao.getComptitionSwimmers();

            for (CompetitionSwimmer c : d)
            {
                System.out.println(c.getFirstname());
            }

            System.out.println("________________________________________________");
            System.out.println("Get team");
            ArrayList<Team> teams = dao.getTeams();

            for (Team t : teams)
            {
                System.out.println(t.getTeamname());
            }

            System.out.println("__________________________________________________");
            System.out.println("Get competition result from ssn");
            ArrayList<CompetitionResult> r = dao.getCompetitionResult("1507053333");

            for (CompetitionResult c_result : r)
            {
                System.out.println(c_result.getTime() + c_result.getRank());
            }

            
            System.out.println("______________________________________________");
            System.out.println("Create member");
            dao.createMember("Bitten", "Skumfidus", "1506952668", 1995, "Sømosen 1", "2550", "53388469", MemberStatus.ACTIVE , 0);
            //dao.getMember("1506952668");
            
            String time = "00:01:00";
            String date = "2016-09-11";
            
            System.out.println("______________________________________________");
            System.out.println("Create Training Result");
            dao.createTrainingResult(m, Disciplin.CRAWL, date, time);
            
            System.out.println("______________________________________________");
            System.out.println("Create Competition result");
            dao.createCompetitionResult(m, "Greve svømmehal", 6, time, Disciplin.CRAWL);
            
            System.out.println("_______________________________________________");
            Member a = dao.getMember("1506952222");
            /*
            System.out.println("Delete member");
            dao.removeMember(a); */
            
            System.out.println("________________________________________________");
            System.out.println("Update payment");
            System.out.println(a.getLastPayment());
            dao.updatePayment(a.getSsn(), 2018);
            
            System.out.println(dao.getMember("1506952222").getLastPayment());
            
            System.out.println(2018 % 2017);
        } catch (DataException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
