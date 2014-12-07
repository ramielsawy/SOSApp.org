/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sosapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a534352
 */
@Entity
@Table(name = "place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findById", query = "SELECT p FROM Place p WHERE p.id = :id"),
    @NamedQuery(name = "Place.findByName", query = "SELECT p FROM Place p WHERE p.name = :name"),
    @NamedQuery(name = "Place.findByAddress", query = "SELECT p FROM Place p WHERE p.address = :address"),
    @NamedQuery(name = "Place.findByLat", query = "SELECT p FROM Place p WHERE p.lat = :lat"),
    @NamedQuery(name = "Place.findByLong1", query = "SELECT p FROM Place p WHERE p.long1 = :long1"),
    @NamedQuery(name = "Place.findByUserId", query = "SELECT p FROM Place p WHERE p.userId = :userId")})
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 80)
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lat")
    private Float lat;
    @Column(name = "long")
    private Float long1;
    @Column(name = "user_id")
    private Integer userId;
    @OneToMany(mappedBy = "place")
    private Collection<SosCall> sosCallCollection;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Place() {
    }

    public Place(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLong1() {
        return long1;
    }

    public void setLong1(Float long1) {
        this.long1 = long1;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<SosCall> getSosCallCollection() {
        return sosCallCollection;
    }

    public void setSosCallCollection(Collection<SosCall> sosCallCollection) {
        this.sosCallCollection = sosCallCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sosapp.entity.Place[ id=" + id + " ]";
    }
    
}
