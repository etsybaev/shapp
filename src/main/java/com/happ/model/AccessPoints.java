package com.happ.model;

import javax.persistence.*;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

@Entity
public class AccessPoints {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "accessPointName", updatable = false)
    private String accessPointName;
    @Column(name = "description", updatable = false)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessPointName() {
        return accessPointName;
    }

    public void setAccessPointName(String accessPointName) {
        this.accessPointName = accessPointName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AccessPoints{" +
                "id=" + id +
                ", accessPointName='" + accessPointName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
