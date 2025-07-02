package com.ru.pattern.prototype.pokemonHW;

import java.util.ArrayList;
import java.util.List;

public class PokemonHW {

    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon("Pikachu", "Electric", 100, List.of("Thunderbolt", "Volt Tackle"));
        pikachu.displayInfo();

        Pokemon elekit = pikachu.clone();
        elekit.name = "Elekit";
        elekit.level = 10;
        elekit.attacks.add("Thunder");

        elekit.displayInfo();
        pikachu.displayInfo();


    }
}





class Pokemon {
    public String name;
    public String type;
    public int level;
    public List<String> attacks;

    public Pokemon(String name, String type, int level, List<String> attacks) {
        // TODO: Implementar constructor
        this.name = name;
        this.type = type;
        this.level = level;
        this.attacks = attacks;
    }

    // Método para clonar el Pokémon
    public Pokemon clone() {
        // Los ataques deben de evitar pasarse por referencia, es decir, no deben de ser el mismo arreglo.
        // Completar: Debe devolver un nuevo Pokémon con los mismos atributos
        return new Pokemon(this.name, this.type, this.level, getAttacks());
    }

    public List<String> getAttacks() {
        List<String> attacksToCopy = new ArrayList<>();
        this.attacks.forEach(a -> attacksToCopy.add(a));
        return attacksToCopy;
    }

    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", attacks=" + attacks +
                '}';
    }
}
