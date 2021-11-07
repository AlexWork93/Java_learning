package A_A_basics;

public class A_G_overloading {
    // Overloading is using method with the same method name, but with different parameters.
    public static void main(String[] args) {
        System.out.printf("New score is %s\n",calculateScore("player1", 500));
        System.out.printf("New score is %s\n",calculateScore(236));
        System.out.printf("New score is %s\n",calculateScore());

    }
    public static int calculateScore(String playerName, int score){
        System.out.printf("Player %s scored %S points\n",playerName , score);
        return score * 1000;
    }
    //OVERLOADED METHOD
    public static int calculateScore(int score){
        System.out.printf("Unnamed player scored %S points\n",score);
        return score * 1000;
    }
    //OVERLOADED METHOD
    public static int calculateScore(){
        System.out.printf("No player name, no player score\n");
        return 0;
    }
}
