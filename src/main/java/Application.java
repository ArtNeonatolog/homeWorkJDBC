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
        City city = new City(23L, "Niva");
        cityDAO.createCity(city);
        City city1 = new City(city.getCity_id(), "Mos");
        cityDAO.updateCity(city1);
        Employee employee = new Employee(18L, "Ir", "Ar", "male", 40, city1);
        employeeDAO.createEmployee(employee);
        Employee employee1 = new Employee(employee.getId(), employee.getFirst_name(), "Tryu", employee.getGender(), employee.getAge(), city1);
        employeeDAO.updateEmployee(employee1);
        employeeDAO.readById(5L);
        cityDAO.readById(3L);
        employeeDAO.readAll();
        cityDAO.readAll();
        cityDAO.deleteCity(city1);
        employeeDAO.deleteEmployee(employee1);

    }
    }