package org.dipanjan.messenger.Model;

import org.glassfish.internal.api.Public;

public class Reacts {
    private String msg_id;
    private String react_type;
    private String react_By;
    
    public Reacts(){}

    public Reacts(String msg_id, String react_type, String react_By) {
        this.msg_id = msg_id;
        this.react_type = react_type;
        this.react_By = react_By;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setReact_type(String react_type) {
        this.react_type = react_type;
    }

    public String getReact_type() {
        return react_type;
    }

    public void setReactBy(String react_By) {
        this.react_By = react_By;
    }

    public String getReactBy() {
        return react_By;
    }

}
