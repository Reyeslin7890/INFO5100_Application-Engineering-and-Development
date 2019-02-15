/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.CustomerRole;
import Business.Role.Role;
import java.util.ArrayList;



public class Network extends Organization{
    
    private String name;
    private EnterpriseDirectory enterpriseDirectory;

    public Network(String name) {
        super(name);
        this.name = name;
        enterpriseDirectory = new EnterpriseDirectory();
    }
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> role = new ArrayList<>();
        role.add(new CustomerRole());
        return role;
    }
    
   
}
