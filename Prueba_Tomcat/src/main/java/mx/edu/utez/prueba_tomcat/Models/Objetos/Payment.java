package mx.edu.utez.prueba_tomcat.Models.Objetos;



public class Payment {


    private int id;
    private String paymentType;
    private boolean paymentCheckout;
    private int teamId;

    public Payment() {
    }

    public Payment(int id, String paymentType, boolean paymentCheckout, int teamId) {
        this.id = id;
        this.paymentType = paymentType;
        this.paymentCheckout = paymentCheckout;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isPaymentCheckout() {
        return paymentCheckout;
    }

    public void setPaymentCheckout(boolean paymentCheckout) {
        this.paymentCheckout = paymentCheckout;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

}
