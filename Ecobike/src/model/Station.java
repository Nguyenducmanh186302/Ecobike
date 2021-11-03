package model;

public class Station {
    private int stationId;
    private String stationName;
    private String stationAddress;
    private int numberOfSingleBike;
    private int numberOfEBike;
    private int numberOfTwinBike;
    private int numberOfEmptyDocks;

    public Station() {
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public int getNumberOfSingleBike() {
        return numberOfSingleBike;
    }

    public void setNumberOfSingleBike(int numberOfSingleBike) {
        this.numberOfSingleBike = numberOfSingleBike;
    }

    public int getNumberOfEBike() {
        return numberOfEBike;
    }

    public void setNumberOfEBike(int numberOfEBike) {
        this.numberOfEBike = numberOfEBike;
    }

    public int getNumberOfTwinBike() {
        return numberOfTwinBike;
    }

    public void setNumberOfTwinBike(int numberOfTwinBike) {
        this.numberOfTwinBike = numberOfTwinBike;
    }

    public int getNumberOfEmptyDocks() {
        return numberOfEmptyDocks;
    }

    public void setNumberOfEmptyDocks(int numberOfEmptyDocks) {
        this.numberOfEmptyDocks = numberOfEmptyDocks;
    }
}
