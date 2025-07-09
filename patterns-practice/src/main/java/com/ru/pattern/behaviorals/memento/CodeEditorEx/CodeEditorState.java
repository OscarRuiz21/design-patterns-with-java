package com.ru.pattern.behaviorals.memento.CodeEditorEx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeEditorState {
    private final String content;
    private final int cursorPosition;
    private final boolean unsavedChanges;
    private final LocalDateTime timestamp;

    public CodeEditorState(String content, int cursorPosition, boolean unsavedChanges) {
        this(content, cursorPosition, unsavedChanges, LocalDateTime.now());
    }

    public CodeEditorState(String content, int cursorPosition, boolean unsavedChanges, LocalDateTime timestamp) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.unsavedChanges = unsavedChanges;
        this.timestamp = timestamp;
    }

    public CodeEditorState copyWith(String content, Integer cursorPosition, Boolean unsavedChanges) {
        return new CodeEditorState(
                content != null ? content : this.content,
                cursorPosition != null ? cursorPosition : this.cursorPosition,
                unsavedChanges != null ? unsavedChanges : this.unsavedChanges,
                LocalDateTime.now()
        );
    }

    public void displayState() {
        System.out.println(this);
    }

    public String toFormattedString(int index) {
        return String.format("""
                ┌── Estado #%d ─────────────────────────────
                │ Cursor: %d
                │ Unsaved Changes: %s
                │ Fecha: %s
                └── Contenido:
                %s
                """, index, cursorPosition, unsavedChanges,
                timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                content);
    }

    @Override
    public String toString() {
        return "CodeEditorState{" +
                "content='" + content + '\'' +
                ", cursorPosition=" + cursorPosition +
                ", unsavedChanges=" + unsavedChanges +
                ", timestamp=" + timestamp +
                '}';
    }
}
