package com.darakay.tinkoff.task2.notepad;

import com.darakay.tinkoff.task2.notepad.storage.SimpleStorage;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class NotepadTest {

    private Notepad notepad;

    @Before
    public  void setUp() throws Exception {
        notepad = new Notepad(new SimpleStorage());
    }

    @Test
    public void addEntry_ShouldAddEntryAndReturnCorrectEntryId() throws EntryNotFoundException {
        UUID id = notepad.addEntry("First entry", "Hello, world!");
        notepad.getEntry(id);
    }

    @Test
    public void removeEntry_ShouldReturnTrue_IfEntryWasDeleted() {
        UUID id = notepad.addEntry("Entry", "Hello");
        assertThat(notepad.removeEntry(id)).isTrue();
    }

    @Test
    public void removeEntry_ShouldReturnFalse_IfEntryWasNotDeleted() {
        assertThat(notepad.removeEntry(UUID.randomUUID())).isFalse();
    }

    @Test
    public void edit_ShouldEditExistedEntry() throws EntryNotFoundException {
        UUID id = notepad.addEntry("First entry", "Hello, world!");
        notepad.edit(id, "Second entry", "Hello");
        assertThat(notepad.getEntry(id).getTitle()).isEqualTo("Second entry");
        assertThat(notepad.getEntry(id).getText()).isEqualTo("Hello");
    }

    @Test
    public void edit_ShouldReturnFalse_ThenEntryWasNotEdited() throws EntryNotFoundException {
        assertThat(notepad.edit(UUID.randomUUID(),
                "Second entry", "Hello")).isFalse();
    }

    @Test
    public void getAllEntries_ShouldReturnAllEntries() {
        for(int i = 0; i < 5; i++)
            notepad.addEntry("title "+i, "text "+i);
        assertThat(notepad.getAllEntries().size()).isEqualTo(5);
    }
}