package org.example.machineCoding.restaurentMgmtSystem.models;



import java.util.Date;

public class WaitListPosition  extends BaseModel{
    private User user;
    private Date insertedAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(Date insertedAt) {
        this.insertedAt = insertedAt;
    }
}
