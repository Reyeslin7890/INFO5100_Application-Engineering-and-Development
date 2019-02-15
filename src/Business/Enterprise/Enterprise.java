/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Gun.*;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private ArrayList<BulletInventoryitem> bulletInventory;
    private ArrayList<GunInventoryitem> gunInventory;
    private GunBulletSystem gunBulletSystem;
    private int expense = 0;
    private int revenue = 0;
    private int totalcustomer = 0;
    private int blocktimes = 0;
    private String grade = "B";

    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
        bulletInventory = new ArrayList<>();
        gunInventory = new ArrayList<>();

    }

    public int getTotalcustomer() {
        return totalcustomer;
    }

    public void setTotalcustomer(int totalcustomer) {
        this.totalcustomer = totalcustomer;
    }

    public int getBlocktimes() {
        return blocktimes;
    }

    public void setBlocktimes(int blocktimes) {
        this.blocktimes = blocktimes;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public ArrayList<BulletInventoryitem> getBulletInventory() {
        if (bulletInventory == null) {
            bulletInventory = new ArrayList<BulletInventoryitem>();
        }
        return bulletInventory;
    }

    public void setBulletInventory(ArrayList<BulletInventoryitem> bulletInventory) {
        this.bulletInventory = bulletInventory;
    }

    public ArrayList<GunInventoryitem> getGunInventory() {
        if (gunInventory == null) {
            gunInventory = new ArrayList<GunInventoryitem>();
        }
        return gunInventory;
    }

    public void setGunInventory(ArrayList<GunInventoryitem> gunInventory) {
        this.gunInventory = gunInventory;
    }

    public GunBulletSystem getGunBulletSystem() {
        return gunBulletSystem;
    }

    public void setGunBulletSystem(GunBulletSystem gunBulletSystem) {
        this.gunBulletSystem = gunBulletSystem;
    }

    public GunInventoryitem findguninventory(Gun gun) {
        for (GunInventoryitem gunInventory : gunInventory) {
            if (gunInventory.getGun().getName().equals(gun.getName())) {
                return gunInventory;
            }
        }
        return null;
    }

    public BulletInventoryitem findbulletinventory(Bullet bullet) {
        for (BulletInventoryitem bulletInventory : bulletInventory) {
            if (bulletInventory.getBullet().getName().equals(bullet.getName())) {
                return bulletInventory;
            }
        }
        return null;
    }

    public void createguninventoryitem(Gun gun, int num, int q) {
        GunInventoryitem gunInventoryitem = new GunInventoryitem();
        gunInventoryitem.setnum(num);
        gunInventoryitem.setGun(gun);
        gunInventoryitem.setPrice(q);
        gunInventory.add(gunInventoryitem);
    }

    public void createbulletinventoryitem(Bullet bullet, int num, int p) {
        BulletInventoryitem bulletInventoryitem = new BulletInventoryitem();
        bulletInventoryitem.setnum(num);
        bulletInventoryitem.setBullet(bullet);
        bulletInventoryitem.setPrice(p);
        bulletInventory.add(bulletInventoryitem);
    }

    public enum EnterpriseType {
        DistributorEnterprise("DistributorEnterprise"),
        ManufactorEnterprise("ManufactorEnterprise"),
        GovernmentEnterprise("GovernmentEnterprise");

        private String value;

        private EnterpriseType(String value) {
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

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
}
