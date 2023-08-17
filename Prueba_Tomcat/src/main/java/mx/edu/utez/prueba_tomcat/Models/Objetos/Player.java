package mx.edu.utez.prueba_tomcat.Models.Objetos;


import java.io.InputStream;

public class Player{


    private int id;
    private String name;
    private String surname;
    private String surname2;
    private String position;
    private String dorsal;
    private int teamId;
    private InputStream imagen;
    private String file;
    private String fileName;
    private Team team;



    public Player() {
    }

    public Player(String name, String surname, String surname2, InputStream imagen, String file) {
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
        this.imagen = imagen;
        this.file = file;
    }

    public Player(int id, String name, String surname, String surname2, String position, String dorsal, int teamId, Team team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
        this.position = position;
        this.dorsal = dorsal;
        this.teamId = teamId;
        this.team = team;
    }

    public Player(int id, String name, String surname, String surname2, String position, String dorsal, int teamId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
        this.position = position;
        this.dorsal = dorsal;
        this.teamId = teamId;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", surname2='" + surname2 + '\'' +
                ", position='" + position + '\'' +
                ", dorsal='" + dorsal + '\'' +
                ", teamId=" + teamId +
                ", imagen=" + imagen +
                ", fileName='" + fileName + '\'' +
                ", team=" + team +
                '}';
    }
}
