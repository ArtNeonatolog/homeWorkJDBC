import java.util.List;

public interface EmployeeDAO {
    void createEmployee (Employee employee);
    Employee readById (int id);
    List<Employee> readAll();
    void updateEmployeeById (int id, String first_name, String last_name, String gender, int age, int city_id);
    void deleteEmployeeById (int id);
}
