package A_A_basics;

public class A_G_overloading_HOMEWORK_2 {
    //Create a method called getDurationString with two parameters, first parameter minutes and 2nd parameter seconds.
    //You should validate that the first parameter minutes is >= 0.
    //You should validate that the 2nd parameter seconds is >= 0 and <= 59.
    //The method should return gInvalid valueh in the method if either of the above are not true.
    //If the parameters are valid then calculate how many hours minutes and seconds equal the minutes and seconds passed to this method and return that value as string in format gXXh YYm ZZsh where XX represents a number of hours, YY the minutes and ZZ the seconds.
    //Create a 2nd method of the same name but with only one parameter seconds.
    //Validate that it is >= 0, and return gInvalid valueh if it is not true.
    //If it is valid, then calculate how many minutes are in the seconds value and then call the other overloaded method passing the correct minutes and seconds calculated so that it can calculate correctly.
    //Call both methods to print values to the console.
    //Tips:
    //	Use int or long for your number data types is probably a good idea.
    //	1 minute = 60 seconds and 1 hour = 60 minutes or 3600 seconds.
    //	Methods should be static as we have used previously.
    //Bonus:
    //	For the input 61 minutes output should be 01h 01m 00s, but it is ok if it is 1h 1m 0s (Tip: use if-else)
    //	Create a new console project and call it SecondsAndMinutesChallenge
    private static final String INVALID_VALUE_ERROR = "Invalid Value";

    public static void main(String[] args) {
        System.out.println(getDurationString(100,200)); //1h 43m 20s
        System.out.println(getDurationString(0,15));    //0h 0m 15s
        System.out.println(getDurationString(15,0));    //0h 15m 0s
        System.out.println(getDurationString(-25,200)); //Invalid value
        System.out.println(getDurationString(200,0)); //Invalid value
        System.out.println(getDurationString(50,50));   //0h 50m 50s


    }
    public static String getDurationString (int minutes, int seconds){
        if ((minutes < 0) || (seconds < 0)){
            return INVALID_VALUE_ERROR;
        }else if (seconds > 59){
            return getDurationString(minutes * 60 + seconds);
        }else if (minutes > 59){
            int hours = minutes / 60;
            minutes = minutes - hours * 60;
            //minutes = minutes % hours; WRONG!!! coz 100 % 60 != 0

            return String.format("%sh %sm %ss", hours, minutes, seconds);
        }else return String.format("0h %sm %ss", minutes, seconds);
    }
    public static String getDurationString (int seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_ERROR;
        } else if (seconds > 59) {
            int minutes = seconds / 60;
            seconds = seconds - minutes * 60;
            return getDurationString(minutes, seconds);
        } else return String.format("0h 0sm %ss", seconds);
    }
}
