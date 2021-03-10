package org.dipanjan.messenger.Model;

import java.util.Date;

import org.dipanjan.util.SequenceUtility;

public class Comments {
    private String comment_Id;
    private String msg_id;
    private String comment;
    private String author;
    private Date created;
    
    public Comments(){}

    public Comments(String comment_Id, String msg_id, String comment, String author) {
        this.comment_Id = comment_Id;
        this.msg_id = msg_id;
        this.comment = comment;
        this.author = author;
        this.created = new Date();
    }


    public void setComment_Id(String comment_Id) {
        this.comment_Id = comment_Id;
    }

    public String getComment_Id() {
        return comment_Id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

}
