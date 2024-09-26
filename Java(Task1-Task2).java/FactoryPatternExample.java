interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Car is being driven");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Bike is being ridden");
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        return null;
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();

        Vehicle bike = VehicleFactory.createVehicle("bike");
        bike.drive();
    }
}
