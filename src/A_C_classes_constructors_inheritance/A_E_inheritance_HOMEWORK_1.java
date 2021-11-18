package A_C_classes_constructors_inheritance;

public class A_E_inheritance_HOMEWORK_1 {
    // Challenge.
    // Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
    // Finally, create another class, a specific type of Car that inherits from the Car class.
    // You should be able to hand steering, changing gears, and moving (speed in other words).
    // You will want to decide where to put the appropriate state and behaviours (fields and methods).
    // As mentioned above, changing gears, increasing/decreasing speed should be included.
    // For you specific type of vehicle you will want to add something specific for that type of car.

    public static void main(String[] args) {
        Car car = new Car(5, 4, 4);
        car.setGear();
        System.out.println("==================================================");
        car.setGear(2);
        System.out.println("==================================================");
        car.setGear(3);
        System.out.println("==================================================");
    }
}

class Vehicle {
    private int amountOfSits;
    private int amountOfWheels;

    public Vehicle(int amountOfSits, int amountOfWheels) {
        this.amountOfSits = amountOfSits;
        this.amountOfWheels = amountOfWheels;
    }

    public int getAmountOfSits() {
        return amountOfSits;
    }

    public int getAmountOfWheels() {
        return amountOfWheels;
    }

    public void move(int speed){
        System.out.println("vehicle's max speed is: " + speed);
    }
}

class Car  extends Vehicle{
    private int amountOfDoors;
    private int gear;

    public Car(int amountOfSits, int amountOfWheels, int amountOfDoors) {
        super(amountOfSits, amountOfWheels);
        this.amountOfDoors = amountOfDoors;
        this.gear = 0;
    }
    public void setGear() {
        setGear(0);
    }
    public void setGear(int gear) {
        this.gear = gear;
        System.out.println("The gear is set up to: " + gear);
        selectSpeed(this.gear);
    }

    @Override
    public void move(int speed) {

        System.out.println("now we are on the car");
        super.move(speed);
    }

    private void selectSpeed(int gear){
         switch (gear) {
            case 0 -> move(0);
            case 1 -> move(10);
            case 2 -> move(20);
            case 3 -> move(30);
            default -> move(40);
        }
    }



}
