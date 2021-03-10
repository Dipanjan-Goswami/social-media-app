package org.dipanjan.messenger.service;

import java.util.List;

import org.dipanjan.dbms.Dbms_repo;
import org.dipanjan.messenger.Model.Comments;
import org.dipanjan.messenger.Model.Shares;

public class ShareService {
    Dbms_repo db = new Dbms_repo();
    
    public ShareService(){}
    
    public List<Shares> getAllShares(String msg_id)    
    {
        List<Shares> listofMsgShares = db.getAllShares().get(msg_id);
        return listofMsgShares;
    }
    
    public boolean addShare(Shares share)
    {
       db.setShares(share);
       return true;
    }
    
    public boolean updateShare(Shares share)
    {
        db.setShares(share);
        return true;
    }
    
    public boolean deleteShare(Shares share)
    {
       db.removeShare(share.getMsg_id(), share);
       return true;
    }
}
