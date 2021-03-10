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
import org.dipanjan.messenger.service.CommentService;

@Path("/")
public class CommentResource {
    private CommentService commentService = new CommentService();
    // Comment section HTTP
    
    /** Method processing HTTP GET requests, producing "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "application/json".
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comments> getAllComments(@PathParam("msg_id") String msg_id) {
        return commentService.getAllComments(msg_id);
    }
    
    @GET
    @Path("/{comment_Id}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
    public Comments getComment(@PathParam("msg_id") String msg_id, @PathParam("comment_Id") String comment_Id) {
        Comments comment = commentService.getComment(msg_id, comment_Id);
        return comment;
    }
    
    /** Method processing HTTP POST requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postComment(Comments comment)  {
         boolean status;
         status = commentService.addComment(comment);
         if(status == true){
             return "Comment successfully posted";
         }else{
             return "Failed to post comment";
         }
    }
    
    /** Method processing HTTP PUT requests, consuming "application/json" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putComment(Comments comment) {
        boolean status;
        status = commentService.updateComment(comment);
        if(status == true){
            return "Comment successfully updated";
        }else{
            return "Failed to update comment";
        }
    }
    
    /** 
     * @return String that will be send back as a response of type "text/plain".
     */
    @DELETE
    @Path("/{comment_Id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteComment(@PathParam("msg_id") String msg_id, @PathParam("comment_Id") String comment_Id) {
        boolean status;
        status = commentService.deleteComment(msg_id, comment_Id);
        if(status == true){
            return "Comment successfully Deleted";
        }else{
            return "Failed to delete comment";
        }
    }
}
