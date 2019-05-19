package com.darakay.tinkoff.task2.notepad.storage;

import com.darakay.tinkoff.task2.notepad.EntryNotFoundException;
import com.darakay.tinkoff.task2.notepad.NotepadEntry;
import com.darakay.tinkoff.task2.notepad.NotepadEntryStorage;

import java.util.List;
import java.util.UUID;

public class DataBaseStorage implements NotepadEntryStorage {

    @Override
    public NotepadEntry getNotepadEntryById(UUID id) throws EntryNotFoundException {
        return null;
    }

    @Override
    public void addNotepadEntryById(UUID id, NotepadEntry notepadEntry) {

    }

    @Override
    public List<NotepadEntry> getAllNotepadEntry() {
        return null;
    }

    @Override
    public boolean removeNotepadEntry(UUID id) {
        return false;
    }

    @Override
    public boolean replaceNotepadEntryById(UUID id, NotepadEntry notepadEntry) {
        return false;
    }
}
