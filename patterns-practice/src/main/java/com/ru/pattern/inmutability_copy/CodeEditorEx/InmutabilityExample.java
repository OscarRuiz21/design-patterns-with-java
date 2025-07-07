package com.ru.pattern.inmutability_copy.CodeEditorEx;

public class InmutabilityExample {

    public static void main(String[] args) {

        CodeEditorHistory history = new CodeEditorHistory();
        CodeEditorState state = new CodeEditorState("console.log('hola Mundo!');", 2, false);

        history.save(state);

        System.out.print("Estado inicial: ");
        state.displayState();

        state = state.copyWith("console.log('hola Mundo!'); \nconsole.log('Nueva Linea');", 3, true);

        history.save(state);

        System.out.print("Estado dos: ");
        state.displayState();

        state = state.copyWith(null,5,null);

        history.save(state);

        System.out.print("Estado tres: ");
        state.displayState();

        state = history.unDo().orElseThrow(() -> new IllegalStateException("No previous state to undo to"));
        
        System.out.print("Despues del undo: ");
        state.displayState();

        state = history.reDo().orElseThrow(() -> new IllegalStateException("No next state to redo to"));

        System.out.print("Despues del undo: ");
        state.displayState();



    }
}

