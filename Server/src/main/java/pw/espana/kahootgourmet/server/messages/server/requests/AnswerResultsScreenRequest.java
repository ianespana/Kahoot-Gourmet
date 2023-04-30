package pw.espana.kahootgourmet.server.messages.server.requests;

import pw.espana.kahootgourmet.server.messages.Message;

public class AnswerResultsScreenRequest extends Message {
    private final int id = 0x03;
    private final boolean correct;
    private final int pointsGained;
    private final int totalPoints;
    private final int place;

    public AnswerResultsScreenRequest(boolean correct, int pointsGained, int totalPoints, int place) {
        this.correct = correct;
        this.pointsGained = pointsGained;
        this.totalPoints = totalPoints;
        this.place = place;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getPointsGained() {
        return pointsGained;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getPlace() {
        return place;
    }
}