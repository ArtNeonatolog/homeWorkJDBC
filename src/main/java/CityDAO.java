import java.util.List;

public interface CityDAO {
    void createCity (City city);
    City readById (int city_id);

    List<City> readAll();

    void updateCityById(int id, String city_name);

    void deleteCityById (int id);
}
