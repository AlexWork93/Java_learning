package A_D_composition_encapsulation_polymorphysm;

public class A_A_composition_HOMEWORK_1 {
    public static void main(String[] args) {
        Closet closet = new Closet("newCloset", "wood", "green");
        Table table = new Table("newTable", "DSP", "brown");
        Sofa sofa = new Sofa("newSofa", "something soft", "yellow");

        Room room = new Room(closet, table,sofa);
        room.getCloset().getColor();
        room.getCloset().getName();
        room.getCloset().getMaterial();
        room.getTable().putSomething();
        room.getTable().putSomething();
        room.getTable().clearTable();
        room.getTable().putSomething();
        room.getCloset().open();
        room.getCloset().isOpen();
        room.getCloset().close();
        room.getCloset().isOpen();
    }
}
class Furniture {
    private String name;
    private String material;
    private String color;

    public Furniture(String name, String material, String color) {
        this.name = name;
        this.material = material;
        this.color = color;
    }

    public void getName() {
        System.out.printf("I am %s\n", name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getMaterial() {
        System.out.printf("I made from %s\n", material);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void getColor() {
        System.out.printf("I am %s\n", color);
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Closet extends Furniture{
    private boolean isOpen;
    public Closet(String name, String material, String color) {
        super(name, material, color);
    }
    public void isOpen(){
        String openClose;
        if (isOpen) openClose = "open";
        else openClose = "close";
        System.out.println("I am Closet");
        System.out.printf("I am %s now\n", openClose);
    }
    public void open(){
        this.isOpen = true;
    }
    public void close(){
        this.isOpen = false;
    }

    @Override
    public void getName() {
        System.out.println("I am Closet");
        super.getName();
    }

    @Override
    public void getMaterial() {
        System.out.println("I am Closet");
        super.getMaterial();
    }

    @Override
    public void getColor() {
        System.out.println("I am Closet");
        super.getColor();
    }
}

class Table extends Furniture{
    private boolean isEmpty;

    public Table(String name, String material, String color) {
        super(name, material, color);
        this.isEmpty = true;
    }
    public void putSomething(){
        if (isEmpty) {
            this.isEmpty = false;
            System.out.println("I am Table");
            System.out.println("You are able to put something");
        }
        else System.out.println("Table is not empty! It must be cleared before");
    }
    public void clearTable(){
        if (isEmpty) System.out.println("Table is already empty");
        else {
            this.isEmpty = true;
            System.out.println("Table is successfully cleared, you may put something");
        }
    }

    @Override
    public void getName() {
        System.out.println("I am Table");
        super.getName();
    }

    @Override
    public void getMaterial() {
        System.out.println("I am Table");
        super.getMaterial();
    }

    @Override
    public void getColor() {
        System.out.println("I am Table");
        super.getColor();
    }
}

class Sofa extends Furniture {
    public Sofa(String name, String material, String color) {
        super(name, material, color);
    }

    @Override
    public void getName() {
        System.out.println("I am Sofa");
        super.getName();
    }

    @Override
    public void getMaterial() {
        System.out.println("I am Sofa");
        super.getMaterial();
    }

    @Override
    public void getColor() {
        System.out.println("I am Sofa");
        super.getColor();
    }

}

class Room {
    private Closet closet;
    private Table table;
    private Sofa sofa;

    public Room(Closet closet, Table table, Sofa sofa) {
        this.closet = closet;
        this.table = table;
        this.sofa = sofa;
    }

    public Closet getCloset() {
        return closet;
    }

    public Table getTable() {
        return table;
    }

    public Sofa getSofa() {
        return sofa;
    }
}