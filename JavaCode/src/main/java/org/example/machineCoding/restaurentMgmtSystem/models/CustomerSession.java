package org.example.machineCoding.restaurentMgmtSystem.models;

public class CustomerSession extends BaseModel {
    private User user;
    private CustomerSessionStatus customerSessionStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CustomerSessionStatus getCustomerSessionStatus() {
        return customerSessionStatus;
    }

    public void setCustomerSessionStatus(CustomerSessionStatus customerSessionStatus) {
        this.customerSessionStatus = customerSessionStatus;
    }
    public boolean isActive() {
        return this.customerSessionStatus == CustomerSessionStatus.ACTIVE;
    }
}
