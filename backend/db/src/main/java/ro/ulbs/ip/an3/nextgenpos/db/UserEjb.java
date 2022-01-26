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
    
    //In all te sql querrys need to insert the class name and NOT the table name
    
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
    
    public User findById(Integer id)
    {
        EntityManager manager = getEntityManager();
        User user = (User) manager
                .createQuery("SELECT u FROM User u WHERE u.id = :param")
                .setParameter("param", id)
                .getSingleResult();
        return user;
    }
    
    public Integer createUsers(User user) {
        EntityManager manager = getEntityManager();
        manager.persist(user);
        manager.flush();
        return user.getId();
    }
        
    public void createUsers(String username, String email, String passwordSha256, String position) {
        EntityManager manager = getEntityManager();
        User user = new User();
        
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordSha256);
        user.setPosition(position);
        
        manager.persist(user);
    }
    
    public User updateUsers(User user)
    {
        EntityManager manager = getEntityManager();
        manager.merge(user);
        return user;
    }
    
    public void deleteUsers(Integer id){
        EntityManager manager = getEntityManager();
        User user =  findById(id);
        if(user != null){
            manager.remove(user);
        }
        else {
            throw new RuntimeException("Not found ID="+id);
        }
    }
}
