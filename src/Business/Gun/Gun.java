/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Gun;

public class Gun {

    private String Name;
    private static int counter = 1;
    private int GunID;

    public Gun() {
        GunID = counter;
        counter++;

    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getGunID() {
        return GunID;
    }

    public void setGunID(int GunID) {
        this.GunID = GunID;
    }

    @Override
    public String toString() {
        return Name;
    }

}
