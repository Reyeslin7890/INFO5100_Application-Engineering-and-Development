
package Business.Role;

import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Gun.GunBulletSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.GovernementRole.EvaluationRole.ManageEvaluationJPanel;
import javax.swing.JPanel;

public class GradeAdminRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, GunSystem system) {
        return new ManageEvaluationJPanel(userProcessContainer, account, organization,network);
    }
}
