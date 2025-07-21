package com.ru.pattern.creationals.singleton.DragonBallsEx;

/**
 * ! Singleton:
 * Es un patrón de diseño creacional que garantiza que una clase
 * tenga una única instancia y proporciona un punto de acceso global a ella.
 *
 * * Es útil cuando necesitas controlar el acceso a una única instancia
 * * de una clase, como por ejemplo, en un objeto de base de datos o en un
 * * objeto de configuración.
 */

public class Main {
    public static void main(String[] args) {
        DragonBalls gokuDragonBalls = DragonBalls.getInstance();

        gokuDragonBalls.collectBall();
        gokuDragonBalls.collectBall();
        gokuDragonBalls.collectBall();

        gokuDragonBalls.summonShenlong();

        DragonBalls vegetaDragonBalls = DragonBalls.getInstance();
        vegetaDragonBalls.collectBall();
        vegetaDragonBalls.collectBall();
        vegetaDragonBalls.collectBall();
        vegetaDragonBalls.collectBall();

        gokuDragonBalls.summonShenlong();
        vegetaDragonBalls.summonShenlong();
    }
}
