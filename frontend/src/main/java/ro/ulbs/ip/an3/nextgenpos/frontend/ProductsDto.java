/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.ulbs.ip.an3.nextgenpos.frontend;

/**
 *
 * @author Roberto
 */
public class ProductsDto {
    private static final long serialVersionUID = 1111L;
    private Integer id;
    private String name;
    private String unit;
    private Integer unitPrice;
    private Integer quantity;

    public ProductsDto() {
    }

    public Integer getId() {
        return id;
    }
    
    public void setName(String name) {
    this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    
}
