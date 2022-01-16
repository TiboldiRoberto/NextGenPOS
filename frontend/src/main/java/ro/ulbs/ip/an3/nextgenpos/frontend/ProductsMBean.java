package ro.ulbs.ip.an3.nextgenpos.frontend;

/**
 *
 * @author Roberto
 */

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@SessionScoped
@Named("prodMBean")
public class ProductsMBean implements Serializable {
    private static final long serialVersionUID = 10112;
    @EJB
    private ProductsRest restClient;
    
    private String filterText;
    private ProductsDto selectedProduct;
    private boolean isCreate;
    private boolean isDelete;
    private Integer createdId;
    
    public ProductsMBean(){
    }
    
    public List<ProductsDto> getProducts(){
       if (filterText != null && filterText.length() > 0) {
            return restClient.filterByName(filterText);
        } else {
            return restClient.listAll();
        } 
 
    }
    
    public String getFilterText() {
    return filterText;
    }
    public void setFilterText(String filterText) {
    this.filterText = filterText;
    }
    public void filter() {
    }

    public void setSelected(ProductsDto prod){
        this.selectedProduct = prod;
    }

    public ProductsDto getSelected() {
        return selectedProduct;
    }
    
    public String startCreate() {
        isCreate = true;
        createdId = null;
        selectedProduct = new ProductsDto();
        return "product_create";
    }
    
    public String endCreate() {
        createdId = restClient.create(selectedProduct);
        isCreate = false;
        return "admin_page";
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public Integer getCreatedId() {
        return createdId;
    }

    public void setIsCreate(boolean isCreate) {
        this.isCreate = isCreate;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public void setCreatedId(Integer createdId) {
        this.createdId = createdId;
    }
    
    public String startEdit() {
        return "product_edit";
    }
    
    public String endEdit() {
        restClient.edit(selectedProduct);
        return "admin_page";
    }
    
    public String startDelete() {
        isDelete = true;
        return "product_delete";
    }
    
    public String endDelete() {
        isDelete = false;
        try {
        restClient.delete(selectedProduct);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("prodFilterForm", new FacesMessage("Error",e.getMessage()));
        }
        return "admin_page";
    }
    
    
    
    
}
