import importExport.CSVImportExport;
import importExport.JSONImportExport;
import importExport.PDF_Export;
import model.Meeting;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CSVImportExport csvImportExport = new CSVImportExport();
//        JSONImportExport jsonImportExport = new JSONImportExport();
        PDF_Export pdf_export = new PDF_Export();
        try {
            List<Meeting> meetingList = csvImportExport.importData("C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\raspored.csv",
                    "C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\config.txt");

            pdf_export.exportData("test123.pdf",meetingList);
//            csvImportExport.importData("C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\raspored.csv",
//                    "C:\\Users\\User\\IdeaProjects\\SK1_master\\src\\main\\resources\\config.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
