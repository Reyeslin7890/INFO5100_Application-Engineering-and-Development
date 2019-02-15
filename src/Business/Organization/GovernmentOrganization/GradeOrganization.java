
package Business.Organization.GovernmentOrganization;


import Business.Organization.Organization;
import Business.Role.GradeAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

public class GradeOrganization extends Organization{
   
    
    public GradeOrganization() {
        super(Type.GradeOrganization.getValue());
       
    }
    
   
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GradeAdminRole());
        return roles;
    }
    
}
