import java.util.List;

public interface EmployeeDAO {
    void createEmployee ();
    void readById (int id);
    void readAll();
    void updateEmployee (Employee employee);
    void deleteEmployee (Employee employee);
}
