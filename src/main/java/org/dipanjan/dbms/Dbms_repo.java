package org.dipanjan.dbms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dipanjan.messenger.Model.Comments;
import org.dipanjan.messenger.Model.Message;
import org.dipanjan.messenger.Model.Profiles;
import org.dipanjan.messenger.Model.Reacts;
import org.dipanjan.messenger.Model.Shares;


public class Dbms_repo {
    private Map<String, Profiles> allProfiles = new HashMap<String, Profiles>();
    private Map<String, Map<String,Message>> allMessages = new HashMap<String, Map<String,Message>>();
    private Map<String, List<Comments>> allComments = new HashMap<String, List<Comments>>();
    private Map<String, List<Reacts>> allReacts = new HashMap<String, List<Reacts>>();
    private Map<String, List<Shares>> allShares = new HashMap<String, List<Shares>>();
    
    // Create or Update
    public void setProfile(Profiles profile) {
        allProfiles.put(profile.getUsername(), profile);
    }
    
    // Read
    public Map<String, Profiles> getAllProfiles() {
        return allProfiles;
    }
    
    // Delete
    public Boolean removeProfile(String username)
    {
        String msg_id = null;
        try{
            allProfiles.remove(username);
            Map<String,Message> listOfUserMessages =  allMessages.get(username);
            for(Map.Entry<String,Message> entry : listOfUserMessages.entrySet())
            {
                msg_id = entry.getKey();
                allComments.remove(msg_id);
                allReacts.remove(msg_id);
                allShares.remove(msg_id);
            }
            allMessages.remove(username);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    // Create or Update
    public void setMessage(Message message) {
        Map<String,Message> Messages = allMessages.get(message.getAuthor());
        Messages.put(message.getMsg_id(), message);
        allMessages.put(message.getAuthor(), Messages);
    }

    // Read
    public Map<String, Map<String,Message>> getAllMessages() {
        return allMessages;
    }
    
    // Delete
    public boolean removeMessage(String username, String msg_id)
    {
        try{
            Map<String,Message> listOfUserMessages =  allMessages.get(username);
            for(Map.Entry<String,Message> entry : listOfUserMessages.entrySet())
            {
                if (msg_id.equals(entry.getKey()))
                {
                    allComments.remove(msg_id);
                    allReacts.remove(msg_id);
                    allShares.remove(msg_id);
                }
            }
            listOfUserMessages.remove(msg_id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    // Add or update
    public void setComments(Comments Comment) {
        List<Comments> listOfComments = this.getAllComments().get(Comment.getMsg_id());
        listOfComments.add(Comment);
        this.allComments.put(Comment.getMsg_id(), listOfComments);
    }
    
    // Read
    public Map<String, List<Comments>> getAllComments() {
        return allComments;
    }
    
    // Delete
    public boolean removeComment(String msg_id, Comments comment)
    {
        try{
            allComments.get(msg_id).remove(comment);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }

    // Add or Update
    public void setReacts(Reacts react) {
        List<Reacts> listOfReacts = this.getAllReacts().get(react.getMsg_id());
        listOfReacts.add(react);
        this.allReacts.put(react.getMsg_id(), listOfReacts);
    }

    // Read
    public Map<String, List<Reacts>> getAllReacts() {
        return allReacts;
    }

    // Delete
    public boolean removeReacts(String msg_id, Reacts react)
    {
        try{
            allReacts.get(msg_id).remove(react);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }
    
    // Add or Update
    public void setShares(Shares Share) {
        List<Shares> listOfShares = this.getAllShares().get(Share.getMsg_id());
        listOfShares.add(Share);
        this.allShares.put(Share.getMsg_id(), listOfShares);
    }

    // Read
    public Map<String,List<Shares>> getAllShares() {
        return allShares;
    }
    
    // Delete
    public boolean removeShare(String msg_id, Shares share)
    {
        try{
            allShares.get(msg_id).remove(share);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }
}
