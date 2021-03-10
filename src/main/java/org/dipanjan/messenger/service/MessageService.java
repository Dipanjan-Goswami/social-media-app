package org.dipanjan.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dipanjan.dbms.Dbms_repo;
import org.dipanjan.messenger.Model.Message;
import org.dipanjan.util.SequenceUtility;

public class MessageService {
    Dbms_repo db = new Dbms_repo();
    SequenceUtility seqUtil = new SequenceUtility("PS");
    
    public MessageService(){}
    
    public List<Message> getAllMessage(String username)    
    {
        Map<String,Message> usermessage = db.getAllMessages().get(username);
        List<Message> listofUserMessages = null;
        for (Map.Entry<String,Message> entry : usermessage.entrySet())
        {
            listofUserMessages.add(entry.getValue());
        }
        return listofUserMessages;
    }
    
    public Message getMessage(String username, String msg_id){
        Message msg =  null;
        Map<String,Message> usermessage = db.getAllMessages().get(username);
        List<Message> listofUserMessages = null;
        for (Map.Entry<String,Message> entry : usermessage.entrySet())
        {
            if( entry.getKey().equals(msg_id) )
            {
                msg = entry.getValue();
                break;
            }
        }
        return msg;
    }
    
    public boolean addMessage(Message message)
    {
       message.setMsg_id(seqUtil.getValue());
       db.setMessage(message);
       return true;
    }
    
    public boolean updateMessage(Message message)
    {
        db.setMessage(message);
        return true;
    }
    
    public boolean deleteMessage(Message message)
    {
       db.removeMessage(message.getAuthor(), message.getMsg_id());
        return true;
    }
}
