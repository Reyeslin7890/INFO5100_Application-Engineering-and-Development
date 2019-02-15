/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Gun;


import java.util.ArrayList;

public class GunDirectory {
    private ArrayList<Gun>GunList ;

    public GunDirectory() {
        GunList=new ArrayList<>();
    }

    public ArrayList<Gun> getGunList() {
        return GunList;
    }

    public void setGunList(ArrayList<Gun> GunList) {
        this.GunList = GunList;
    }

    
     public Gun CreateGun(String name){
//        for(Gun gun:GunList){
//            if(gun.getName().equals(name))
//                return null;
//        }
        Gun gun = new Gun();
        gun.setName(name);
        GunList.add(gun);
        return gun;
    }
    public void removegun(Gun gun){
        GunList.remove(gun);
    }
    
}
