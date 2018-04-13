package hacker.l.venderapp.models;

/**
 * Created by lalitsingh on 29/03/18.
 */

public class Result {
    public Result() {
    }

    private int loginId;

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Username;
    private String UserPhone;
    private String EmailId;
    private String Password;
    //opne booking ...
    private String tripType;
    private String distance;
    private String date;
    private String tripName;
    private String cabtype;
    private String cabName;
    private String name;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private String cityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    //for avalibility..
    private String carModel;
    private String carName;
    private String dlNumber;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getDlExpirDate() {
        return dlExpirDate;
    }

    public void setDlExpirDate(String dlExpirDate) {
        this.dlExpirDate = dlExpirDate;
    }

    private String dlExpirDate;

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    private String rs;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    private String carNumber;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getCabtype() {
        return cabtype;
    }

    public void setCabtype(String cabtype) {
        this.cabtype = cabtype;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;
}
