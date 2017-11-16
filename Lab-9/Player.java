public class Player {
    private String name;
    private int score;
    private int gamesWon;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.gamesWon = 0;
    }

    public void won() {
        this.gamesWon++;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    };

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name; 
    }
}
