package mx.edu.utez.prueba_tomcat.Models.Objetos;

public class Team {

    private int id;
    private String name;
    private int members;
    private int matchdayId;

    public Team() {
    }

    public Team(int id, String name, int members, int matchdayId) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.matchdayId = matchdayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getMatchdayId() {
        return matchdayId;
    }

    public void setMatchdayId(int matchdayId) {
        this.matchdayId = matchdayId;
    }
}
