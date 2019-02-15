/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Material;

import Business.Gun.Gun;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class MaterialDirectory {
     private ArrayList<Material>materialList ;

    public MaterialDirectory() {
        materialList=new ArrayList<>();
       
    }

    public ArrayList<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(ArrayList<Material> materialList) {
        this.materialList = materialList;
    }
    public Material createMaterial(String name){
        Material material=new Material();
        material.setName(name);
        materialList.add(material);
        return  material;
        
       
    }
     
        
 
       
     
}
