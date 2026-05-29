package lld_topicWise.parkingLot;

import java.util.List;

enum VehicleType {
    CAR, BIKE
}

abstract class Vehicle {
    String licenseNo;

    public Vehicle(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    abstract VehicleType getType();
}

class Car extends Vehicle {
    public Car(String licenseNo) {
        super(licenseNo);
    }

    @Override
    VehicleType getType() {
        return VehicleType.CAR;
    }
}

class Bike extends Vehicle {
    public Bike(String licenseNo) {
        super(licenseNo);
    }

    @Override
    VehicleType getType() {
        return VehicleType.BIKE;
    }
}

class VehicleFactory {
    public static Vehicle getVehicle(VehicleType type, String plate) {
        switch (type) {
            case CAR:
                return new Car(plate);
            case BIKE:
                return new Bike(plate);
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

abstract class ParkingSpot {
    boolean isFree = true;
    Vehicle vehicle;

    boolean isFree() {
        return isFree;
    }

    void park(Vehicle v) {
        isFree = false;
        vehicle = v;
    }

    void dePark() {
        isFree = true;
        vehicle = null;
    }

    abstract VehicleType getAllowedType();
}

class CarParkingSpot extends ParkingSpot {
    @Override
    VehicleType getAllowedType() {
        return VehicleType.CAR;
    }
}

class BikeParkingSpot extends ParkingSpot {
    @Override
    VehicleType getAllowedType() {
        return VehicleType.BIKE;
    }
}

class ParkingFloor {
    List<ParkingSpot> spots;

    public ParkingFloor(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    ParkingSpot getAvailableSpot(Vehicle v) {
        for (ParkingSpot p : spots) {
            if (v.getType() == p.getAllowedType() && p.isFree) {
                return p;
            }
        }
        return null;
    }
}

class ParkingLot {
    List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    ParkingSpot getAvailableSpot(Vehicle v) {
        for (ParkingFloor f : floors) {
            ParkingSpot spot = f.getAvailableSpot(v);
            if (spot != null) return spot;
        }
        return null;
    }
}

interface PricingStrategy {
    double calculatePrice(long minutes, Vehicle v);
}

class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(long minutes, Vehicle v) {
        int ratePerHour;
        switch (v.getType()) {
            case BIKE:
                ratePerHour = 20;
                break;
            case CAR:
                ratePerHour = 50;
                break;
            default:
                ratePerHour = 30;
        }
        return Math.ceil(minutes / 60.0) * ratePerHour;
    }
}

class DynamicPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(long minutes, Vehicle v) {
        int ratePerHour;
        switch (v.getType()) {
            case BIKE:
                ratePerHour = 20;
                break;
            case CAR:
                ratePerHour = 50;
                break;
            default:
                ratePerHour = 30;
        }
        double base = Math.ceil(minutes / 60.0) * ratePerHour;
        return base * 1.2; // surge multiplier
    }
}

class Ticket {
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    long entryTime;

    public Ticket(Vehicle v, ParkingSpot s) {
        this.vehicle = v;
        this.parkingSpot = s;
        this.entryTime = System.currentTimeMillis();
    }

    public double calculateBill(PricingStrategy strategy) {
        long durationMinutes = (System.currentTimeMillis() - entryTime) / (1000 * 60);
        return strategy.calculatePrice(durationMinutes, vehicle);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}