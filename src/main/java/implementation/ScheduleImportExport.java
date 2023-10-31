package implementation;

public abstract class ScheduleImportExport<T> {

    public abstract boolean importData(String filePath, String configPath);

    public abstract boolean exportData(String filePath);

}
