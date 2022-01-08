package ro.ulbs.ip.an3.nextgenpos.frontend;

/**
 *
 * @author Roberto
 */

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
public class ProductsRest {

    private static final String BASE_URI = "http://localhost:8080/restservices/products";
    private final WebTarget webTarget;
    private final Client client;
    
    public ProductsRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
    public List<ProductsDto> listAll() throws javax.ws.rs.ClientErrorException {
        Response resp = webTarget.
        request(MediaType.APPLICATION_JSON).
        get(Response.class);
        
        //transformarea datelor in obiecte java
        List<ProductsDto> ret = resp.readEntity (new GenericType<List<ProductsDto>>(){});
        return ret;
    }
    
    public List<ProductsDto> filterByName(String name) throws  ClientErrorException {
        Response resp =  webTarget.path("/search")
                .queryParam("filter", name)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
        return resp.readEntity(new GenericType<List<ProductsDto>>(){});
    }

    public Integer create(ProductsDto entry) throws ClientErrorException {
        Response resp = webTarget.request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(entry,MediaType.APPLICATION_JSON), Response.class);
            String s = resp.readEntity(String.class);
            try {
            Integer id = Integer.parseInt(s);
            return id;
            } catch (NumberFormatException nfe) {
            return 0;
            }
    }
    
    public void edit(ProductsDto entry) throws ClientErrorException {
        Response resp = webTarget
                .request(MediaType.APPLICATION_JSON)
                .post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
    }
    
    public void delete(ProductsDto entry) throws javax.ws.rs.ClientErrorException{
        webTarget.path("/"+entry.getId())
        .request(MediaType.APPLICATION_JSON)
        .delete(Response.class);
    }
}
