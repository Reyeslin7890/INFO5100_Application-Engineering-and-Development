
package Business.WorkQueue;

import Business.Gun.GunInventoryitem;


public class GunRequest extends WorkRequest{
    private String testResult;
    private GunInventoryitem gunInventoryitem;
    private int gunprice;

    public String getTestResult() {
        return testResult;
    }

    public GunRequest() {
        gunInventoryitem=new GunInventoryitem();
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public int getGunprice() {
        return gunprice;
    }

    public void setGunprice(int gunprice) {
        this.gunprice = gunprice;
    }
    

    public GunInventoryitem getGunInventoryitem() {
        return gunInventoryitem;
    }

    public void setGunInventoryitem(GunInventoryitem gunInventoryitem) {
        this.gunInventoryitem = gunInventoryitem;
    }
       @Override
    public String toString(){
    return gunInventoryitem.getGun().getName();
    }
    
     
}
