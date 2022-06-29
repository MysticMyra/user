package com.ega.user.model;



public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String loginName;
    private String password;
    private String email;
    private String contactNumber;
    private String address;
    private String state;
    private String country;
    private String pincode;

    public UserDTO() {
    }

    public UserDTO(Long userId, String firstName, String lastName, String loginName, String password, String email, String contactNumber, String address, String state, String country, String pincode) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginName = loginName;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }



    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
