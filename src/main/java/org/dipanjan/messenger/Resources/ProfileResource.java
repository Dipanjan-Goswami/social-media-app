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

import org.dipanjan.messenger.Model.Profiles;
import org.dipanjan.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
    private ProfileService profileService = new ProfileService();
    // Profile Section  HTTP
    
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "application/json".
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profiles> getAllProfile() {
        return profileService.getAllProfiles(); 
    }
    
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
    public Profiles getProfile(@PathParam("username") String username) {
        Profiles profile = profileService.getProfile(username);
        return profile;
    }
    
    /** Method processing HTTP POST requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postProfile(Profiles profile)  {
         boolean status;
         status = profileService.addProfile(profile);
         if(status == true){
             return "Profile successfully posted";
         }else{
             return "Failed to post profile";
         }
    }
    
    /** Method processing HTTP PUT requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putProfile(Profiles profile) {
        boolean status;
        status = profileService.updateProfile(profile);
        if(status == true){
            return "Profile successfully updated";
        }else{
            return "Failed to update profile";
        }
    }
    
    /** 
     * @return String that will be send back as a response of type "text/plain".
     */
    @DELETE
    @Path("/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteProfile(@PathParam("username") String username) {
        boolean status;
        status = profileService.deleteProfile(username);
        if(status == true){
            return "Profile successfully Deleted";
        }else{
            return "Failed to delete profile";
        }
    }
    
}
