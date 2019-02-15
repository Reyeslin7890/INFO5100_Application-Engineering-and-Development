/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Gun.BulletInventoryitem;
import Business.Gun.GunInventoryitem;

/**
 *
 * @author yuzix
 */
public class BulletRequst extends WorkRequest{
    private String testResult;
    private BulletInventoryitem bulletInventoryitem;
    private int bulletprice=0;

    public String getTestResult() {
        return testResult;
    }

    public BulletRequst() {
        bulletInventoryitem=new BulletInventoryitem();
    }
    

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public BulletInventoryitem getBulletInventoryitem() {
        return bulletInventoryitem;
    }

    public void setBulletInventoryitem(BulletInventoryitem bulletInventoryitem) {
        this.bulletInventoryitem = bulletInventoryitem;
    }

    public int getBulletprice() {
        return bulletprice;
    }

    public void setBulletprice(int bulletprice) {
        this.bulletprice = bulletprice;
    }
    @Override
    public String toString(){
    return bulletInventoryitem.getBullet().getName();
    }
   
}

