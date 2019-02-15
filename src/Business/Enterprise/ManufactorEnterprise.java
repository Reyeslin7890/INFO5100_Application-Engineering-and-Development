/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Gun.BulletInventoryitem;
import Business.Gun.Gun;
import Business.Gun.GunInventoryitem;
import Business.Material.Material;
import Business.Material.MaterialInventoryitem;
import Business.Role.ManufacturerAdminRole;
import Business.Role.Role;
import Business.Material.MaterialInventoryitem;
import java.util.ArrayList;


public class ManufactorEnterprise extends Enterprise{
    
private ArrayList<MaterialInventoryitem>materialInventory;
private boolean s=true;

    public ManufactorEnterprise(String name) {
        super(name, EnterpriseType.ManufactorEnterprise);
       materialInventory=new ArrayList<MaterialInventoryitem>();
        
    }

    public ArrayList<MaterialInventoryitem> getMaterialInventory() {
        if(materialInventory==null)
            materialInventory=new ArrayList<MaterialInventoryitem>();
        return materialInventory;
    }

   
    
    public void setMaterialInventory(ArrayList<MaterialInventoryitem> materialInventory) {
        this.materialInventory = materialInventory;
    }
    
    
    public MaterialInventoryitem findInventory(Material material){
        for(MaterialInventoryitem materialInventoryitem:materialInventory)
        {
            if(materialInventoryitem.getMaterial().getName().equals(material.getName()))
                return materialInventoryitem;
        }
        return null;
    }
    
    public  void creatematerialinventory(Material material,int num,int p)
    {
        MaterialInventoryitem materialInventoryitem=new MaterialInventoryitem();
        materialInventoryitem.setnum(num);
        materialInventoryitem.setMaterial(material);
        materialInventoryitem.setPrice(p);
        materialInventory.add(materialInventoryitem);
    }
     public int creategun(int quantity,int a, int b, int c, int d){
        int p=0;
        
         for(MaterialInventoryitem materialInventoryitem:materialInventory)
        {
           String name =materialInventoryitem.getMaterial().getName();
           int q=0; 
           int i=0;
           
           switch(name)
               {
                   case "steel":
                       q=materialInventoryitem.getQunatity();
                       p=p+materialInventoryitem.getPrice()*a;
                       i=q-a*(quantity);
                       if(i<0)
                       {
                           s=false;
                       }
                       else
                       {materialInventoryitem.setQunatity(q-a*quantity);}
                       break;
                   case "iron":
                        q=materialInventoryitem.getQunatity();
                        p=p+materialInventoryitem.getPrice()*b;
                       i=q-b*quantity;
                       if(i<0)
                       {
                      
                        s=false;
                        }
                       else
                       {materialInventoryitem.setQunatity(q-b*quantity);
                       }
                       break;
                       
                   case "wood":
                       q=materialInventoryitem.getQunatity();
                       p=p+materialInventoryitem.getPrice()*c;
                       i=q-c*quantity;
                       if(i<0)
                       {
                       
                        s=false;}
                       else{materialInventoryitem.setQunatity(q-c*quantity);}
                       break;
                   case "plastic":
                        q=materialInventoryitem.getQunatity();
                        p=p+materialInventoryitem.getPrice()*d;
                       i=q-d*quantity;
                       if(i<0)
                        {s=false;}
                       else
                        {materialInventoryitem.setQunatity(q-d*quantity);}
                      
                        break;
           }
                      
               }
         if(s==true)
             return p;
         else
             return -p;
    }

      public int createbullet(int quantity){
          boolean a=true;
          int p=0;
        for(MaterialInventoryitem materialInventoryitem:materialInventory)
        {
           String name =materialInventoryitem.getMaterial().getName();
           int q=0;   
           int i=0;
           
           switch(name)
               {
                   case "steel":
                       q=materialInventoryitem.getQunatity();
                       p=p+materialInventoryitem.getPrice();
                       i=q-1*quantity;
                       if(i>=0)
                       materialInventoryitem.setQunatity(q-1*quantity);
                       else
                           a=false;
                           
                       break;
                   case "iron":
                        q=materialInventoryitem.getQunatity();
                         p=p+2*materialInventoryitem.getPrice();
                        i=q-2*quantity;
                        if(i>=0)
                       materialInventoryitem.setQunatity(q-2*quantity);
                        else
                            a=false;
                       break;
               }
            System.out.println(a);
        }
       if(a)
           return p ;
       else
           return -p;
       
    }
     public  int findgunnumber(Gun gun, int q){
        
         String name=gun.getName();
           int a=0;
           s=true;
            switch(name)
            {
                case "AR":
                   
                    a=creategun(q,1,1,1,1);
                    break;
                case "SR":
                   
                    a=creategun(q,2,2,1,1);
                    break;
                case "SMG":
                    a=creategun(q,2,1,2,1);
                    break;
                case "PISTOL":
                    a=creategun(q,1,2,3,1);
                    break;
                      case "SHOOTGUN":
                    a=creategun(q,1,2,3,1);
                    break;
            }
           return a;
     }

  
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManufacturerAdminRole());
        return roles;
    }
    
    
    
}
