import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(Paths.get ("db.properties").toFile()));

        try (final Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"))) {

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


