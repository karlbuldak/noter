package pl.karolbuldak.notes_web_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class NoteRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Note> getAll() {
        return jdbcTemplate.query("SELECT id, author, content, date FROM note",
                BeanPropertyRowMapper.newInstance(Note.class));
    }

    public Note getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, author, content, date FROM note WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Note.class), id);
    }

    public String returnCurrentLocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public int saveNote(Note note) {
        jdbcTemplate.update("INSERT INTO note(author, content, date) VALUES (?, ?, ?)", note.getAuthor(), note.getContent(), returnCurrentLocalDateTime());
        return 200;
    }

    public int update(Note note) {
        jdbcTemplate.update("UPDATE note SET author=?, content=?, date=? WHERE id=?",
                note.getAuthor(), note.getContent(), returnCurrentLocalDateTime(), note.getId());
        return 1;
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM note WHERE id=?", id);
    }
}
