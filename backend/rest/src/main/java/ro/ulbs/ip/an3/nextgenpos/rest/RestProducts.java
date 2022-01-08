package ro.ulbs.ip.an3.nextgenpos.rest;

/**
 *
 * @author Roberto
 */
import ro.ulbs.ip.an3.nextgenpos.db.Product;
import ro.ulbs.ip.an3.nextgenpos.db.ProductEjb;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Response;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


@Path("/products")
@Stateless
public class RestProducts {
    @Context
    private UriInfo context;
    private Product prod = null;
    
    @EJB
    private ProductEjb productsEjb;

    public RestProducts() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getList() {
        List<Product> prods = productsEjb.getList();
        return Response.ok(prods).build();
    }
    
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filter(@DefaultValue("") @QueryParam("filter") String filterTxt,
            @Context HttpServletRequest servletRequest) {
    
        List<Product> prods = productsEjb.filter(filterTxt);
        return Response.ok(prods).build();
    }
        
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filter(@PathParam("id") Integer id, 
            @Context HttpServletRequest servletRequest) {
        
        prod = productsEjb.findById(id);
        
        return Response.ok(prod).build();
    
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Product prod)
    {
        Integer id = productsEjb.createProducts(prod);
        return Response.ok(id).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product prod)
    {
        Product result = productsEjb.updateProducts(prod);
        return Response.ok(result).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteProduct(@PathParam("id") Integer id) {
        productsEjb.deleteProduct(id);
    }
}
