/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.ulbs.ip.an3.nextgenpos.rest;

import ro.ulbs.ip.an3.nextgenpos.db.User;
import ro.ulbs.ip.an3.nextgenpos.db.UserEjb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import ro.ulbs.ip.an3.nextgenpos.db.Product;


@Path("/users")
@Stateless

public class RestUsers {
    @Context
    private UriInfo context;
    private User user = null;
    
    @EJB
    private UserEjb userEjb;
    
    public RestUsers(){
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getList() {
        List<User> users = userEjb.getList();
        return Response.ok(users).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filter(@PathParam("id") Integer id, 
            @Context HttpServletRequest servletRequest) {
        
        user = userEjb.findById(id);
        
        return Response.ok(user).build();
    }
    
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(User user)
    {
        Integer id = userEjb.createUsers(user);
        return Response.ok(id).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user)
    {
        User result = userEjb.updateUsers(user);
        return Response.ok(result).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") Integer id) {
        userEjb.deleteUsers(id);
    }
}
