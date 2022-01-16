/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ulbs.ip.an3.nextgenpos.db;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class CategoryEjb {
    @PersistenceContext(unitName = "thepersistenceunit") 
    protected EntityManager em;
    
    private EntityManager getEntityManager() {
        return em;
    }
    
    public List<Category> getList() {
        EntityManager manager = getEntityManager();
        List<Category> categories = new ArrayList<>();
        try{
        categories = manager.createQuery("SELECT p FROM Category p").getResultList();
        }catch (Throwable t) {
            t.printStackTrace();
        }
      
        return categories;
    }
}
