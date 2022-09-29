package com.example.bootjpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    private String tech;
    private int aid;
    private String aname;

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Alien   " +
                "id= " + aid +" "+
                "name= " + aname ;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}
