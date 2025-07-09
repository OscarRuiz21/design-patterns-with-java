package com.ru.pattern.behaviorals.memento.CodeEditorEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CodeEditorHistory {

    private final List<CodeEditorState> history = new ArrayList<>();
    private int currentIndex = -1;
    private final int MAX_HISTORY = 10;

    void save(CodeEditorState state) {
        if (currentIndex < history.size() - 1) {
            history.subList(currentIndex + 1, history.size()).clear();
        }

        if (history.size() == MAX_HISTORY) {
            history.remove(0); // elimina el más viejo
            currentIndex--; // ajustar índice
        }

        history.add(state);
        currentIndex++;
    }

    Optional<CodeEditorState> unDo() {
        if (currentIndex > 0) {
            currentIndex--;
            return Optional.of(history.get(currentIndex));
        }
        return Optional.empty();
    }

    Optional<CodeEditorState> reDo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            return Optional.of(history.get(currentIndex));
        }
        return Optional.empty();
    }

    void showHistory() {
        System.out.println("\n📜 Historial del editor:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i).toFormattedString(i + 1));
        }
    }
}
