package com.ru.pattern.inmutability_copy.CodeEditorEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CodeEditorHistory {

    private List<CodeEditorState> history = new ArrayList<>();
    private int currentIndex = -1;

    void save(CodeEditorState state) {
        if (this.currentIndex < this.history.size() - 1) {
            this.history.subList(currentIndex + 1, history.size()).clear();
        }
        history.add(state);
        currentIndex++;

    }

    Optional<CodeEditorState> unDo(){
        if(this.currentIndex > 0){
            this.currentIndex--;
            return Optional.of(history.get(currentIndex));
        }
        return Optional.empty();
    }

    Optional<CodeEditorState> reDo(){
        if(this.currentIndex < this.history.size() - 1){
            this.currentIndex++;
            return Optional.of(history.get(currentIndex));
        }
        return Optional.empty();
    }
}
