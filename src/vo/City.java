package vo;

public class City {
    private int id;
    private String areaId;
    private String cityName;

    public City(int id, String areaId, String cityName) {
        this.id = id;
        this.areaId = areaId;
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", areaId=" + areaId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
