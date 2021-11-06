package A_A_basics;

public class A_F_methods_HOMEWORK_1 {
    //Create a method called displayHighScorePosition
    //It should a players name as parameter, and 2nd parameter as a position in the high score table
    //You should display the players name along with a message like " managed to get into position " and
    //the position they got and a further message " on the higher score table".

    //Create a 2nd method called calculateHighScorePosition
    //It should be sent one argument only, the player score
    //it should return an int
    //the return data should be
    //1 if the score is >= 1000
    //2 if the score is >= 500 and < 1000
    //3 if the score is >= 100 and < 500
    //4 in all others cases

    //a score of 1500, 900, 400 and 50

    public static void main(String[] args) {
        int player_1 = 1500;
        int player_2 = 900;
        int player_3 = 400;
        int player_4 = 50;

        int highScorePosition = calculateHighScorePosition(player_1);
        displayHighScorePosition("Player1", highScorePosition);
        highScorePosition = calculateHighScorePosition(player_2);
        displayHighScorePosition("Player2", highScorePosition);
        highScorePosition = calculateHighScorePosition(player_3);
        displayHighScorePosition("Player3", highScorePosition);
        highScorePosition = calculateHighScorePosition(player_4);
        displayHighScorePosition("Player4", highScorePosition);

    }
    public static void displayHighScorePosition(String playerName, int highScorePosition){
        System.out.printf("%s managed to get into position %s\n",playerName,highScorePosition);
        System.out.println("on the higher score table");
    }
    public static int calculateHighScorePosition(int score){
        if (score >= 1000){
            return 1;
        }else if(score >= 500){
            return 2;
        }else if (score >= 100){
            return 3;
        }else return 4;
    }
}
