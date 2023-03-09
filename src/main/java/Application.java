import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.readById(2);
    }
}


