import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    private final Connection connection;

    public CityDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void createCity(City city) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO city (city_id, city_name) VALUES ((?), (?))")) {

            statement.setInt(1, city.getCity_id());
            statement.setString(2, city.getCity_name());

            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public City readById(int city_id) {
        City city = new City();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT city_name FROM city WHERE city_id =(?)")) {

            statement.setInt(1, city_id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                city.setCity_id(Integer.parseInt(resultSet.getString("city_id")));
                city.setCity_name(resultSet.getString("city_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> readAll() {
        List<City> cityList = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM city")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = Integer.parseInt(resultSet.getString("city_id"));
                String city_name = resultSet.getString("city_name");

                cityList.add(new City(id, city_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cityList;
    }

    @Override
    public void updateCityById(int id, String city_name) {
        try(PreparedStatement statement = connection.prepareStatement(
                "UPDATE city SET city_name=(?) WHERE city_id=(?)")) {

            statement.setString(1, city_name);
            statement.setInt(2, id);

            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteCityById(int id) {
        try(PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM city WHERE city_id=(?)")) {

            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
