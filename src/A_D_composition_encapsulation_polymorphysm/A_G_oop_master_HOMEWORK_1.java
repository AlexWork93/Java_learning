package A_D_composition_encapsulation_polymorphysm;

public class A_G_oop_master_HOMEWORK_1 {
    // The purpose of the application is to help a fictitious company called Bills Burgers to manage
    // their process of selling hamburgers.
    // Our application will help Bill to select types of burgers, some of the additional items (additions) to
    // be added to the burgers and pricing.
    // We want to create a base hamburger, but also two other types of hamburgers that are popular ones in Bills store.
    // The basic hamburger should have the following items.
    // Bread roll type, meat and up to 4 additional additions (things like lettuce, tomato, carrot, etc) that
    // the customer can select to be added to the burger.
    // Each one of these items gets charged an additional price so you need some way to track how many items got added
    // and to calculate the final price (base burger with all the additions).
    // This burger has a base price and the additions are all separately priced (up to 4 additions, see above).
    // Create a Hamburger class to deal with all the above.
    // The constructor should only include the roll type, meat and price, can also include name of burger or you
    // can use a setter.
    // Also create two extra varieties of Hamburgers (subclasses) to cater for
    // a) Healthy burger (on a brown rye bread roll), plus two addition items that can be added.
    // The healthy burger can have 6 items (Additions) in total.
    // hint:  you probably want to process the two additional items in this new class (subclass of Hamburger),
    // not the base class (Hamburger), since the two additions are only appropriate for this new class
    // (in other words new burger type).
    // b) Deluxe hamburger - comes with chips and drinks as additions, but no extra additions are allowed.
    // hint:  You have to find a way to automatically add these new additions at the time the deluxe burger
    // object is created, and then prevent other additions being made.
    //  All 3 classes should have a method that can be called anytime to show the base price of the hamburger
    // plus all additionals, each showing the addition name, and addition price, and a grand/final total for the
    // burger (base price + all additions)
    // For the two additional classes this may require you to be looking at the base class for pricing and then
    // adding totals to final price.
    public static void main(String[] args) {
        Health_Burger health_burger = new Health_Burger("health burger",5,true );
        health_burger.setCarrot(true);
        health_burger.setMushrooms(true);
        health_burger.orderCheckOut();

        Cola cola = new Cola(2);
        Chips chips = new Chips(3);

        Deluxe_Burger deluxe_burger = new Deluxe_Burger("deluxe burger", "Classic roll", 5, true, chips, cola);
        deluxe_burger.setCarrot(true);
        deluxe_burger.orderCheckOut();
    }
}
class Hamburgerr {
    private String name;
    private String roll;
    private String mess;
    private int price;
    private int addPrice;
    private boolean meat;
    private boolean lettuce = false;
    private boolean tomato = false;
    private boolean carrot = false;
    private boolean cucumber = false;

    public Hamburgerr(String name, String roll, int price, boolean meat) {
        this.name = name;
        this.roll = roll;
        this.price = price;
        this.meat = meat;
        this.mess = "Your order is:\n"
                + name + ": $" + price + "\n";
        this.addPrice = 0;
    }

    public void setMess(String mess) {
        this.mess += mess;
    }

    public void setAddPrice(int addPrice) {
        this.addPrice += addPrice;
    }


    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public void setCarrot(boolean carrot) {
        this.carrot = carrot;
    }

    public void setCucumber(boolean cucumber) {
        this.cucumber = cucumber;
    }

    public void orderCheckOut () {
        if (lettuce){
            addPrice += 1;
            mess += "   + lettuce: $1\n";
        }
        if (tomato){
            addPrice += 1;
            mess += "   + tomato: $1\n";
        }
        if (carrot){
            addPrice += 1;
            mess += "   + carrot: $1\n";
        }
        if (cucumber){
            addPrice += 1;
            mess += "   + cucumber: $1\n";
        }
        mess += "Checkout:\n"
                + "Burger: $" + price + "\n"
                + "Adds: $" + addPrice + "\n"
                + "Total: $" + (price + addPrice) + "\n";
        System.out.println(mess);
    }
}

class Health_Burger extends Hamburgerr {
    private boolean mushrooms = false;
    private boolean zucchini = false;
    public Health_Burger(String name, int price, boolean meat) {
        super(name, "a brown rye bread roll", price, meat);
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    public void setZucchini(boolean zucchini) {
        this.zucchini = zucchini;
    }

    @Override
    public void orderCheckOut() {
        if (mushrooms){
            setAddPrice(1);
            setMess("   + mushrooms: $1\n");
        }
        if (zucchini){
            setAddPrice(1);
            setMess("   + zucchini: $1\n");
        }
        super.orderCheckOut();
    }
}

class Deluxe_Burger extends Hamburgerr {
    private Chips chips;
    private Cola cola;

    public Deluxe_Burger(String name, String roll, int price, boolean meat, Chips chips, Cola cola) {
        super(name, roll, price, meat);
        this.chips = chips;
        this.cola = cola;
    }

    @Override
    public void setLettuce(boolean lettuce) {
        System.out.println("This addition in not allowed for Deluxe Burger");
    }

    @Override
    public void setTomato(boolean tomato) {
        System.out.println("This addition in not allowed for Deluxe Burger");
    }

    @Override
    public void setCarrot(boolean carrot) {
        System.out.println("This addition in not allowed for Deluxe Burger");
    }

    @Override
    public void setCucumber(boolean cucumber) {
        System.out.println("This addition in not allowed for Deluxe Burger");
    }

    @Override
    public void orderCheckOut() {
        setMess("   + cola: " + cola.getPrise() + "\n"
                + "   + chips: " + chips.getPrise() + "\n");
        setAddPrice(cola.getPrise());
        setAddPrice(chips.getPrise());
        super.orderCheckOut();
    }
}

class Cola {
    private int prise;

    public Cola(int prise) {
        this.prise = prise;
    }

    public int getPrise() {
        return prise;
    }
}

class Chips {
    private int prise;

    public Chips(int prise) {
        this.prise = prise;
    }

    public int getPrise() {
        return prise;
    }
}






























































