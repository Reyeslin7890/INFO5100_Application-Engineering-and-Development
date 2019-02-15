/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Gun;


public class GunInventoryitem {
     
      private Gun gun;
      private int guninventory;
      private int price=0;
      private int saleprice=0;
     
        public GunInventoryitem() {
           gun = new Gun();
        }

    public void setGuninventory(int guninventory) {
        this.guninventory = guninventory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(int saleprice) {
        this.saleprice = saleprice;
    }
    
    
    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public int getGuninventory() {
        return guninventory;
    }
    public void setnum(int num){
        guninventory =guninventory+num ;
   }
        @Override
        public String toString(){
            return this.gun.getName();
        }
}
