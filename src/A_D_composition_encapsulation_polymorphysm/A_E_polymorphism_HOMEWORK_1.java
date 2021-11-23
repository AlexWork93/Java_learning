package A_D_composition_encapsulation_polymorphysm;

public class A_E_polymorphism_HOMEWORK_1 {
    // We are going to go back to the car analogy.
    // Create a base class called Car
    // It should have a few fields that would be appropriate for a generice car calss.
    // engine, cylinders, wheels, etc.
    // Constructor should initialize cylinders (number of) and name, and set wheels to 4
    // and engine to true. Cylinders and names would be passed parameters.
    //
    // Create appropriate getters
    //
    // Create some methods like startEngine, accelerate, and brake
    //
    // show a message for each in the base class
    // Now create 3 sub classes for your favorite vehicles.
    // Override the appropriate methods to demonstrate polymorphism in use.
    // put all classes in the one java file (this one).
    public static void main(String[] args) {
        Car myTodayCar = getCar();
        myTodayCar.accelerate(50);
        myTodayCar.startEngine();
        myTodayCar.setForwardGear();
        myTodayCar.setGear(2);
        myTodayCar.accelerate(50);
        myTodayCar.setGear(5);
    }

    public static Car getCar(){
        int car = (int) (Math.random() * 3) + 1;
        switch (car) {
            case 1 -> {
                System.out.println("Your today car is Hyundai");
                Engine hyundaiEngine = new Engine("Hyundai engine", "12323445", 6, "gas");
                Transmission hyundaiTransmission = new Transmission("Hyundai Transmission", "2342364", 5, 2);
                return new Hyundai(hyundaiEngine, hyundaiTransmission);
            }
            case 2 -> {
                System.out.println("Your today car is Nissan");
                Engine nissanEngine = new Engine("Nissan engine", "123453445", 4, "petrol");
                Transmission nissanTransmission = new Transmission("Nissan Transmission", "2123124364", 5, 1);
                return new Nissan(nissanEngine, nissanTransmission);
            }
            default -> {
                System.out.println("Your today car is Default Car");
                Engine defaultCarEngine = new Engine("Default car engine", "123453445", 4, "diesel");
                Transmission defaultCarTransmission = new Transmission("Default car Transmission", "2123124364", 5, 1);
                return new DefaultCar(defaultCarEngine, defaultCarTransmission);
            }
        }
    }
}

class Car_Parts{
    private String name;
    private String serialNumber;

    public Car_Parts(String name, String serialNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}

class Engine extends Car_Parts{
    private int amountOfCylinders;
    private String typeOfFuel;
    private boolean switchOn;
    private int accelerate;

    public Engine(String name, String serialNumber, int amountOfCylinders, String typeOfFuel) {
        super(name, serialNumber);
        if (amountOfCylinders < 0) {
            this.amountOfCylinders = 0;
            System.out.println("ERROR. Amount of cylinders must be positive!");
        }
        else if (amountOfCylinders > 8) {
            this.amountOfCylinders = 8;
            System.out.println("Amount of cylinders is set to 8 because in must be less than or equal to 8");
        }
        else {
            this.amountOfCylinders = amountOfCylinders;
            System.out.printf("Amount of cylinders is set to %s\n", this.amountOfCylinders);
        }
        if (typeOfFuel.equalsIgnoreCase("gas") 
                || typeOfFuel.equalsIgnoreCase("petrol") 
                || typeOfFuel.equalsIgnoreCase("diesel"))
        {
            this.typeOfFuel = typeOfFuel;
            System.out.printf("Your engine will use %s\n", this.typeOfFuel);
        }
        else {
            this.typeOfFuel = "Unknown type fuel";
            System.out.printf("ERROR. %s\n", this.typeOfFuel);
        }
        this.switchOn = false;
        this.accelerate = 0;
        System.out.println("=====================================================\n\n");
    }

    public boolean isSwitchOn() {
        return switchOn;
    }

    public void setAccelerate (int accelerate){
        if (switchOn) {
            if (accelerate < 0) {
                this.accelerate = 0;
                System.out.println("ERROR. Amount of accelerate must be positive!");
            } else if (accelerate > 100) {
                this.accelerate = 100;
                System.out.println("Amount of cylinders is set to 100% because in must be less than or equal to 100%");
            } else {
                this.accelerate = accelerate;
                System.out.printf("Accelerate is set to %s\n", this.accelerate);
            }
        }else System.out.println("You should switch engine on first");
        System.out.println("=====================================================\n\n");
    }
    
    public void startEngine(boolean neutralGear){
        if (switchOn){
            System.out.println("Your engine is already powered up");
        } else if (!neutralGear) {
            System.out.println("Set transmission to neutral position before start engine");
        }else if (this.accelerate > 0){
            System.out.println("Set accelerate to 0 before start engine");
        }else {
            this.switchOn = true;
            System.out.println("Engine is powered up");
        }
        System.out.println("=====================================================\n\n");
    }
    
