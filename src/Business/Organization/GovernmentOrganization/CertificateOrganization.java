
package Business.Organization.GovernmentOrganization;


import Business.Role.Role;
import Business.Organization.Organization;
import Business.Role.CertificateAdminRole;

import java.util.ArrayList;


public class CertificateOrganization extends Organization{

    
    public CertificateOrganization() {
        super(Type.CertificateOrganization.getValue());
      
    }

   
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CertificateAdminRole());
        return roles;
    }
    
}
