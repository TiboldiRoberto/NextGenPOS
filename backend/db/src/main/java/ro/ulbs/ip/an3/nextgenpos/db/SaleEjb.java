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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SaleEjb {
    @PersistenceContext(unitName = "thepersistenceunit") 
    protected EntityManager em;
    
    private EntityManager getEntityManager() {
        return em;
    }
    
    public List<Sale> getList() {
        EntityManager manager = getEntityManager();
        List<Sale> sales = new ArrayList<>();
        try{
        sales = manager.createQuery("SELECT p FROM Sale p").getResultList();
        }catch (Throwable t) {
            t.printStackTrace();
        }
        return sales;
    }
    
    public Integer createSale(Sale sale) {
        EntityManager manager = getEntityManager();
        manager.persist(sale);
        manager.flush();
        return sale.getId_sale();
    }
}
