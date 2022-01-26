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

@Table(name = "CATEGORY_HAS_PRODUCT")

public class CategoryHasProduct {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "id_category", referencedColumnName = "category.id_category")
    private Category idCategory;

    @JoinColumn(name = "id_product", referencedColumnName = "product.id_product")
    private Product idProduct;

    public CategoryHasProduct() {
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }
}
