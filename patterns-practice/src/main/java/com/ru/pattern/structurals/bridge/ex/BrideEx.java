package com.ru.pattern.structurals.bridge.ex;

/**
 * ! Patrón Bridge
 * Este patrón nos permite desacoplar una abstracción de su implementación,
 * de tal forma que ambas puedan variar independientemente.
 *
 * * Es útil cuando se tienen múltiples implementaciones de una abstracción
 * * Se puede utilizar para separar la lógica de negocio de la lógica de presentación
 * * Se puede utilizar para separar la lógica de la interfaz de usuario también.
 *
 * https://refactoring.guru/es/design-patterns/bridge
 */

public class BrideEx {
    public static void main(String[] args) {

        Warrior warrior = new Warrior(new SwordAttack());

        warrior.useAbility();

        Mage mage = new Mage(new MagicSpell());

        mage.useAbility();

        Thief thief = new Thief(new Thunder());

        thief.useAbility();

        warrior.setAbility(new AxAttack());
        warrior.useAbility();
    }
}

interface Ability {
    void use();
}

class SwordAttack implements Ability {
    @Override
    public void use() {
        System.out.println("Ataque con espada");
    }
}

class MagicSpell implements Ability {
    @Override
    public void use() {
        System.out.println("Hechizo magico");
    }
}

class Thunder implements Ability {
    @Override
    public void use() {
        System.out.println("Golpe con tornado");
    }
}

class AxAttack implements Ability {
    @Override
    public void use() {
        System.out.println("Ataque con hacha");
    }
}

abstract class Character {
    protected Ability ability;
    public Character(Ability ability) {
        this.ability = ability;
    }

    public void setAbility(Ability ability){
        this.ability = ability;
    }

    abstract void useAbility();

}

class Warrior extends Character {

    public Warrior(Ability ability) {
        super(ability);
    }

    @Override
    void useAbility() {
        System.out.println("Warrior ready to fight ");
        ability.use();
    }
}

class Mage extends Character {

    public Mage(Ability ability) {
        super(ability);
    }
    @Override
    void useAbility() {
        System.out.println("Mage ready to cast spells ");
        ability.use();
    }
}

class Thief extends Character {

    public Thief(Ability ability) {
        super(ability);
    }
    @Override
    void useAbility() {
        System.out.println("Thief ready to steal ");
        ability.use();
    }
}

