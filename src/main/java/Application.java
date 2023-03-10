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
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(new HibernateManager());
        employeeDAO.createEmployee(); //работает, ничего не вовзращает (void)
        employeeDAO.readAll(); //не работает, выходит ошибка
        employeeDAO.readById(2); //не работает, выходит ошибка
        employeeDAO.updateEmployee(?); //откуда здесь взять employee?
        employeeDAO.deleteEmployee(?); //откуда здесь взять employee?
        }
    }