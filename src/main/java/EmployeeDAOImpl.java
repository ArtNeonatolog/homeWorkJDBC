import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private HibernateManager hibernateManager;

    public EmployeeDAOImpl(HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }

    @Override
    public void createEmployee() {
        hibernateManager.withEntityManager(em -> {
            Employee employee = new Employee();
            employee.setFirst_name("Vladislav");
            employee.setLast_name("Popov");
            employee.setGender("male");
            employee.setAge(40);
            employee.setCity(12);
            em.persist(employee);
        });
    }

    @Override
    public void readById(Integer id) {
       hibernateManager.withEntityManager(em -> {
            Employee employee = em.find(Employee.class, id);
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
