/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Gun;

import Business.Material.Material;
import Business.Material.MaterialDirectory;

public class GunBulletSystem {

    private GunDirectory gunDirectory;
    private BulletDirectory bulletDirectory;
    private MaterialDirectory materialDirectory;
    private static GunBulletSystem business;

    private GunBulletSystem() {
        gunDirectory = new GunDirectory();
        bulletDirectory = new BulletDirectory();
        materialDirectory = new MaterialDirectory();

        Material material1 = materialDirectory.createMaterial("steel");
        Material material2 = materialDirectory.createMaterial("plastic");
        Material material3 = materialDirectory.createMaterial("iron");
        Material material4 = materialDirectory.createMaterial("wood");

        Gun gun = gunDirectory.CreateGun("AR");
        Gun gun1 = gunDirectory.CreateGun("SR");
        Gun gun2 = gunDirectory.CreateGun("SMG");
        Gun gun3 = gunDirectory.CreateGun("PISTOL");
        Gun gun4 = gunDirectory.CreateGun("SHOOTGUN");
        
        Bullet bullet = bulletDirectory.createbullet("5.56mm");
        Bullet bullet1 = bulletDirectory.createbullet("7.62mm");
        Bullet bullet2 = bulletDirectory.createbullet("9mm");
        Bullet bullet3 = bulletDirectory.createbullet("10.45mm");

    }

    public static GunBulletSystem getInstance() {
        if (business == null) {
            business = new GunBulletSystem();
        }
        return business;
    }

    public MaterialDirectory getMaterialDirectory() {
        return materialDirectory;
    }

    public void setMaterialDirectory(MaterialDirectory materialDirectory) {
        this.materialDirectory = materialDirectory;
    }

    public GunDirectory getGunDirectory() {
        return gunDirectory;
    }

    public void setGunDirectory(GunDirectory gunDirectory) {
        this.gunDirectory = gunDirectory;
    }

    public BulletDirectory getBulletDirectory() {
        return bulletDirectory;
    }

    public void setBulletDirectory(BulletDirectory bulletDirectory) {
        this.bulletDirectory = bulletDirectory;
    }

}
