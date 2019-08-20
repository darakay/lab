package com.darakay.tinkoff.task2.notepad;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface NotepadEntryStorage {
    NotepadEntry getNotepadEntryById(UUID id) throws EntryNotFoundException;
    void addNotepadEntryById(UUID id, NotepadEntry notepadEntry);
    Collection<NotepadEntry> getAllNotepadEntry();
    boolean removeNotepadEntry(UUID id);
    boolean replaceNotepadEntryById(UUID id, NotepadEntry notepadEntry);
}
