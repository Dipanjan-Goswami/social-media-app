package org.dipanjan.messenger.service;

import java.util.List;

import java.util.Map;

import org.dipanjan.dbms.Dbms_repo;
import org.dipanjan.messenger.Model.Profiles;


public class ProfileService {
    Dbms_repo db = new Dbms_repo();
    
    public ProfileService(){}
    
    public List<Profiles> getAllProfiles(){
        Map<String,Profiles> MapOfProfiles = db.getAllProfiles();
        List<Profiles> listOfProfiles = null;
        for(Map.Entry<String,Profiles> entry : MapOfProfiles.entrySet()){
            listOfProfiles.add(entry.getValue());
        }
        return listOfProfiles;
    }
    
    public Profiles getProfile(String username)    
    {
        Profiles profile = db.getAllProfiles().get(username);
        return profile;
    }
    
    public boolean addProfile(Profiles profile)
    {
       db.setProfile(profile);
       return true;
    }
    
    public boolean updateProfile(Profiles profile)
    {
        db.setProfile(profile);
        return true;
    }
    
    public boolean deleteProfile(String username)
    {
       db.removeProfile(username);
       return true;
    }
}
