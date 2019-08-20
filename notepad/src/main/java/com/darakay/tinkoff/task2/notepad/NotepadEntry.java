package com.darakay.tinkoff.task2.notepad;

import java.util.Date;
import java.util.Objects;

public class NotepadEntry {
    private final String title;
    private final String text;
    private final Date creationDate;

    NotepadEntry(String title, String text, Date creationDate) {
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotepadEntry)) return false;
        NotepadEntry that = (NotepadEntry) o;
        return Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getText(), that.getText()) &&
                Objects.equals(getCreationDate(), that.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getText(), getCreationDate());
    }

    @Override
    public String toString() {
        return "NotepadEntry{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
