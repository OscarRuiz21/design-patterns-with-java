package com.ru.pattern.behaviorals.memento.CodeEditorEx;

// MEMENTO DESIGN PATTERN

/**
 * ! Inmutabilidad con copia
 * Aunque la inmutabilidad es una buena práctica, no siempre es posible.
 * En estos casos, se puede hacer una copia del objeto y modificar la copia.
 *
 *  * Es útil para mantener un historial de estados en aplicaciones interactivas.
 *
 */

public class InmutabilityExample {

    public static void main(String[] args) {

        CodeEditorHistory history = new CodeEditorHistory();
        CodeEditorState state = new CodeEditorState("console.log('hola Mundo!');", 2, false);

        history.save(state);

        state = state.copyWith("console.log('hola Mundo!'); \nconsole.log('Nueva Linea');", 3, true);
        history.save(state);

        state = state.copyWith(null, 5, null);
        history.save(state);

        // Mostrar historial completo
        history.showHistory();

        // Undo
        state = history.unDo().orElseThrow(() -> new IllegalStateException("No previous state to undo to"));
        System.out.print("⬅️ Después de undo:\n");
        state.displayState();

        // Redo
        state = history.reDo().orElseThrow(() -> new IllegalStateException("No next state to redo to"));
        System.out.print("➡️ Después de redo:\n");
        state.displayState();
    }
}

