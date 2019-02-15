package Business.Role;

import Business.GunSystem;
import Business.Enterprise.Enterprise;
import Business.Gun.GunBulletSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

public abstract class Role {

    public enum RoleType {
        SystemAdminRole("SystemAdminRole"),
        GovernmentAdminRole("GovernmentAdminRole"),
        ManufactorAdminRole("ManufactorAdminRole"),
        DistributorAdminRole("DistributorAdminRole"),
        GradeAdminRole("GradeAdminRole"),
        VerificationAdminRole("VerificationAdminRole"),
        CertificateAdminRole(" CertificateAdminRole");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            Network network,
            GunSystem system
            
    );

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
