package Business;

import Business.Gun.GunBulletSystem;
import Business.Material.Material;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

public class GunSystem extends Organization {

    private static GunSystem business;
   
    private ArrayList<Network> networkList;
    

    public static GunSystem getInstance() {
        if (business == null) {
            business = new GunSystem();
        }
        return business;
       
    }
    


    private GunSystem() {
        super(null);
        networkList = new ArrayList<>();
        
       
        
    }    
    
    public ArrayList<Network> getNetworkList() {
        if(networkList==null)
            networkList=new ArrayList<>();
        return networkList;
    }

    public Network createAndAddNetwork(String name) {
        Network network = new Network(name);
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }
}