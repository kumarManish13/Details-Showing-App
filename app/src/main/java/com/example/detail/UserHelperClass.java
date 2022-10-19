package com.example.detail;



public class UserHelperClass {

    String Name,Email,PhoneNo,Address,EmployeeID,sex,Salary,date;


    public UserHelperClass() {

    }

    public UserHelperClass(String name, String email, String phoneNo, String address, String employeeID, String sex, String salary, String date) {

        Name = name;
        Email = email;
        PhoneNo = phoneNo;
        Address = address;
        EmployeeID = employeeID;
        this.sex = sex;
        Salary = salary;
        this.date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

