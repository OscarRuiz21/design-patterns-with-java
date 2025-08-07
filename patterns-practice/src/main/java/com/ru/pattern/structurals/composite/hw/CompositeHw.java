package com.ru.pattern.structurals.composite.hw;

public class CompositeHw {
    public static void main(String[] args) {
        // Crear ítems individuales
        MenuItem salad = new MenuItem("Ensalada", 5.99);
        MenuItem soup = new MenuItem("Sopa de tomate", 4.99);
        MenuItem steak = new MenuItem("Bistec", 15.99);
        MenuItem soda = new MenuItem("Refresco", 2.5);
        MenuItem dessert = new MenuItem("Pastel de chocolate", 6.5);
        MenuItem coffee = new MenuItem("Café", 1.99);

        // Crear categorías de menú y añadir ítems
        MenuCategory appetizers = new MenuCategory("Entradas");
        appetizers.add(salad);
        appetizers.add(soup);

        MenuCategory mainCourse = new MenuCategory("Plato Principal");
        mainCourse.add(steak);

        MenuCategory beverages = new MenuCategory("Bebidas");
        beverages.add(soda);
        beverages.add(coffee);

        MenuCategory desserts = new MenuCategory("Postres");
        desserts.add(dessert);

        // Crear un menú principal que contiene todas las categorías
        MenuCategory mainMenu = new MenuCategory("Menú Principal");
        mainMenu.add(appetizers);
        mainMenu.add(beverages);
        mainMenu.add(desserts);
        mainMenu.add(mainCourse);

        // Mostrar la estructura completa del menú
        System.out.println("Menú del Restaurante:");
        mainMenu.showDetails("");
    }
}

interface MenuComponent {
    void showDetails(String indent);
}

abstract class AbstractMenuComponent implements MenuComponent {
    protected String name;

    public AbstractMenuComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class MenuItem extends AbstractMenuComponent {
    private double price;

    public MenuItem(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + name + ", price:" + price);
    }
}

class MenuCategory extends AbstractMenuComponent {
    private MenuComponent[] menuComponents;

    public MenuCategory(String name) {
        super(name);
        menuComponents = new MenuComponent[0];
    }

    public void add(MenuComponent menuComponent) {
        MenuComponent[] newMenuComponents = new MenuComponent[menuComponents.length + 1];
        /*
        for (int i = 0; i < menuComponents.length; i++) {
            newMenuComponents[i] = menuComponents[i];
        }

        menuComponents = Arrays.copyOf(menuComponents, menuComponents.length + 1);

        */
        System.arraycopy(menuComponents, 0, newMenuComponents, 0, menuComponents.length);
        newMenuComponents[menuComponents.length] = menuComponent;
        menuComponents = newMenuComponents;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Categoria:" + name );
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.showDetails(indent + "  ");
        }
    }
}
