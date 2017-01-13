package com.happ.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

@Entity
public class AccessHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userId")
    private int userId;
    //@Column(name = "accessPointId")
    //private int accessPointId;
    //Instead of Id field we map the AccessPoint Table
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="accessPointId")
    private AccessPoints accessPoints;
    @Column(name = "datetime")
    @GeneratedValue
    private Date datetime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public int getAccessPointId() {
//        return accessPointId;
//    }
//
//    public void setAccessPointId(int accessPointId) {
//        this.accessPointId = accessPointId;
//    }

    public AccessPoints getAccessPoints() {
        return accessPoints;
    }

    public void setAccessPoints(AccessPoints accessPoints) {
        this.accessPoints = accessPoints;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }


    @Override
    public String toString() {
        return "AccessHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", accessPoints=" + accessPoints +
                ", datetime=" + datetime +
                '}';
    }
}
