package com.springclass.firstproject.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

public class CustomerDTO {

    private int customerId;

    private String customerName;

    private String customerAddress;

    private ArrayList contactNumbers;

    private String nic;

    private boolean activeStates;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, ArrayList contactNumbers, String nic, boolean activeStates) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeStates = activeStates;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveStates() {
        return activeStates;
    }

    public void setActiveStates(boolean activeStates) {
        this.activeStates = activeStates;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumbers=" + contactNumbers +
                ", nic='" + nic + '\'' +
                ", activeStates=" + activeStates +
                '}';
    }
}
