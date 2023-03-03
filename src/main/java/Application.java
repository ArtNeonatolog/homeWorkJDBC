import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";

        final String password = "207877";

        final String url = "jdbc:postgresql://localhost:5432/skypro_name";

        try (final Connection connection = DriverManager.getConnection(url, user, password)) {

            CityDAOImpl cityDAO = new CityDAOImpl(connection);
            EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(connection);

            List<Employee> employeeList = new ArrayList<>(employeeDAO.readAll());

            List<City> cityList = new ArrayList<>(cityDAO.readAll());

            for (City city1: cityList) {
                System.out.println(city1);
            }

            for (Employee employee1: employeeList) {
                System.out.println(employee1);
            }

        }
    }
}


