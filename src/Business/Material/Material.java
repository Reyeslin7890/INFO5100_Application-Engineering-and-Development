/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Material;

/**
 *
 * @author james
 */
public class Material {
     private String Name;
    private static int counter=1;
    private int MaterialID;

    public Material() {
       MaterialID=counter;
        counter++;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getMaterialID() {
        return MaterialID;
    }

    public void setMaterialID(int MaterialID) {
        this.MaterialID = MaterialID;
    }

   
      @Override
    public String toString() {
        return Name;
    }
    
}
