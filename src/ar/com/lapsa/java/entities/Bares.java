package ar.com.lapsa.java.entities;
public class Bares {
    private int id;
    private String bar;
    
    public Bares(int id, String bar) {
        this.id = id;
        this.bar = bar;
    }

    public Bares() {
    }
   

    public Bares(String bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "Bares{"+"id="+ id + "bar=" + bar + '}';
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
