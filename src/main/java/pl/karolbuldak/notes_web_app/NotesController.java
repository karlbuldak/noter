package pl.karolbuldak.notes_web_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("")
    public List<Note> getAll() {
        return noteRepository.getAll();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable("id") int id) {
        return noteRepository.getById(id);
    }

    @PostMapping("")
    public int addNote(@RequestBody Note note) {
        return noteRepository.saveNote(note);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Note updatedNote) {
        Note note = noteRepository.getById(id);

        if(note != null) {
            note.setAuthor(updatedNote.getAuthor());
            note.setContent(updatedNote.getContent());
            note.setDate(updatedNote.getDate());
            noteRepository.update(note);
            return -1;
        } else {
            return 1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Note updatedNote) {
        Note note = noteRepository.getById(id);
        if (note != null) {
            if (updatedNote.getAuthor() != null) note.setAuthor(updatedNote.getAuthor());
            if (updatedNote.getContent() != null) note.setContent(updatedNote.getContent());
            note.setDate(noteRepository.returnCurrentLocalDateTime());
            noteRepository.update(note);
            return -1;
        } else {
            return 1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return noteRepository.delete(id);
    }
}
