package Business.Role;

import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Gun.GunBulletSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DistributorRole.DistributorAdminWorkJPanel;
import javax.swing.JPanel;

public class DistributorAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel display, UserAccount account, Organization organization, Enterprise enterprise, Network network, GunSystem system) {
      
        return new DistributorAdminWorkJPanel(display,enterprise,account,organization,system,network);
        
    }

}
