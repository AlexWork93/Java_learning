package A_A_basics;

public class A_C_char_boolean {
    public static void main(String[] args) {
        String mess = "Char type saves single character numbers in unicode format\n";
        mess += "table of unicode is represented on unicode-table.com \n";
        char letterD = 'D';
        char letterD_uni = '\u0044';
        mess += letterD + "\n";
        mess += letterD_uni + "\n";
        mess += "\n==================================================================================\n";
        mess += "Boolean contains only 2 values false or true\n";

        System.out.println(mess);
    }
}
