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
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        CityDAOImpl cityDAO = new CityDAOImpl();
        cityDAO.deleteCity(cityDAO.readById(150L));
        cityDAO.deleteCity(cityDAO.readById(152L));
        cityDAO.deleteCity(cityDAO.readById(160L));
        cityDAO.deleteCity(cityDAO.readById(130L));
        cityDAO.deleteCity(cityDAO.readById(132L));
        cityDAO.deleteCity(cityDAO.readById(162L));

    }
    }