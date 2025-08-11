package com.ru.pattern.structurals.facade.ex;

/**
 * ! Patrón Facade
 * Este patrón proporciona una interfaz unificada para un conjunto de interfaces
 * en un subsistema.
 *
 * Facade define una interfaz de nivel más alto que hace que el subsistema
 * sea más fácil de usar.
 *
 * * Es útil cuando un subsistema es complejo o difícil de entender para
 * * proporcionar una interfaz simplificada para el cliente.
 *
 * https://refactoring.guru/es/design-patterns/facade
 */

public class MovieTheaterFacadeEx {
    public static void main(String[] args) {
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        VideoPlayer videoPlayer = new VideoPlayer();
        PopcornMaker popcornMaker = new PopcornMaker();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                projector, soundSystem, videoPlayer, popcornMaker
        );

        homeTheater.watchMovie("Los Avengers");
        homeTheater.endWatchingMovie();
    }
}


class Projector {
    void turnOn() {
        System.out.println("Proyector encendido");
    }

    void turnOff() {
        System.out.println("Proyector apagado");
    }
}

class SoundSystem {
    void on() {
        System.out.println("Sistema de sonido encendido");
    }

    void off() {
        System.out.println("Sistema de sonido apagado");
    }
}

class VideoPlayer {
    void on() {
        System.out.println("Video player encendido");
    }

    void play(String movie) {
        System.out.println("Reproduciendo " + movie);
    }

    void stop() {
        System.out.println("Película detenida");
    }

    void off() {
        System.out.println("Video player apagado");
    }
}

class PopcornMaker {
    void poppingPopcorn() {
        System.out.println("Haciendo palomitas");
    }

    void turnOffPoppingPopcorn() {
        System.out.println("Deteniendo las palomitas");
    }
}

class HomeTheaterFacade {
    private final Projector projector;
    private final SoundSystem soundSystem;
    private final VideoPlayer videoPlayer;
    private final PopcornMaker popcornMaker;

    public HomeTheaterFacade(Projector projector,
                             SoundSystem soundSystem,
                             VideoPlayer videoPlayer,
                             PopcornMaker popcornMaker) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.videoPlayer = videoPlayer;
        this.popcornMaker = popcornMaker;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparando para ver la película");
        projector.turnOn();
        soundSystem.on();
        popcornMaker.poppingPopcorn();
        videoPlayer.on();
        videoPlayer.play(movie);
        System.out.println("¡Disfrute la película!");
    }

    public void endWatchingMovie() {
        System.out.println("\nPreparando para detener la película");
        projector.turnOff();
        soundSystem.off();
        popcornMaker.turnOffPoppingPopcorn();
        videoPlayer.stop();
        videoPlayer.off();
        System.out.println("Sistema apagado\n");
    }
}
