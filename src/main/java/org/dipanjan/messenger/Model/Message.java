package org.dipanjan.messenger.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dipanjan.util.SequenceUtility;

public class Message {
    private String msg_id;
    private String message;
    private Date created;
    private String author;
    
    public Message() {}
    
    public Message (String msg_id, String message, String author)
    {
        this.msg_id = msg_id;
        this.message = message;
        this.author = author;
        this.created = new Date();
    }


    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

}