    public void stopEngine(boolean neutralGear){
        if (!switchOn){
            System.out.println("Your engine is already powered down");
        } else if (!neutralGear) {
            System.out.println("Set transmission to neutral position before stop engine");
        }else if (this.accelerate > 0){
            System.out.println("Set accelerate to 0 before stop engine");
        }else {
            this.switchOn = false;
            System.out.println("Engine is powered down");
        }
        System.out.println("=====================================================\n\n");
    }
    
}

class Transmission extends Car_Parts{
    private int amountOfGears;
    private int amountOfReverseGears;
    private int currentGear;
    private boolean reverseGear;
    private boolean neutralGear;

    public Transmission(String name, String serialNumber, int amountOfGears, int amountOfReverseGears) {
        super(name, serialNumber);

        if (amountOfGears < 0) {
            this.amountOfGears = 0;
            System.out.println("ERROR. Amount of gears must be positive!");
        }
        else if (amountOfGears > 8) {
            this.amountOfGears = 8;
            System.out.println("Amount of gears is set to 8 because in must be less than or equal to 8");
        }
        else {
            this.amountOfGears = amountOfGears;
            System.out.printf("Amount of gears is set to %s\n", this.amountOfGears);
        }
        
        if (amountOfReverseGears < 0) {
            this.amountOfReverseGears = 0;
            System.out.println("ERROR. Amount of reverse gears must be positive!");
        }
        else if (amountOfReverseGears > 2) {
            this.amountOfReverseGears = 2;
            System.out.println("Amount of reverse gears is set to 8 because in must be less than or equal to 2");
        }
        else {
            this.amountOfReverseGears = amountOfReverseGears;
            System.out.printf("Amount of reverse gears is set to %s\n", this.amountOfReverseGears);
        }
        this.currentGear = 0;
        this.reverseGear = false;
        this.neutralGear = true;
        System.out.println("=====================================================\n\n");
    }

    public boolean isNeutralGear() {
        return neutralGear;
    }

    public void setCurrentGear(int gear, boolean isEnginePoweredUp){
        if (gear < 1 && (gear > this.amountOfGears || gear > this.amountOfReverseGears)){
            System.out.println("ERROR. invalid gear.\n"
                    + "Valid values for gear are in range from 1 till " + amountOfGears + "\n"
                    + "Valid values for reverse gear are in range from 1 till " + amountOfReverseGears);
        }else if (!isEnginePoweredUp){
            System.out.println("You should switch your engine on before selecting of gear");
        }else if(!neutralGear) {
            System.out.println("You should switch your gear to the neutral position");
        }else {
                this.neutralGear = false;
                this.currentGear = gear;
                if (!reverseGear){
                    System.out.println("Current gear is " + this.currentGear);
                } else System.out.println("Current reverse gear is " + this.currentGear);
        }
        System.out.println("=====================================================\n\n");
    }

    public void setReverseGear(){
        if(this.neutralGear){
            this.currentGear = 0;
            this.reverseGear = true;
            System.out.println("Reverse gear is set to true and current gear is set to 0");
        } else System.out.println("Select gear to the neutral position");
        System.out.println("=====================================================\n\n");
    }

    public void setForwardGear(){
        if(this.neutralGear){
            this.currentGear = 0;
            this.reverseGear = false;
            System.out.println("Reverse gear is set to false and current gear is set to 0");
        } else System.out.println("Select gear to the neutral position");
        System.out.println("=====================================================\n\n");
    }

    public void setNeutralGear() {
        this.currentGear = 0;
        this.neutralGear = true;
        System.out.println("Neutral gear is set to true and current gear is set to 0");
        System.out.println("=====================================================\n\n");
    }
}

class Car {
    private String name = "I am default car";
    private Engine engine;
    private Transmission transmission;

    public Car(String name, Engine engine, Transmission transmission) {
        this.name = name;
        this.engine = engine;
        this.transmission = transmission;
    }

    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getName() {
        return name;
    }

    public void accelerate(int accelerate) {
        engine.setAccelerate(accelerate);
    }
    public void startEngine() {
        boolean isNeutralGear = transmission.isNeutralGear();
        engine.startEngine(isNeutralGear);
    }
    public void stopEngine() {
        engine.stopEngine(transmission.isNeutralGear());
    }
    public void setGear(int gear) {
        transmission.setCurrentGear(gear, engine.isSwitchOn());
    }
    public void setForwardGear() {
        transmission.setForwardGear();
    }
    public void setReverseGear() {
        transmission.setReverseGear();
    }
}

class Hyundai extends Car {
    public Hyundai(Engine engine, Transmission transmission) {
        super("My name is Hyundai", engine, transmission);
    }

    @Override
    public void startEngine() {
        System.out.println("Hello! " + super.getName());
        super.startEngine();
    }
}

class Nissan extends Car {
    public Nissan(Engine engine, Transmission transmission) {
        super("My name is Nissan", engine, transmission);
    }

    @Override
    public void startEngine() {
        System.out.println("Hello! " + super.getName());
        super.startEngine();
    }
}

class DefaultCar extends Car {
    public DefaultCar(Engine engine, Transmission transmission) {
        super(engine, transmission);
    }
}











































