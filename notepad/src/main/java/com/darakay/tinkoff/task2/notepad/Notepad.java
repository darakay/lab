package com.darakay.tinkoff.task2.notepad;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Notepad {
    private final NotepadEntryStorage storage;

    public Notepad(NotepadEntryStorage storage){
        this.storage = storage;
    }

    public UUID addEntry(String title, String text){
        UUID id = UUID.randomUUID();
        NotepadEntry entry = new NotepadEntry(title, text, new Date());
        storage.addNotepadEntryById(id, entry);
        return id;
    }

    public NotepadEntry getEntry(UUID id) throws EntryNotFoundException {
        return storage.getNotepadEntryById(id);
    }

    public boolean removeEntry(UUID id){
        return storage.removeNotepadEntry(id);
    }

    public boolean edit(UUID id, String newTitle, String newText){
        try {
            NotepadEntry entry = storage.getNotepadEntryById(id);
            NotepadEntry changed = new NotepadEntry(newTitle, newText, entry.getCreationDate());
            return storage.replaceNotepadEntryById(id, changed);
        } catch (EntryNotFoundException e) {
            return false;
        }
    }

    public Collection<NotepadEntry> getAllEntries(){
        return storage.getAllNotepadEntry();
    }

    public List<NotepadEntry> filterByName(String name){
        return storage.getAllNotepadEntry()
                .stream()
                .filter(entry -> entry.getTitle()
                        .startsWith(name))
                .collect(Collectors.toList());
    }

    public List<NotepadEntry> filterByCreationDate(Date creationDate){
        return storage.getAllNotepadEntry()
                .stream()
                .filter(entry -> entry.getCreationDate()
                        .equals(creationDate))
                .collect(Collectors.toList());
    }
}
