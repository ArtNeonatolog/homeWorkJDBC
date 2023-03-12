import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        CityDAOImpl cityDAO = new CityDAOImpl();
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        City newYork = cityDAO.createCity(new City("New York"));
        employeeDAO.createEmployee(new Employee("Panov", "Pavel", "male", 34, newYork));
        newYork.setCity_name("Moskva");
        cityDAO.updateCity(newYork);

    }
    }