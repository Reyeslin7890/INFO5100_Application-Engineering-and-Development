package Business.Person;

import java.time.Year;

public class Person {

    private String name;
    private String address;
    private int age;
    private String cellphone;
    private int id;
    private static int count = 1;
    private boolean verificationstatus = false;
    private boolean certificatestatus = false;
    private boolean verificationlock = false;
    private boolean certificatelock = false;

    public Person() {
        id = count;
        count++;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isVerificationstatus() {
        return verificationstatus;
    }

    public void setVerificationstatus(boolean verificationstatus) {
        this.verificationstatus = verificationstatus;
    }

    public boolean isCertificatestatus() {
        return certificatestatus;
    }

    public void setCertificatestatus(boolean certificatestatus) {
        this.certificatestatus = certificatestatus;
    }

    public boolean isVerificationlock() {
        return verificationlock;
    }

    public void setVerificationlock(boolean verificationlock) {
        this.verificationlock = verificationlock;
    }

    public boolean isCertificatelock() {
        return certificatelock;
    }

    public void setCertificatelock(boolean certificatelock) {
        this.certificatelock = certificatelock;
    }

    @Override
    public String toString() {
        return name;
    }

}
