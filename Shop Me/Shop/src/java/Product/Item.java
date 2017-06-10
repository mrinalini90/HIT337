/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import customer.Customer;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Meeru
 */
@Entity
@Table(name = "ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByItemid", query = "SELECT i FROM Item i WHERE i.itemid = :itemid")
    , @NamedQuery(name = "Item.findByItemname", query = "SELECT i FROM Item i WHERE i.itemname = :itemname")
    , @NamedQuery(name = "Item.findByItemdescription", query = "SELECT i FROM Item i WHERE i.itemdescription = :itemdescription")
    , @NamedQuery(name = "Item.findByItemquanity", query = "SELECT i FROM Item i WHERE i.itemquanity = :itemquanity")
    , @NamedQuery(name = "Item.findByItemprice", query = "SELECT i FROM Item i WHERE i.itemprice = :itemprice")
    , @NamedQuery(name = "Item.findByItemstatus", query = "SELECT i FROM Item i WHERE i.itemstatus = :itemstatus")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITEMID")
    private Integer itemid;
    @Column(name = "ITEMNAME")
    private String itemname;
    @Column(name = "ITEMDESCRIPTION")
    private String itemdescription;
    @Column(name = "ITEMQUANITY")
    private Integer itemquanity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ITEMPRICE")
    private float itemprice;
    @Column(name = "ITEMSTATUS")
    private Boolean itemstatus;
    @JoinColumn(name = "SELLERID", referencedColumnName = "ID")
    @ManyToOne
    private int sellerid;

    public Item() {
    }
    
     public Item( String itemname, String itemdescription, Integer itemquanity, float itemprice, int sellerid) {
        this.itemname =itemname;
        this.itemdescription = itemdescription;
        this.itemquanity =itemquanity;
        this.itemprice=itemprice;
        this.sellerid =sellerid;
    }

    public Item(Integer itemid, String itemname, String itemdescription, Integer itemquanity, float itemprice, int sellerid) {
        this.itemid = itemid;
        this.itemname =itemname;
        this.itemdescription = itemdescription;
        this.itemquanity =itemquanity;
        this.itemprice=itemprice;
        this.sellerid =sellerid;
    }
    
    public Item(Integer itemid, String itemname, String itemdescription, Integer itemquanity, float itemprice,boolean itemstatus, int sellerid) {
        this.itemid = itemid;
        this.itemname =itemname;
        this.itemdescription = itemdescription;
        this.itemquanity =itemquanity;
        this.itemprice=itemprice;
        this.itemstatus =itemstatus;
        this.sellerid=sellerid;
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

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
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

    public Boolean getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(Boolean itemstatus) {
        this.itemstatus = itemstatus;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product.Item[ itemid=" + itemid + " ]";
    }
    
}
