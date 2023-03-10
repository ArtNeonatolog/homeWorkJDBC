import java.util.List;

public interface EmployeeDAO {
    void createEmployee ();
    void readById (Integer id);
    void readAll();
    void updateEmployee (Employee employee);
    void deleteEmployee (Employee employee);
}
