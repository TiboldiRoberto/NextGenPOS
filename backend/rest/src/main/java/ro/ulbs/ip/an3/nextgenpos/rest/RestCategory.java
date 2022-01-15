/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ulbs.ip.an3.nextgenpos.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import ro.ulbs.ip.an3.nextgenpos.db.Category;
import ro.ulbs.ip.an3.nextgenpos.db.CategoryEjb;


/**
 *
 * @author user
 */
@Path("/categories")
@Stateless
public class RestCategory {
    @Context
    private UriInfo context;
    private Category category = null;
    
    @EJB
    private CategoryEjb categoryEjb;

    public RestCategory() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getList() {
        List<Category> categories = categoryEjb.getList();
        return Response.ok(categories).build();
    }
}
