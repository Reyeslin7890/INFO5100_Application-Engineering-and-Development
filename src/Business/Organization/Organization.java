package Business.Organization;

import Business.Gun.GunBulletSystem;
import Business.Material.MaterialDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.Person.PersonDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private String workArea;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private MaterialDirectory materialDirectory;
    private GunBulletSystem gunBulletSystem;
    private int organizationID;
    private static int counter;

    public enum Type {
        AdminOrganization("Admin Organization"),
        VerificationOrganization("VerificationOrganization"),
        GradeOrganization("GradeOrganization"),
        CertificateOrganization("CertificateOrganization"),
        DistributeOrganization("DistributeOrganization"),
        ManufactorOrganization("ManufactorOrganization");
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        materialDirectory=new MaterialDirectory();
        
        
        organizationID = counter;
        counter++;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public MaterialDirectory getMaterialDirectory() {
        return materialDirectory;
    }

    public void setMaterialDirectory(MaterialDirectory materialDirectory) {
        this.materialDirectory = materialDirectory;
    }
    
    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public GunBulletSystem getGunBulletSystem() {
        return gunBulletSystem;
    }

    public void setGunBulletSystem(GunBulletSystem gunBulletSystem) {
        this.gunBulletSystem = gunBulletSystem;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
