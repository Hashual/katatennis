package katatennis;

public class TennisGame implements TennisGameInterface {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private static final String PLAYER_NAME = "player1";

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_NAME))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;

        if (player1Score == player2Score) {
            switch (player1Score) {
                case 0:
                    score.append("Love-All");
                    break;
                case 1:
                    score.append("Fifteen-All");
                    break;
                case 2:
                    score.append("Thirty-All");
                    break;
                default:
                    score.append("Deuce");
                    break;
            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) {
                score.append("Advantage player1");
            } else if (minusResult == -1) {
                score.append("Advantage player2");
            } else if (minusResult >= 2) {
                score.append("Win for player1");
            } else {
                score.append("Win for player2");
            }
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score.append("-");
                    tempScore = player2Score;
                }
                switch (tempScore) {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                    default :
                        score.append("Invalid score");
                        break;

                }
            }
        }
        return score.toString();
    }
}