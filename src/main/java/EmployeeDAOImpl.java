import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public EmployeeDAOImpl() {

    }

    @Override
    public void createEmployee(Employee employee) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(Long id) {
        return HibernateManager.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> listOfEmployees = HibernateManager
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return listOfEmployees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
