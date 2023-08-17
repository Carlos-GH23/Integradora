package mx.edu.utez.prueba_tomcat.Models.Objetos;

import java.sql.Date;
import java.sql.Time;

public class Matchday {
    private int id;
    private String match_field;
    private Time starthour;
    private Time endhour;
    private Date date_match;
    private String points;
    private int draws;
    private int wins;
    private int loses;
    private int goal_difference;
    private int goals_scored;
    private int goals_against;
    private int clasification;

    public Matchday(){

    }

    public Matchday(int id, String match_field, Time starthour, Time endhour, Date date_match, String points, int draws, int wins, int loses, int goal_difference, int goals_scored, int goals_against, int clasification) {
        this.id = id;
        this.match_field = match_field;
        this.starthour = starthour;
        this.endhour = endhour;
        this.date_match = date_match;
        this.points = points;
        this.draws = draws;
        this.wins = wins;
        this.loses = loses;
        this.goal_difference = goal_difference;
        this.goals_scored = goals_scored;
        this.goals_against = goals_against;
        this.clasification = clasification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatch_field() {
        return match_field;
    }

    public void setMatch_field(String match_field) {
        this.match_field = match_field;
    }

    public Time getStarthour() {
        return starthour;
    }

    public void setStarthour(Time starthour) {
        this.starthour = starthour;
    }

    public Time getEndhour() {
        return endhour;
    }

    public void setEndhour(Time endhour) {
        this.endhour = endhour;
    }

    public Date getDate_match() {
        return date_match;
    }

    public void setDate_match(Date date_match) {
        this.date_match = date_match;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGoal_difference() {
        return goal_difference;
    }

    public void setGoal_difference(int goal_difference) {
        this.goal_difference = goal_difference;
    }

    public int getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(int goals_scored) {
        this.goals_scored = goals_scored;
    }

    public int getGoals_against() {
        return goals_against;
    }

    public void setGoals_against(int goals_against) {
        this.goals_against = goals_against;
    }

    public int getClasification() {
        return clasification;
    }

    public void setClasification(int clasification) {
        this.clasification = clasification;
    }
}