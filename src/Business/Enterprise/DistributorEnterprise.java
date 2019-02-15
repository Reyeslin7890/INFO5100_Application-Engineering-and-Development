/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.DistributorAdminRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.Random;

public class DistributorEnterprise extends Enterprise {

    private String code;

    public DistributorEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.DistributorEnterprise);
        Random r = new Random();
        code = String.valueOf(r.nextInt(1000000));
        while (code.length() < 6) {
            code = "0" + code;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorAdminRole());
        return roles;
    }
}
