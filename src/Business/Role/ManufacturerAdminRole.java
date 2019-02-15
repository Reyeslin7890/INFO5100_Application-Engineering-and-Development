package Business.Role;


import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.*;
import Business.Gun.GunBulletSystem;
import javax.swing.JPanel;
import UserInterface.ManufactureRole.ManufactureAdminWorkJPanel;


public class ManufacturerAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, GunSystem system) {
        return new ManufactureAdminWorkJPanel( userProcessContainer,  organization,  network, enterprise,  account);
    }
    
    
    
}
