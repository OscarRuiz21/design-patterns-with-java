package com.ru.pattern.builder;

import com.ru.pattern.builder.computer.Computer;
import com.ru.pattern.builder.computer.ComputerBuilder;
import com.ru.pattern.builder.orm.QueryBuilder;

public class Main {
    public static void main(String[] args) {

        Computer computer = new ComputerBuilder()
                .setCpu("cpu Intel i7")
                .setRam("Ram 32 g")
                .setStorage("storage c")
                .setGpu("gpu c")
                .build();
        Computer gamingComputer = new ComputerBuilder()
                .setCpu("Intel i9")
                .setRam("64GB")
                .setStorage("1TB M2")
                .setGpu("Nvidia RTX 5090")
                .build();

        System.out.println(computer);
        System.out.println(gamingComputer);

        String sql = new QueryBuilder("users")
                .select("id", "name", "email")
                .where("age > 18")
                .where("country = 'Cri'")
                .orderBy("name", "ASC")
                .limit(10)
                .execute();

        System.out.println("Consulta generada:");
        System.out.println(sql);
    }

}
