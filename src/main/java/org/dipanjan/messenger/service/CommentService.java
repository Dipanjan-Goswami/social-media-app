package org.dipanjan.messenger.service;

import java.util.List;

import org.dipanjan.dbms.Dbms_repo;
import org.dipanjan.messenger.Model.Comments;
import org.dipanjan.util.SequenceUtility;

public class CommentService {
    Dbms_repo db = new Dbms_repo();
    SequenceUtility seqUtil = new SequenceUtility("CMT");
    
    public CommentService(){}
    
    public List<Comments> getAllComments(String msg_id)    
    {
        List<Comments> listofMsgComments = db.getAllComments().get(msg_id);
        return listofMsgComments;
    }
    
    public Comments getComment(String msg_id, String comment_Id){
        Comments cmt =  null;
        List<Comments> listofMsgComments = db.getAllComments().get(msg_id);
        for (Comments msgCmnts : listofMsgComments)
        {
            if( msgCmnts.getComment_Id().equals(comment_Id) )
            {
                cmt = msgCmnts;
                break;
            }
        }
        return cmt;
    }
    
    public boolean addComment(Comments comment)
    {
       comment.setComment_Id(seqUtil.getValue());
       db.setComments(comment);
       return true;
    }
    
    public boolean updateComment(Comments comment)
    {
        db.setComments(comment);
        return true;
    }
    
    public boolean deleteComment(String msg_id, String comment_Id)
    {
       List<Comments> listofMsgComments = db.getAllComments().get(msg_id);
        for (Comments msgCmnts : listofMsgComments)
        {
            if( msgCmnts.getComment_Id().equals(comment_Id) )
            {
                listofMsgComments.remove(msgCmnts);
                break;
            }
        }
        return true;
    }
}
