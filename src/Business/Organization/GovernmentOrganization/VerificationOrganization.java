
package Business.Organization.GovernmentOrganization;


import Business.Role.Role;
import Business.Organization.Organization;
import Business.Role.VerificationAdminRole;

import java.util.ArrayList;

public class VerificationOrganization extends Organization{

    
    public VerificationOrganization() {
        super(Type.VerificationOrganization.getValue());
        
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new VerificationAdminRole());
        return roles;
    }
    
}
