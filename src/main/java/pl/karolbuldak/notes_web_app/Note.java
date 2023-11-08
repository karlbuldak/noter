package pl.karolbuldak.notes_web_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private int id;
    private String author;
    private String date;
    private String content;

}
