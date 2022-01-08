package ro.ulbs.ip.an3.nextgenpos.db;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ProductEjb {
    
    @PersistenceContext(unitName = "thepersistenceunit") 
    protected EntityManager em;
    
    private EntityManager getEntityManager() {
        return em;
    }
    
    public List<Product> getList() {
        EntityManager manager = getEntityManager();
        List<Product> prods = new ArrayList<>();
        try{
        prods = manager.createQuery("SELECT p FROM Product p").getResultList();
        }catch (Throwable t) {
            t.printStackTrace();
        }
      
        return prods;
    }
    
    public List<Product> filter(String filter){
        EntityManager manager = getEntityManager();
        List<Product> prods = manager
                .createQuery("SELECT p FROM Product p where p.name like :param or p.unit like :param")
                .setParameter("param", filter)
                .getResultList();
        return prods;
    }
    
    public Product findById(Integer id)
    {
        EntityManager manager = getEntityManager();
        Product prod = (Product) manager
                .createQuery("SELECT p FROM Product p WHERE p.id = :param")
                .setParameter("param", id)
                .getSingleResult();
        return prod;   
    }
    
    public Integer createProducts(Product prod) {
        EntityManager manager = getEntityManager();
        manager.persist(prod);
        manager.flush();
        return prod.getId();
    }
    
    public Product updateProducts(Product prod) {
        EntityManager manager = getEntityManager();
        manager.merge(prod);
        return prod;
    }
    
    public void deleteProduct(Integer id){
        EntityManager manager = getEntityManager();
        Product prod = findById(id);
        if(prod != null){
            manager.remove(prod);
        }else {
            throw new RuntimeException("Not found ID="+id);
        }
    }
}
