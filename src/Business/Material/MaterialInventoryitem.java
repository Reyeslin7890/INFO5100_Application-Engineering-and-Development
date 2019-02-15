/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Material;

/**
 *
 * @author yuzix
 */
public class MaterialInventoryitem {
    private Material material;
    private  int qunatity=0;
    private  int price=0;

    public MaterialInventoryitem() {
        material=new Material();
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }
    public void setnum(int num){
        qunatity =qunatity+num ;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
   
    
    @Override
    public String toString(){
        return this.material.getName();
    }
}
