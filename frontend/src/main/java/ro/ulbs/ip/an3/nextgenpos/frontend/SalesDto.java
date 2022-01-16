/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ulbs.ip.an3.nextgenpos.frontend;

/**
 *
 * @author user
 */
public class SalesDto  {
    private static final long serialVersionUID = 1111L;
    private Integer idSale;
    private Integer payment ;
    private String date;
    
    public SalesDto() {
    }

    public Integer getIdSale() {
        return idSale;
    }

    public Integer getPayment() {
        return payment;
    }

    public String getDate() {
        return date;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
