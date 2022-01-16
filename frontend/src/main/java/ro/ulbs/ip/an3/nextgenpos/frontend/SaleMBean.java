/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ulbs.ip.an3.nextgenpos.frontend;

import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
public class SaleMBean implements Serializable{
    private static final long serialVersionUID = 10112;
    @EJB
    private SalesRest restClient;

    public SaleMBean() {
    }
    
    
    public String startCreate() {
        isCreate = true;
        createdId = null;
        selectedProduct = new ProductsDto();
        return "product_create";
    }
}
