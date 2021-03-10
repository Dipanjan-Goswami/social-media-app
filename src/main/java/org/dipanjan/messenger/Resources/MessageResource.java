
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

import org.dipanjan.messenger.Model.Comments;
import org.dipanjan.messenger.Model.Message;
import org.dipanjan.messenger.Model.Profiles;
import org.dipanjan.messenger.Model.Reacts;
import org.dipanjan.messenger.Model.Shares;
import org.dipanjan.messenger.service.CommentService;
import org.dipanjan.messenger.service.MessageService;
import org.dipanjan.messenger.service.ProfileService;
import org.dipanjan.messenger.service.ReactService;
import org.dipanjan.messenger.service.ShareService;


/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/messages")
public class MessageResource {
    private MessageService messageService =  new MessageService();
    
    // Message Section HTTP 
    
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "application/json".
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMesssge(String username) {
        return messageService.getAllMessage(username);
    }
    
    @GET
    @Path("/{msg_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
    public Message getMessage(String username, @PathParam("msg_id") String msg_id) {
        Message msg = messageService.getMessage(username, msg_id);
        return msg;
    }
    
    /** Method processing HTTP POST requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @POST
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public String postMessage(Message message)  {
         boolean status;
         status = messageService.addMessage(message);
         if(status == true){
             return "Message successfully posted";
         }else{
             return "Failed to post message";
         }
    }
    
    /** Method processing HTTP PUT requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putMessage(Message message) {
        boolean status;
        status = messageService.updateMessage(message);
        if(status == true){
            return "Message successfully updated";
        }else{
            return "Failed to update message";
        }
    }
    
    /** Method processing HTTP DELETE requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @DELETE
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteMessage(Message message) {
        boolean status;
        status = messageService.deleteMessage(message);
        if(status == true){
            return "Message successfully Deleted";
        }else{
            return "Failed to delete message";
        }
    }
    
    @Path("/{msg_id}/Comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
    
    @Path("/{msg_id}/Shares")
    public ShareResource getShareResource(){
        return new ShareResource();
    }
    
    @Path("/{msg_id}/Reacts")
    public ReactResource getReactResource(){
        return new ReactResource();
    }
}
