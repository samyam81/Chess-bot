public class player {
    protected String name; // name of the player
    private int score = 0; // score of the player
    private boolean castling = true; // if true the player can castle, if false the player cannot castle anymore
                                     // during the game

    public player(String name) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        player player = (player) obj;
        return score == player.score &&
                castling == player.castling &&
                name.equals(player.name);
    }
}
