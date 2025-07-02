package com.ru.pattern.prototype;

/**
 * ! Patrón Prototype:
 *
 * Es un patrón de diseño creacional que nos permite copiar objetos existentes sin hacer
 * que el código dependa de sus clases.
 *
 * * Es útil cuando queremos duplicar el contenido,
 * * el título y el autor de un documento, por ejemplo o cualquier objeto complejo.
 *
 * https://refactoring.guru/es/design-patterns/prototype
 */

public class PrototypeExample {

    public static void main(String[] args) {
        Document doc1 = new Document("Cotizacion", "500 dolares", "Fernando");

        System.out.println(doc1);

        Document doc2 = doc1.toCopy();
        doc2.title = "Cotizacion 2";

        System.out.println(doc2);
    }

}

class Document implements Prototype<Document>{
    public String title;
    private String content;
    public String author;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public Document toCopy() {
        return new Document(this.title, this.content, this.author);
    }
}

interface Prototype<T> {
    T toCopy();
}
