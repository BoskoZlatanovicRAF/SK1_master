package importExport;


import implementation.ScheduleImportExport;
import model.Meeting;
import model.Room;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CSVImportExport extends ScheduleImportExport {
    @Override
    public List<Meeting> importData(String filePath, String configPath) throws IOException {

        List<Meeting> meetings = new ArrayList<>();

        List<ConfigMapping> columnMappings = readConfig(configPath);
        Map<Integer, String> mappings = new HashMap<>();
        FileReader fileReader = new FileReader(filePath);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader);

        for(ConfigMapping configMapping : columnMappings) {
            mappings.put(configMapping.getIndex(), configMapping.getOriginal());
        }

        // Create formatter from the config file
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mappings.get(-1));

        for (CSVRecord record : parser) {
            Meeting meeting = new Meeting();
            for (ConfigMapping entry : columnMappings) {
                int columnIndex = entry.getIndex();

                if (columnIndex == -1) continue;

                String columnName = entry.getCustom();

                switch (mappings.get(columnIndex)) {
                    case "place":
                        meeting.setRoom(new Room(record.get(columnIndex)));
                        break;

                    case "start":
                        if(record.get(columnIndex).toString().length() < 8){
                            LocalDate localDate = LocalDate.of(1000, 1, 1);
                            LocalTime localTime = LocalTime.parse(record.get(columnIndex));
                            LocalDateTime startDateTime= LocalDateTime.of(localDate, localTime);
                            meeting.setTimeStart(startDateTime);
                            break;
                        }
                        LocalDateTime startDateTime = LocalDateTime.parse(record.get(columnIndex), formatter);
                        meeting.setTimeStart(startDateTime);
                        break;

                    case "end":
                        if(record.get(columnIndex).toString().length() < 8){
                            LocalDate localDate = LocalDate.of(1000, 1, 1);
                            LocalTime localTime = LocalTime.parse(record.get(columnIndex));
                            LocalDateTime endDateTime= LocalDateTime.of(localDate, localTime);
                            meeting.setTimeEnd(endDateTime);
                            break;
                        }
                        LocalDateTime endDateTime = LocalDateTime.parse(record.get(columnIndex), formatter);
                        meeting.setTimeEnd(endDateTime);
                        break;
                    case "day":
                        DayOfWeek dayOfWeek = DayOfWeek.valueOf(record.get(columnIndex));
                        meeting.setDayOfWeek(dayOfWeek);
                        break;
                    case "additional":
                        meeting.getAdditionalAttributes().put(columnName, record.get(columnIndex));
                        break;
                    case "room":
                        meeting.getRoom().getFeatures().put(columnName, record.get(columnIndex));
                        break;
                }
            }
            meetings.add(meeting);


        }
        for(Meeting meeting : meetings) {
            System.out.println(meeting.toString());
        }
        System.out.println("----------------------------");
        return meetings;
    }


    private static List<ConfigMapping> readConfig(String configPath) throws FileNotFoundException {

            List<ConfigMapping> mappings = new ArrayList<>();

            File file = new File(configPath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(" ", 3);

                mappings.add(new ConfigMapping(Integer.valueOf(splitLine[0]), splitLine[1], splitLine[2]));
            }
            scanner.close();

            return mappings;
    }

    @Override
    public boolean exportData(String filepath, List<Meeting> meetings) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

        for(Meeting meeting: meetings){
            csvPrinter.printRecord(meeting.getTimeEnd(), meeting.getTimeEnd(), meeting.getRoom(), meeting.getAdditionalAttributes());
        }

        fileWriter.close();
        csvPrinter.close();
        return true;
    }
}