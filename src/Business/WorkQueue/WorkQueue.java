
package Business.WorkQueue;

import java.util.ArrayList;


public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;
    private ArrayList<GunRequest>gunRequestList ;
    private ArrayList<BulletRequst>bulletRequstList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
        gunRequestList=new ArrayList<>();
        bulletRequstList=new ArrayList<>();
    }

    public ArrayList<GunRequest> getGunRequestList() {
        return gunRequestList;
    }

    public ArrayList<BulletRequst> getBulletRequstList() {
        return bulletRequstList;
    }
    
    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}