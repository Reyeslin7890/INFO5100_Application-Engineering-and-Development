
package Business.Organization;

import Business.Organization.GovernmentOrganization.VerificationOrganization;
import Business.Organization.GovernmentOrganization.CertificateOrganization;
import Business.Organization.GovernmentOrganization.GradeOrganization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;


public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.VerificationOrganization.getValue())){
            organization = new VerificationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.GradeOrganization.getValue())){
            organization = new GradeOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.CertificateOrganization.getValue())){
            organization = new CertificateOrganization();
            organizationList.add(organization);
        }
        
        
        return organization;
    }
}