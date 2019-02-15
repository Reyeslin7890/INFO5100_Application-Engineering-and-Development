package Business.Role;

import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Gun.GunBulletSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.GovernementRole.CertificationRole.ManageCertificationJPanel;
import UserInterface.GovernementRole.VerificationRole.ManageVerificationJPanel;
import javax.swing.JPanel;

public class VerificationAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, GunSystem system) {
        return new ManageVerificationJPanel(userProcessContainer, account, organization);
    }
}
