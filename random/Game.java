package random;

public class Game{

    private enum status { CONTINUE, WON, LOST};

    private status gameStatus = status.CONTINUE;

    public status getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(status gameStatus) {
        this.gameStatus = gameStatus;
    }


    
}