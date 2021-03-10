package org.dipanjan.messenger.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dipanjan.messenger.Model.Reacts;
import org.dipanjan.messenger.service.ReactService;

@Path("/")
public class ReactResource {
    private ReactService reactService = new ReactService();
    // Reacts section HTTP
    
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "application/json".
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reacts> getAllReacts(@PathParam("msg_id") String msg_id) {
        return reactService.getAllReacts(msg_id);
    }
    
    /** Method processing HTTP POST requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postReact(@PathParam("msg_id") String msg_id, Reacts react)  {
         boolean status;
         status = reactService.addReact(react);
         if(status == true){
             return "React successfully posted";
         }else{
             return "Failed to post react";
         }
    }
    
    /** Method processing HTTP PUT requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putReact(@PathParam("msg_id") String msg_id, Reacts react) {
        boolean status;
        status = reactService.updateReact(react);
        if(status == true){
            return "React successfully updated";
        }else{
            return "Failed to update react";
        }
    }
    
    /** 
     * @return String that will be send back as a response of type "text/plain".
     */
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteReact(@PathParam("msg_id") String msg_id, Reacts react) {
        boolean status;
        status =  reactService.deleteReact(react);
        if(status == true){
            return "React successfully Deleted";
        }else{
            return "Failed to delete react";
        }
    }
}
