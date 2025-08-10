package com.ru.pattern.structurals.decorator.hw;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

public class EquipmentDecoratorHw {
    // Crear un personaje básico
    public static void main(String[] args) {

        Character character = new BasicCharacter();
        System.out.println("\nPersonaje inicial: " + character.getDescription());
        System.out.println("Estadísticas: " + character.getStats());

        // Añadir un casco al personaje
        character = new HelmetDecorator(character);
        System.out.println("\nCon Casco: " + character.getDescription());
        System.out.println("Estadísticas: " + character.getStats());

        // Añadir un escudo al personaje
        character = new ShieldDecorator(character);
        System.out.println("\nCon Escudo: " + character.getDescription());
        System.out.println("Estadísticas: " + character.getStats());

        // Añadir una espada al personaje
        character = new SwordDecorator(character);
        System.out.println("\nCon Espada: " + character.getDescription());
        System.out.println("Estadísticas: " + character.getStats());

        // Añadir un anillo al personaje
        // character = new RingDecorator(character);
        // System.out.println("\nCon Anillo: " + character.getDescription());
        // System.out.println("Estadísticas: " + character.getStats());

        System.out.println("\n\n");
    }

}

interface Character{
    String getDescription();
    Stats getStats();

    class Stats{
        int attack;
        int defense;

        public Stats(int attack, int defense) {
            this.attack = attack;
            this.defense = defense;
        }

        @Override
        public String toString() {
            return "Stats{" +
                    "attack=" + attack +
                    ", defense=" + defense +
                    '}';
        }
    }
}

class BasicCharacter implements Character{

    @Override
    public String getDescription() {
        return "Personaje Basico";
    }

    @Override
    public Stats getStats() {
        return new Stats(10,10);
    }
}

abstract class CharacterDecorator implements Character{

    protected Character character;

    public CharacterDecorator(Character decoratedCharacter){
        this.character = decoratedCharacter;
    }

    @Override
    public String getDescription() {
        return character.getDescription();
    }

    @Override
    public Stats getStats() {
        return character.getStats();
    }
}

class HelmetDecorator extends CharacterDecorator{
    public HelmetDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " con Casco";
    }
    @Override
    public Stats getStats() {
        Stats currentStats = super.getStats();
        currentStats.defense += 10;
        return currentStats;
    }
}

class ShieldDecorator extends CharacterDecorator{
    public ShieldDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " con Escudo";
    }
    @Override
    public Stats getStats() {
        Stats currentStats = super.getStats();
        currentStats.defense += 10;
        return currentStats;
    }
}

class SwordDecorator extends CharacterDecorator{
    public SwordDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " con Espada";
    }
    @Override
    public Stats getStats() {
        Stats currentStats = super.getStats();
        currentStats.attack += 7;
        return currentStats;
    }
}


