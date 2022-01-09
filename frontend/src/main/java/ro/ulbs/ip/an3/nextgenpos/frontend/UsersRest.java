/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.ulbs.ip.an3.nextgenpos.frontend;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean

public class UsersRest {
    private static final String BASE_URI = "http://localhost:8080/restservices/users";
    private final WebTarget webTarget;
    private final Client client;
    
    public UsersRest() {
    client = javax.ws.rs.client.ClientBuilder.newClient();
    webTarget = client.target(BASE_URI);
    }
    
    public List<UsersDto> listAll() throws javax.ws.rs.ClientErrorException {
        Response resp = webTarget.
        request(MediaType.APPLICATION_JSON).
        get(Response.class);
        
        List<UsersDto> ret = resp.readEntity (new GenericType<List<UsersDto>>(){});
        return ret;
    }
   
    public Integer create(UsersDto entry) throws ClientErrorException {
        Response resp = webTarget.request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(entry,MediaType.APPLICATION_JSON), Response.class);
            String s = resp.readEntity(String.class);
            try {
            Integer id = Integer.parseInt(s);
            return id;
            } catch (NumberFormatException nfe) {
            return 0;
            }
    }
    
    public void edit(UsersDto entry) throws ClientErrorException {
        Response resp = webTarget
                .request(MediaType.APPLICATION_JSON)
                .post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
    }
    
    public void delete(UsersDto entry) throws javax.ws.rs.ClientErrorException{
        webTarget.path("/"+entry.getId())
        .request(MediaType.APPLICATION_JSON)
        .delete(Response.class);
    }
}
