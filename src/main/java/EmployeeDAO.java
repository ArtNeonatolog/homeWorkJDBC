import java.util.List;

public interface EmployeeDAO {
    void createEmployee (Employee employee);
    Employee readById (Long id);
    List<Employee> readAll();
    void updateEmployee (Employee employee);
    void deleteEmployee (Employee employee);
}
