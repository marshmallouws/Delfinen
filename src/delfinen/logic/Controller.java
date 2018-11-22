package delfinen.logic;

import delfinen.data.DBConnector;
import delfinen.data.DataException;
import delfinen.data.DataAccessorDatabase;
import java.util.ArrayList;

public class Controller {
    private DataAccessorDatabase data;
    private DBConnector c;
    
    public Controller(){
        data = new DataAccessorDatabase(c);
    }
    
    public ArrayList<TrainingResult> getTrainingResult(Member s, Disciplin d) {
        ArrayList<TrainingResult> t = null;
        try {
            t = data.getTrainingResult(s.getSsn(), d);
        } catch (IllegalArgumentException ex) {
            System.out.println("SSN or disciplin does not exist");
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }
        return t;
    }

    public ArrayList<CompetitionResult> getCompetitionResult(Member s) {
        ArrayList<CompetitionResult> c = null;
        try {
            c = data.getCompetitionResult(s.getSsn());
        } catch (IllegalArgumentException ex) {
            System.out.println("SSN not found");
        } catch (DataException ex) {
            System.out.println("Could not retrieve data from database.");
        }
        return c;
    }

    public String updateMember(Member m, String field, String change) {
        String error = "";
        String zipTrim = "";
        String phoneTrim = "";

        switch (field) {
            case "firstname":

                if (change.length() > 40 || change.isEmpty()) {
                    error += "Firstname must be between 1 - 40 characters";
                }
                break;

            case "lastname":

                if (change.length() > 40 || change.isEmpty()) {
                    error += "Lastname must be between 1 - 40 characters";
                }
                break;

            case "address":

                if (change.length() > 50 || change.isEmpty()) {
                    error += "Address must be between 1 and 50 characters";
                }
                break;

            case "zipcode":

                zipTrim = change.trim();

                try {
                    Integer.parseInt(zipTrim);
                } catch (NumberFormatException e) {
                    error += "Zipcode must be 4 digits";
                }

                if (zipTrim.length() == 4) {
                    change = zipTrim;
                } else {
                    error += "Zipcode must be 4 digits";
                }
                break;

            case "phone":
                phoneTrim = change.trim();

                try {
                    Integer.parseInt(phoneTrim);
                } catch (NumberFormatException e) {
                    error += "Phone number must be 8 digits";
                    break;
                }

                if (phoneTrim.length() == 8) {
                    change = phoneTrim;
                } else {
                    error += "Phone number must be 8 digits";
                }

                break;

            case "memberstatus":
                change = change;
                break;
        }

        if (error.isEmpty()) {
            try {
                data.updateMember(m.getSsn(), change, field);
            } catch (DataException ex) {
                error += "Cannot update member.";
            }
        }
        return error;
    }
}
