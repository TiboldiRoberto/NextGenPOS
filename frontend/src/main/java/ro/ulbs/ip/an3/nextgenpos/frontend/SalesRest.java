/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class SalesRest {
    private static final String BASE_URI = "http://localhost:8080/restservices/sales";
    private final WebTarget webTarget;
    private final Client client;
    
    public SalesRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
    public List<SalesDto> listAll() throws javax.ws.rs.ClientErrorException {
        Response resp = webTarget.
        request(MediaType.APPLICATION_JSON).
        get(Response.class);
        
        //transformarea datelor in obiecte java
        List<SalesDto> ret = resp.readEntity (new GenericType<List<SalesDto>>(){});
        return ret;
    }

    public Integer create(SalesDto entry) throws ClientErrorException {
        Response resp = webTarget.request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(entry,MediaType.APPLICATION_JSON), Response.class);
            String s = resp.readEntity(String.class);
            try {
            Integer id = Integer.parseInt(s);
            return id;
            } catch (NumberFormatException nfe) {
            return 0;
            }
    }
    
}
