package implementation;

import java.io.IOException;

public abstract class ScheduleImportExport<T> {

    public abstract boolean importData(String filePath, String configPath) throws IOException;

    public abstract boolean exportData(String filePath) throws IOException;

}
