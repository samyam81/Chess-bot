import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class Path_Node {
    private Map<String, Path_Node> childNodeList;

    public Path_Node() {
        childNodeList = new HashMap<>();
    }

    public void createSubtree(Chess c) {
        List<String> allMoves = c.getAllMoves();
        for (String move : allMoves) {
            c.changeToRealCoordinates(move.charAt(0), move.charAt(1), move.charAt(2), move.charAt(3));
            childNodeList.put(move, new Path_Node());
        }
    }

    public float alphaBeta(Chess c, int depth, float alpha, float beta, boolean maximizingPlayer, boolean initialTurn) {
        if (depth == 0)
            return c.evaluateBoard(initialTurn);
        createSubtree(c);
        float points = maximizingPlayer ? -9999 : 9999;
        for (Map.Entry<String, Path_Node> entry : childNodeList.entrySet()) {
            String move = entry.getKey();
            if (c.getPiece(move.charAt(2), move.charAt(3)) == Chess.W_KING - 7 * c.getTurn()) {
                childNodeList.clear();
                return maximizingPlayer ? 9999 : -9999;
            }
            c.movePiece(move.charAt(0), move.charAt(1), move.charAt(2), move.charAt(3), false, false);
            points = maximizingPlayer
                    ? Math.max(points, entry.getValue().alphaBeta(c, depth - 1, alpha, beta, false, initialTurn))
                    : Math.min(points, entry.getValue().alphaBeta(c, depth - 1, alpha, beta, true, initialTurn));
            if (maximizingPlayer)
                alpha = Math.max(alpha, points);
            else
                beta = Math.min(beta, points);
            depth++;
            c.movePieceBack(move.charAt(0), move.charAt(1), move.charAt(2), move.charAt(3));
            if (alpha >= beta)
                break;
        }
        childNodeList.clear();
        return points;
    }

    public String alphaBetaRoot(Chess c, int difficulty) {
        createSubtree(c);
        List<String> idealMoves = new ArrayList<>();
        float maxMoveScore = -9999;
        for (Map.Entry<String, Path_Node> entry : childNodeList.entrySet()) {
            String move = entry.getKey();
            if (c.getPiece(move.charAt(2), move.charAt(3)) == Chess.W_KING - 7 * !c.getTurn()) {
                childNodeList.clear();
                return move;
            }
            c.movePiece(move.charAt(0), move.charAt(1), move.charAt(2), move.charAt(3), false, false);
            float moveScore = entry.getValue().alphaBeta(c, difficulty, -10000, 10000, false, !c.getTurn());
            if (moveScore > maxMoveScore) {
                maxMoveScore = moveScore;
                idealMoves.clear();
                idealMoves.add(move);
            } else if (moveScore == maxMoveScore)
                idealMoves.add(move);
            c.movePieceBack(move.charAt(0), move.charAt(1), move.charAt(2), move.charAt(3));
        }
        childNodeList.clear();
        int randomIndex = (int) (Math.random() * idealMoves.size());
        return idealMoves.get(randomIndex);
    }
}
