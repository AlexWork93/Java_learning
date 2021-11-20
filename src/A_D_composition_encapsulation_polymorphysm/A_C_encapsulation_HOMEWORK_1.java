package A_D_composition_encapsulation_polymorphysm;

public class A_C_encapsulation_HOMEWORK_1 {
    // Create a class and demonstate proper encapsulation techniques
    // the class will be called Printer
    // It will simulate a real Computer Printer
    // It should have fields for the toner Level, number of pages printed, and
    // also whether its a duplex printer (capable of printing on both sides of the paper).
    // Add methods to fill up the toner (up to a maximum of 100%), another method to
    // simulate printing a page (which should increase the number of pages printed).
    // Decide on the scope, whether to use constructors, and anything else you think is needed.
    public static void main(String[] args) {
        MyPrinter printer = new MyPrinter(80, 400);
        System.out.println();
        printer.getPaper();
        printer.getToner();
        System.out.println();
        printer.print(100);
        System.out.println();
        printer.getPaper();
        printer.getToner();
        System.out.println();
        printer.setImage(true);
        System.out.println();
        printer.print(150);
        System.out.println();
        printer.service();
        System.out.println();
        printer.print(150);
        System.out.println();
        printer.getPaper();
        printer.getToner();
        System.out.println();
        printer.addPaper(200);
        System.out.println();
        printer.getPaper();
        System.out.println();
        printer.setImage(false);
        printer.setText(false);
        System.out.println();
        printer.print(50);
        System.out.println();
    }
}
class MyPrinter {
    private double toner;
    private double consumingTonerPerPage = 0;
    private int paper;
    private boolean duplex = false;
    private boolean image = false;
    private boolean text = true;

    public MyPrinter(double toner, int paper) {
        if (toner > 100) this.toner = 100;
        else if (toner < 0) this.toner = 0;
        else this.toner = toner;
        if (paper < 0) this.paper = 0;
        else this.paper = paper;

        System.out.println("Default settings are loaded:\n - duplex mode off;\n - image printing off;\n - text printing on.\nTo change settings use setDuplex(), setImage(), setText() methods");
    }

    public void getToner() {
        System.out.printf("Toner %s percent.\n", this.toner);
    }

    public void getPaper() {
        System.out.printf("There are %s leaf of paper available.\n", this.paper);

    }

    public void addPaper (int paper){
        if (paper >= 0){
            this.paper += paper;
            System.out.printf("%s leaf of paper are added.\n%s leaf of paper are available\n",paper, this.paper);
        }
    }

    public void setDuplex(boolean duplex) {
        this.duplex = duplex;
        if(this.duplex)System.out.println("Duplex mode on");
        else System.out.println("Duplex mode off");
    }

    public void setImage(boolean image) {
        this.image = image;
        if(this.image)System.out.println("Image printing mode on");
        else System.out.println("Image printing mode off");
    }

    public void setText(boolean text) {
        this.text = text;
        if(this.text)System.out.println("Text printing mode on");
        else System.out.println("Text printing mode off");
    }

    public void print (int amountOfPages) {
        consumingTonerPerPage();
        if (duplex) {
            this.consumingTonerPerPage *= 2;
            amountOfPages = (int) Math.ceil((double)amountOfPages / 2);
        }

        if (this.paper - amountOfPages < 0){
            System.out.printf("Insufficient paper. You need add %s leaf of paper\n", (amountOfPages - this.paper));
        }else if (this.toner - (this.consumingTonerPerPage * amountOfPages) < 0){
            System.out.println("Insufficient toner. You need service or pass less pages to print per time");
        }else if (!text && !image){
            System.out.println("You need to select at least one of printing function (images or text)");
        }else {
            this.paper -= amountOfPages;
            this.toner -= consumingTonerPerPage * amountOfPages;
            System.out.printf("You have successfully printed %s pages\n", amountOfPages);
        }
    }

    public void service(){
        this.toner = 100;
        System.out.println("Your toner is 100% now");
    }

    private void consumingTonerPerPage (){
        if (image && !text){
            consumingTonerPerPage = 0.5;
        }else if (!image && text){
            consumingTonerPerPage = 0.25;
        }else if (image && text){
            consumingTonerPerPage =  0.6;
        }else consumingTonerPerPage = 0;

    }
}







































