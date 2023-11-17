import importExport.CSVImportExport;
import importExport.JSONImportExport;
import model.Meeting;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //CSVImportExport csvImportExport = new CSVImportExport();
        JSONImportExport jsonImportExport = new JSONImportExport();
        try {
            List<Meeting> meetingList = jsonImportExport.importData("/Users/nikolaradovic/IdeaProjects/SK1_master/src/main/resources/raspored.json",
                    "/Users/nikolaradovic/IdeaProjects/SK1_master/src/main/resources/config.json");

            jsonImportExport.exportData("test123.json",meetingList);
//            csvImportExport.importData("C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\raspored.csv",
//                    "C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\config.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
