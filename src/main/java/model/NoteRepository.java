package model;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private static List<Note> noteList = new ArrayList<>();
    private static int idCounter = 1;

    public List<Note> getAllNotes() {
        return noteList;
    }

    public void addNote(Note note) {
        note.setId(idCounter++);
        noteList.add(note);
    }
}