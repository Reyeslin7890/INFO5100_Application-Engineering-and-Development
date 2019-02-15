package Business.Role;

import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.GovernementRole.CertificationRole.ManageCertificationJPanel;
import javax.swing.JPanel;

public class CertificateAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, GunSystem system) {
        return new ManageCertificationJPanel(userProcessContainer, account, organization);
    }
}
