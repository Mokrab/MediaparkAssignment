package proj.mokrab.mediaparkassignment.Model;

import java.util.ArrayList;
import java.util.List;

public class Car {


    //[{"id":40,
// "plateNumber":"TEST40",
// "location":{"id":0,"latitude":54.71978000,"longitude":25.28478000,"address":"J. Balčikonio gatvė 3"},
// "model":{"id":3,"title":"VW e-Up!","photoUrl":"https://s3-eu-west-1.amazonaws.com/rideshareuploads/uploads/f403e69d-13ea-4e7f-aa09-f68e2a91f540.jpeg"},
// "batteryPercentage":87,
// "batteryEstimatedDistance":101.0,
// "isCharging":false}

    private Integer id;
    private String plateNumber;
    private Double batteryPercentage;
    private Double batteryEstimatedDistance;
    private CarLocation location;
    private CarModel model;
    private boolean isCharging;

    public Car(Integer id, String plateNumber, CarLocation location, CarModel model, Double batteryPercentage,
               Double batteryEstimatedDistance, boolean isCharging) {

        this.id = id;
        this.plateNumber = plateNumber;
        this.batteryPercentage = batteryPercentage;
        this.batteryEstimatedDistance = batteryEstimatedDistance;
        this.location = location;
        this.model = model;
        this.isCharging = isCharging;

    }


    public Integer getId() {
        return id;
    }


    public String getPlateNumber() {
        return plateNumber;
    }


    public Double getBatteryPecentage() {
        return batteryPercentage;
    }


    public Double getBatteryEstimatedDistance() {
        return batteryEstimatedDistance;
    }


    public CarLocation getLocation() {
        return location;
    }


    public CarModel getModel() {
        return model;
    }


    public boolean getIsCharging() {
        return isCharging;
    }



}
//[{"id":40,
// "plateNumber":"TEST40",
// "location":{"id":0,"latitude":54.71978000,"longitude":25.28478000,"address":"J. Balčikonio gatvė 3"},
// "model":{"id":3,"title":"VW e-Up!","photoUrl":"https://s3-eu-west-1.amazonaws.com/rideshareuploads/uploads/f403e69d-13ea-4e7f-aa09-f68e2a91f540.jpeg"},
// "batteryPercentage":87,
// "batteryEstimatedDistance":101.0,
// "isCharging":false}
