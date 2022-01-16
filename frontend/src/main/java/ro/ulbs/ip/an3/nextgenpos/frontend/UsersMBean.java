/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.ulbs.ip.an3.nextgenpos.frontend;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("userMBean")
public class UsersMBean implements Serializable {
    private static final long serialVersionUID = 10112;
    @EJB
    private UsersRest restClient;
    
    private UsersDto selectedUser;
    private boolean isCreate;
    private boolean isDelete;
    private Integer createdId;
    
    public UsersMBean(){
    }
    
    public List<UsersDto> getUsers() {
        return restClient.listAll();
    }

    public UsersDto getSelected() {
        return selectedUser;
    }

    public void setSelected(UsersDto selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public String startCreate() {
        isCreate = true;
        createdId = null;
        selectedUser = new UsersDto();
        return "user_create";
    }
    
    public String endCreate() {
        createdId = restClient.create(selectedUser);
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
    
    public String startEdit(){
        return "user_edit";
    }
    
    public String endEdit(){
        restClient.edit(selectedUser);
        return "admin_page";
    }
    
    public String startDelete(){
        isDelete = true;
        return "user_delete";
    }
    
    public String endDelete(){
        isDelete = false;
        try{
            restClient.delete(selectedUser);
        }catch(Exception e){
    // Maybe some problems here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!        
            FacesContext.getCurrentInstance().addMessage("userFilterForm", new FacesMessage("Error",e.getMessage()));
        }
        return "admin_page"; // Modify to the admin page  
    }
    
    
    
}   
