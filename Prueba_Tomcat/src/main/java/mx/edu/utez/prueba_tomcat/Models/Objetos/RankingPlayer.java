package mx.edu.utez.prueba_tomcat.Models.Objetos;

public class RankingPlayer  {

    private int id;
    private int redCard;
    private int yellowCard;
    private int goals;
    private int assistances;
    private int playerId;

    public RankingPlayer() {
    }

    public RankingPlayer(int id, int redCard, int yellowCard, int goals, int assistances, int playerId) {
        this.id = id;
        this.redCard = redCard;
        this.yellowCard = yellowCard;
        this.goals = goals;
        this.assistances = assistances;
        this.playerId = playerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssistances() {
        return assistances;
    }

    public void setAssistances(int assistances) {
        this.assistances = assistances;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

}
