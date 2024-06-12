public class Player1 {
    private String name;
    private int score;
    private boolean castling;

    public Player1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean getCastling() {
        return castling;
    }

    public void setCastling(boolean castling) {
        this.castling = castling;
    }

    public void increaseScore(int inc) {
        score += inc;
    }

    public void reset() {
        score = 0;
        castling = true;
    }

    public boolean equals(Player1 p) {
        return name.equals(p.getName());
    }
}
