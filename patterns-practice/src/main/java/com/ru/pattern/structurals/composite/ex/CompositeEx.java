package com.ru.pattern.structurals.composite.ex;

import java.util.ArrayList;
import java.util.List;

/**
 * ! Patrón Composite
 * Es un patrón de diseño estructural que permite componer objetos
 * en estructuras de árbol para representar jerarquías.
 *
 * El patrón permite a los clientes tratar de manera uniforme a los objetos
 * individuales y a sus composiciones.
 *
 * * Es útil cuando necesitas tratar a los objetos individuales
 * * y a sus composiciones de manera uniforme, y la estructura
 * * de los objetos forma una jerarquía en árbol.
 *
 * https://refactoring.guru/es/design-patterns/composite
 *
 */

public class CompositeEx {
    public static void main(String[] args) {
        FileSystemComponent root = new DirectoryComponent("root");
        FileSystemComponent dir1 = new DirectoryComponent("dir1");
        FileSystemComponent dir2 = new DirectoryComponent("dir2");
        FileSystemComponent file1 = new FileComponent("file1.txt");
        FileSystemComponent file2 = new FileComponent("file2.txt");
        FileSystemComponent file3 = new FileComponent("file3.txt");

        ((DirectoryComponent)dir1).add(file1);
        ((DirectoryComponent)dir2).add(file2);
        ((DirectoryComponent)dir2).add(file3);
        ((DirectoryComponent)root).add(dir1);
        ((DirectoryComponent)root).add(dir2);

        root.showDetails("");

        FileSystemComponent dir3 = new DirectoryComponent("dir3");
        FileSystemComponent file4 = new FileComponent("file4.txt");

        ((DirectoryComponent)dir3).add(file4);
        ((DirectoryComponent)root).add(dir3);

        System.out.println("------------------");
        root.showDetails("");

        ((DirectoryComponent)dir2).add(dir3);
        System.out.println("------------------");
        root.showDetails("");
    }
}

interface FileSystemComponent {
    void showDetails(String indent);
}
abstract class AbstractFileSystemComponent implements FileSystemComponent {
    protected String name;
    protected DirectoryComponent parent;

    public AbstractFileSystemComponent(String name) {
        this.name = name;
    }

    public DirectoryComponent getParent() {
        return parent;
    }

    public void setParent(DirectoryComponent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }
}

class FileComponent extends AbstractFileSystemComponent {

    public FileComponent(String name) {
        super(name);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "- File: "+ name);
    }

}

class DirectoryComponent extends AbstractFileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();;

    DirectoryComponent(String name) {
        super(name);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "- Directory: "+ name);
        this.children.forEach(child -> child.showDetails(indent + "  "));
    }

    void add(FileSystemComponent component) {
        if (component instanceof AbstractFileSystemComponent) {
            AbstractFileSystemComponent c = (AbstractFileSystemComponent) component;
            DirectoryComponent currentParent = c.getParent();
            if (currentParent != null) {
                // Eliminar del padre anterior
                currentParent.remove(c);
            }
            // Establecer nuevo padre
            c.setParent(this);
        }
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }
}