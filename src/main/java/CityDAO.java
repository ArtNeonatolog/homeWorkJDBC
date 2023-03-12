import java.util.List;

public interface CityDAO {
    City createCity (City city);
    City readById (Long city_id);

    List<City> readAll();

    void updateCity (City city);

    void deleteCity (City city);
}
