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
@Table(name = "CATEGORY")
public class Category {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer id_category;
    
    @Column(name = "name")
    private String name;

    public Category() {
    }

    public Integer getId_category() {
        return id_category;
    }

    public String getName() {
        return name;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public void setName(String name) {
        this.name = name;
    }   
}
