package azure.com.mytestapplication;

/**
 * Created by CR on 2017/10/14.
 */

public class Tools {

    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    //meter
    public final static double WARNING_DISTANCE = 100;



    public static double caculateDistance(GPSLocation g1,GPSLocation g2){

        Double lat_a = g1.getLatitude();
        Double lng_a = g1.getLongitude();

        Double lat_b = g2.getLatitude();
        Double lng_b = g2.getLongitude();

//        double latDistance = Math.toRadians(userLat - venueLat);
//        double lngDistance = Math.toRadians(userLng - venueLng);
//
//        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
//                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
//                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
//
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//
//        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));

        double pk = (double)(180 / 3.14169);


        double a1 = lat_a / pk;
        double a2 = lng_a / pk;
        double b1 = lat_b / pk;
        double b2 = lng_b / pk;


        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
        double t3 = Math.sin(a1) * Math.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);


        return 6366000 * tt;

    }
}
