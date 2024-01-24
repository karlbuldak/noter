package pl.karolbuldak.notes_web_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public class NoteRepository {
    final
    JdbcTemplate jdbcTemplate;

    public NoteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Note> getAll() {
        return jdbcTemplate.query("SELECT id, author, content, date FROM note",
                BeanPropertyRowMapper.newInstance(Note.class));
    }

    public Note getBySlug(String slug) {
        try {
            return jdbcTemplate.queryForObject("SELECT id, author, content, date, slug FROM note WHERE slug = ?",
                    BeanPropertyRowMapper.newInstance(Note.class), slug);
        } catch (EmptyResultDataAccessException e) {
            throw new NoteNotFoundException("Note with slug " + slug + " not found");
        }
    }


    public int saveNote(Note note) {
            jdbcTemplate.update("INSERT INTO note(author, content, date, slug) VALUES (?, ?, ?, ?)",
                    note.getAuthor(), note.getContent(), note.getDate(), note.getSlug());
        return 201;
    }

    public int update(Note note) {
        jdbcTemplate.update("UPDATE note SET author=?, content=?, date=? WHERE slug=?",
                note.getAuthor(), note.getContent(), note.getDate(), note.getSlug());
        return 1;
    }

    public int deleteBySlug(String slug) {
        return jdbcTemplate.update("DELETE FROM note WHERE slug=?", slug);
    }
}
