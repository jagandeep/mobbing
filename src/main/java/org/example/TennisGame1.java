package org.example;

public class TennisGame1 {

    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            player1Points += 1;
        else
            player2Points += 1;
    }

    public String getScore() {
        String score ;
        if (isTied()) return sayTiedScore();
        if (player1Points >= 4 || player2Points >= 4) {
            int minusResult = player1Points - player2Points;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
            return score;
        }
        return nameScore(player1Points)+"-"+nameScore(player2Points);
    }
    private boolean isTied() {
        return player1Points == player2Points;
    }

    private String sayTiedScore() {
        String score;
            switch (player1Points) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
            return score;
    }

    private String nameScore( int tempScore) {
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty", "Deuce"};
        return scoreNames[tempScore];
    }
}
