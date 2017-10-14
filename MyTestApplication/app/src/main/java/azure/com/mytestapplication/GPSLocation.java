package azure.com.mytestapplication;

/**
 * Created by CR on 2017/10/14.
 */

public class GPSLocation {

    public GPSLocation(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public GPSLocation(){};

    private Double longitude;

    private Double latitude;


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
