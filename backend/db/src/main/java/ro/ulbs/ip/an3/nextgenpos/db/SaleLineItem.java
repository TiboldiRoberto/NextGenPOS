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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name = "SALE_LINE_ITEM")

public class SaleLineItem {
    private static final long serialVersionUID = 1L;
    
    @JoinColumn(name = "id_product", referencedColumnName = "product.id_product")    
    private Product idProduct;
    
    @JoinColumn(name = "id_sale", referencedColumnName = "sale.id_sale")   
    private Sale idSale;

    public SaleLineItem() {
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public Sale getIdSale() {
        return idSale;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdSale(Sale idSale) {
        this.idSale = idSale;
    } 
}
