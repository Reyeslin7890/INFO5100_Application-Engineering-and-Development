
package Business.Role;


import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Gun.GunBulletSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.SystemAdmin.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;


public class SystemAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, GunSystem system) {
         return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}
