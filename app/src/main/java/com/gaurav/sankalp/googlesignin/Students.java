package com.gaurav.sankalp.googlesignin;

/**
 * Created by gourav on 4/15/2018.
 */

public class Students  {

    String attendance;
    String name;
    String emailid;
    String total;
    String roll;
    String percent;



    public Students(){

    }

    public String getAttendance() {
        return attendance;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getName() {
        return name;
    }

    public String getPercent() {
        return percent;
    }

    public String getTotal() {
        return total;
    }

    public String getRoll() {
        return roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
