import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    HibernateManager hibernateManager = new HibernateManager();

    @Override
    public void createEmployee() {
        hibernateManager.withEntityManager(em -> {
            Employee employee = new Employee();
            employee.setFirst_name("Vladislav");
            employee.setLast_name("Popov");
            employee.setGender("male");
            employee.setAge(40);
            employee.setCity(new City(10, "Barcelona"));
            em.persist(employee);
        });
    }

    @Override
    public void readById(int id) {
        hibernateManager.withEntityManager(em -> {
            Employee employee = em.createQuery("SELECT Employee", Employee.class).getSingleResult();
            System.out.println(employee);
        });
    }

    @Override
    public void readAll() {
        hibernateManager.withEntityManager(em -> {
            List<Employee> employeeList = em.createQuery("SELECT Employee", Employee.class).getResultList();
            System.out.println(employeeList);
        });
    }

    @Override
    public void updateEmployee(Employee employee) {
        hibernateManager.withEntityManager(em -> em.refresh(employee));
    }

    @Override
    public void deleteEmployee(Employee employee) {
        hibernateManager.withEntityManager(em -> em.remove(employee));
    }
}
