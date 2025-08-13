package com.ru.pattern.structurals.flyweight.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BilletFlyweigthHw {
    public static void main(String[] args) {

        BulletTypeFactory factory = new BulletTypeFactory();
        ShootingSystem shootingSystem = new ShootingSystem(factory);

        // Disparar varias balas de diferentes tipos
        shootingSystem.shoot(10, 20, 0, "Pistola", 10, "Gris");
        shootingSystem.shoot(15, 25, 90, "Escopeta", 20, "Rojo");
        shootingSystem.shoot(20, 30, 180, "Rifle", 15, "Verde");
        shootingSystem.shoot(10, 20, 45, "Pistola", 10, "Gris");
        shootingSystem.shoot(25, 35, 270, "Escopeta", 20, "Rojo");

        System.out.println(
                "Total de balas disparadas: " + shootingSystem.getBulletsCount()
        );
    }

}

// 1. Clase que representa el tipo de bala - BulletType (Flyweight)
class BulletType{
    private String name;
    private int damage;
    private String color;

    public BulletType(String name, int damage, String color) {
        this.name = name;
        this.color = color;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getColor() {
        return color;
    }
}

// 2. Fábrica de Flyweights - BulletTypeFactory
class BulletTypeFactory{
    private Map<String, BulletType> bulletTypes = new HashMap<>();

    public BulletType getBulletType(String name, int damage, String color){
        BulletType bulletType = bulletTypes.get(name);
        if(bulletType == null){
            System.out.println("Creating bullet type: " + name + " with damage: " + damage + " and color: " + color + "");
            bulletType = new BulletType(name, damage, color);
            bulletTypes.put(name, bulletType);
        }
        return bulletType;
    }

    public BulletType getBulletType(String name){
        return getBulletType(name, 10, "Red");
    }
}

// 3. Clase que representa una Bala - Bullet
class Bullet{
    private int x;
    private int y;
    private int direction;
    private BulletType bulletType;

    public Bullet(int x, int y, int direction, BulletType bulletType) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.bulletType = bulletType;
    }

    public void display() {
        String text = String.format(
                "\n Disparo:\n" +
                "    Bala  del tipo: \"%s\" \n" +
                        "  Coords: (%d, %d)\n" +
                        "  Dirección: %s\n" +
                        "  Daño: %d\n" +
                        "  Color: %s\n",
                bulletType.getName(),
                x, y,
                direction,
                bulletType.getDamage(),
                bulletType.getColor()
        );

        System.out.println(text);
    }

}
// 4. Sistema de Disparos - ShootingSystem

class ShootingSystem{
    private List<Bullet> bullets = new ArrayList<>();
    private BulletTypeFactory bulletTypeFactory;

    public ShootingSystem(BulletTypeFactory bulletTypeFactory) {
        this.bulletTypeFactory = bulletTypeFactory;
    }

    void shoot(int x, int y, int direccion, String name, int damage, String color){
        BulletType bulletType = bulletTypeFactory.getBulletType(name, damage, color);
        Bullet bullet = new Bullet(x, y, direccion, bulletType);
        bullets.add(bullet);
        bullet.display();
    }

    int getBulletsCount(){
        return bullets.size();
    }
}