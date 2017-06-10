/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Meeru
 */
@Entity
@Table(name = "FINALORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finalorder.findAll", query = "SELECT f FROM Finalorder f")
    , @NamedQuery(name = "Finalorder.findByOrderid", query = "SELECT f FROM Finalorder f WHERE f.orderid = :orderid")
    , @NamedQuery(name = "Finalorder.findByItemid", query = "SELECT f FROM Finalorder f WHERE f.itemid = :itemid")
    , @NamedQuery(name = "Finalorder.findByItemname", query = "SELECT f FROM Finalorder f WHERE f.itemname = :itemname")
    , @NamedQuery(name = "Finalorder.findByItemquanity", query = "SELECT f FROM Finalorder f WHERE f.itemquanity = :itemquanity")
    , @NamedQuery(name = "Finalorder.findByItemprice", query = "SELECT f FROM Finalorder f WHERE f.itemprice = :itemprice")
    , @NamedQuery(name = "Finalorder.findByBuyerid", query = "SELECT f FROM Finalorder f WHERE f.buyerid = :buyerid")})
public class Finalorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private Integer orderid;
    @Column(name = "ITEMID")
    private Integer itemid;
    @Column(name = "ITEMNAME")
    private String itemname;
    @Column(name = "ITEMQUANITY")
    private Integer itemquanity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ITEMPRICE")
    private float itemprice;
    @Column(name = "BUYERID")
    private Integer buyerid;

    public Finalorder() {
    }

    public Finalorder(int itemid ,String itemname,Integer itemquanity,float itemprice,Integer buyerid) {
        this.itemid = itemid;
        this.itemname=itemname;
        this.itemquanity=itemquanity;
        this.itemprice =itemprice;
        this.buyerid=buyerid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getItemquanity() {
        return itemquanity;
    }

    public void setItemquanity(Integer itemquanity) {
        this.itemquanity = itemquanity;
    }

    public float getItemprice() {
        return itemprice;
    }

    public void setItemprice(float itemprice) {
        this.itemprice = itemprice;
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finalorder)) {
            return false;
        }
        Finalorder other = (Finalorder) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order.Finalorder[ orderid=" + orderid + " ]";
    }
    
}
