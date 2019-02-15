/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Gun;

/**
 *
 * @author yuzix
 */
public class BulletInventoryitem {
     private Bullet bullet;
     private int bulletinventory;
     private int price=0;
     private int saleprice=0;

    public BulletInventoryitem() {
        bullet =new Bullet();
    }

    public Bullet getBullet() {
        return bullet;
    }

    public int getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(int saleprice) {
        this.saleprice = saleprice;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getBulletinventory() {
        return bulletinventory;
    }

    public void setBulletinventory(int bulletinventory) {
        this.bulletinventory = bulletinventory;
    }
     public void setnum(int num){
        bulletinventory =bulletinventory+num ;
     }
    @Override
        public String toString(){
            return this.bullet.getName();
        }
     
    
}
