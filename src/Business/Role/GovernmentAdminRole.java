
package Business.Role;

import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Gun.GunBulletSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.GovernementRole.GovernmentAdminWorkJPanel;
import javax.swing.JPanel;


public class GovernmentAdminRole extends Role{

   

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, GunSystem system) {
        return new GovernmentAdminWorkJPanel(userProcessContainer, enterprise);
    }

    
    
}
