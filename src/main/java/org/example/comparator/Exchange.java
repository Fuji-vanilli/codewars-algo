package org.example.comparator;

import java.util.Date;

public class Exchange {
    private String name;
    private double taux;
    private Date date;

    public Exchange(String name, double taux, Date date) {
        this.name = name;
        this.taux = taux;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
