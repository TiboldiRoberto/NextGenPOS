/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ulbs.ip.an3.nextgenpos.db;

/**
 *
 * @author user
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALE")
public class Sale {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Integer id_sale;
    
    @Column(name = "payment")
    private Integer payment;
    
    @Column(name = "date")
    private String date;

    public Sale() {
    }

    public Integer getId_sale() {
        return id_sale;
    }

    public Integer getPayment() {
        return payment;
    }

    public String getDate() {
        return date;
    }

    public void setId_sale(Integer id_sale) {
        this.id_sale = id_sale;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
