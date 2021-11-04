package A_A_basics;

public class A_B_floating_point_numbers {
    public static void main(String[] args) {
        String mess = "All numbers with fractional part are called floating point numbers\n";
        mess += "Let's find out min and max values of float and double types\n";
        float minFloatValue = Float.MIN_VALUE;
        float maxFloatValue = Float.MAX_VALUE;
        mess += "Min value of Float = " + minFloatValue + "\n";
        mess += "Max Value of Float = " + maxFloatValue + "\n";
        double minDoubleValue = Double.MIN_VALUE;
        double maxDoubleValue = Double.MAX_VALUE;
        mess += "Min value of Float = " + minDoubleValue + "\n";
        mess += "Max Value of Float = " + maxDoubleValue + "\n";

        System.out.println(mess);
    }
}
