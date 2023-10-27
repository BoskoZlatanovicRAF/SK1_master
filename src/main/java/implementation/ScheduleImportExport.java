package implementation;

public interface ScheduleImportExport<T> {

    public T serialize(Object object);

    public T deserialize(Object object);
}
