/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Gun;

import java.util.ArrayList;


public class BulletDirectory {
    private ArrayList<Bullet>BulletList ;

    public BulletDirectory() {
        BulletList=new ArrayList<>();
    }

    public ArrayList<Bullet> getBulletList() {
        return BulletList;
    }

    public void setBulletList(ArrayList<Bullet> BulletList) {
        this.BulletList = BulletList;
    }

    
     public Bullet createbullet(String name) {
    
        Bullet bullet = new Bullet();
        bullet.setName(name);
        BulletList.add(bullet);
        return bullet;
    }
    
    
}
