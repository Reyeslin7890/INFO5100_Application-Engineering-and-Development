package Business;

import Business.Material.Material;
import Business.Gun.*;
import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

public class ConfigureASystem {
    
    public static GunSystem configure(){
        
        GunSystem system = GunSystem.getInstance();
        
        
        Person person = system.getPersonDirectory().createPerson("SystemAdmin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sys", "123", person, new SystemAdminRole());
        


       
        
        return system;
    }
    
}
