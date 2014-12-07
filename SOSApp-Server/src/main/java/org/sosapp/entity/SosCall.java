/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sosapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a534352
 */
@Entity
@Table(name = "sos_call")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SosCall.findAll", query = "SELECT s FROM SosCall s"),
    @NamedQuery(name = "SosCall.findById", query = "SELECT s FROM SosCall s WHERE s.id = :id"),
    @NamedQuery(name = "SosCall.findByTime", query = "SELECT s FROM SosCall s WHERE s.time = :time")})
public class SosCall implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private User user;
    @JoinColumn(name = "place", referencedColumnName = "id")
    @ManyToOne
    private Place place;

    public SosCall() {
    }

    public SosCall(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SosCall)) {
            return false;
        }
        SosCall other = (SosCall) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sosapp.entity.SosCall[ id=" + id + " ]";
    }
    
}
