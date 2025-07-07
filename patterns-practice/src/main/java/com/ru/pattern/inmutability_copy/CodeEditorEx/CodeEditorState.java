package com.ru.pattern.inmutability_copy.CodeEditorEx;

public class CodeEditorState {
    private final String content;
    private final int cursorPosition;
    private final boolean unsavedChanges;

    public CodeEditorState(String content, int cursorPosition, boolean unsavedChanges) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.unsavedChanges = unsavedChanges;
    }

    public CodeEditorState copyWith(String content, Integer cursorPosition, Boolean unsavedChanges) {
        return new CodeEditorState(
                content != null ? content : this.content,
                cursorPosition != null ? cursorPosition : this.cursorPosition,
                unsavedChanges != null ? unsavedChanges : this.unsavedChanges
        );
    }


    public void displayState() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CodeEditorState{" +
                "content='" + content + '\'' +
                ", cursorPosition=" + cursorPosition +
                ", unsavedChanges=" + unsavedChanges +
                '}';
    }
}
