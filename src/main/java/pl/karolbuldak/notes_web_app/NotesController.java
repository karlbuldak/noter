package pl.karolbuldak.notes_web_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("")
    public List<Note> getAll() {
        return noteRepository.getAll();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Note> getBySlug(@PathVariable("slug") String slug) {
        try {
            Note note = noteRepository.getBySlug(slug);
            return new ResponseEntity<>(note, HttpStatus.OK);
        } catch (NoteNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        int result = noteRepository.saveNote(note);
        if (result == 201) {
            return new ResponseEntity<>(note, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{slug}")
    public ResponseEntity<Note> update(@PathVariable("slug") String slug, @RequestBody Note updatedNote) {
        Note note = noteRepository.getBySlug(updatedNote.getSlug());

        if(note != null) {
            note.setAuthor(updatedNote.getAuthor());
            note.setContent(updatedNote.getContent());
            note.setDate(updatedNote.getDate());
            noteRepository.update(note);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{slug}")
    public ResponseEntity<Note> partiallyUpdate(@PathVariable("slug") String slug, @RequestBody Note updatedNote) {
        Note note = noteRepository.getBySlug(slug);
        if (note != null) {
            if (updatedNote.getAuthor() != null) note.setAuthor(updatedNote.getAuthor());
            if (updatedNote.getContent() != null) note.setContent(updatedNote.getContent());
            note.setDate(Utils.returnCurrentLocalDateTime());
            noteRepository.update(note);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{slug}")
    public ResponseEntity<Void> delete(@PathVariable("slug") String slug) {
        int result = noteRepository.deleteBySlug(slug);
        if (result == 1) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
