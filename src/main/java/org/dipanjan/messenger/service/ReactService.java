package org.dipanjan.messenger.service;

import java.util.List;

import org.dipanjan.dbms.Dbms_repo;
import org.dipanjan.messenger.Model.Reacts;

public class ReactService {
    Dbms_repo db = new Dbms_repo();
    
    public ReactService(){}
    
    public List<Reacts> getAllReacts(String msg_id)    
    {
        List<Reacts> listofMsgReacts = db.getAllReacts().get(msg_id);
        return listofMsgReacts;
    }
    
    public boolean addReact(Reacts react)
    {
       db.setReacts(react);
       return true;
    }
    
    public boolean updateReact(Reacts react)
    {
        db.setReacts(react);
        return true;
    }
    
    public boolean deleteReact(Reacts react)
    {
       db.removeReacts(react.getMsg_id(), react);
       return true;
    }
}
