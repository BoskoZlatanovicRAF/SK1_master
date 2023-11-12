import importExport.CSVImportExport;
import importExport.JSONImportExport;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CSVImportExport csvImportExport = new CSVImportExport();
//        JSONImportExport jsonImportExport = new JSONImportExport();
        try {
//            jsonImportExport.importData("C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\raspored.json",
//                    "C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\config.json");
            csvImportExport.importData("C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\raspored.csv",
                    "C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\config.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
