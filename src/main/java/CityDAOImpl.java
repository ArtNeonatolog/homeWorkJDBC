import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CityDAOImpl implements CityDAO {

    public CityDAOImpl() {
    }

    @Override
    public City createCity(City city) {
        City city1 = new City();
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
        return city1;
    }

    @Override
    public City readById(Long city_id) {
        return HibernateManager.getSessionFactory().openSession().get(City.class, city_id);
    }

    @Override
    public List<City> readAll() {
        List<City> cityList = HibernateManager.getSessionFactory().openSession().createQuery("FROM City").list();
        return cityList;
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            City city1 = session.find(City.class, city.getCity_id());
            Iterator<Employee> employeeIterator = city1.getEmployeeList().iterator();
            while (employeeIterator.hasNext()) {
                Employee employee = employeeIterator.next();
                employeeIterator.remove();
                session.delete(employee);
            }
            session.delete(city1);
            transaction.commit();
        }
    }

}
