/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ulbs.ip.an3.nextgenpos.frontend;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */
@SessionScoped
@Named("saleMBean")
public class SaleMBean implements Serializable{
    private static final long serialVersionUID = 10112;
    @EJB
    private SalesRest restClient;
    private SalesDto selectedProduct;
    private Integer createdId;

    public SaleMBean() {
    }
    
    
    public String startCreate() {
        createdId = null;
        selectedProduct = new SalesDto();
        createdId = restClient.create(selectedProduct);
        return "cashier_page";
    }
}
