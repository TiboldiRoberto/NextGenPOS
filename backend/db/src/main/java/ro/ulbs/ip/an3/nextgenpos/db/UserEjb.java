/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.ulbs.ip.an3.nextgenpos.db;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserEjb {
    
    @PersistenceContext(unitName = "thepersistenceunit") 
    protected EntityManager em;
    
    private EntityManager getEntityManager() {
        return em;
    }
    
    public List<User> getList() {
        EntityManager manager = getEntityManager();
        List<User> users = new ArrayList<>();
        try{
            users = manager.createQuery("SELECT u FROM User u").getResultList();
         }
        catch(Throwable t)
         {
         t.printStackTrace();
         }
        return users;
    }
}
