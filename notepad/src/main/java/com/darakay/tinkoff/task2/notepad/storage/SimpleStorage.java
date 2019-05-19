package com.darakay.tinkoff.task2.notepad.storage;

import com.darakay.tinkoff.task2.notepad.EntryNotFoundException;
import com.darakay.tinkoff.task2.notepad.NotepadEntry;
import com.darakay.tinkoff.task2.notepad.NotepadEntryStorage;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class SimpleStorage implements NotepadEntryStorage
{
    private HashMap<UUID, NotepadEntry> entries = new HashMap<>();

    @Override
    public NotepadEntry getNotepadEntryById(UUID id) throws EntryNotFoundException {
        if(entries.containsKey(id))
            return entries.get(id);
        else
            throw new EntryNotFoundException();
    }

    @Override
    public void addNotepadEntryById(UUID id, NotepadEntry notepadEntry) {
        entries.put(id, notepadEntry);
    }

    @Override
    public Collection<NotepadEntry> getAllNotepadEntry() {
        return entries.values();
    }

    @Override
    public boolean removeNotepadEntry(UUID id) {
        NotepadEntry entry = entries.remove(id);
        return entry != null;
    }

    @Override
    public boolean replaceNotepadEntryById(UUID id, NotepadEntry notepadEntry) {
        if(entries.containsKey(id)) {
            entries.put(id, notepadEntry);
            return true;
        }
        return false;
    }
}
