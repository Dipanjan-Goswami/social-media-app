package org.dipanjan.messenger.Model;

import java.util.Date;

public class Shares {
    private String msg_id;
    private String sharedBy;
    private Date SharedDate;

    public Shares(){}

    public Shares(String msg_id, String sharedBy) {
        this.msg_id = msg_id;
        this.sharedBy = sharedBy;
        this.SharedDate = new Date();
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
    }

    public String getSharedBy() {
        return sharedBy;
    }

}
