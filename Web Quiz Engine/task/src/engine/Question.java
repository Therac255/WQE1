package engine;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
//@Component

public class Question {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public int id;
    String title;
    String text;
    String[] options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    int answer;

    public Question() {
    }

    public static Question toQuestion (String jsonData) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(jsonData, Question.class);
    }

    @JsonCreator
    public Question(@JsonProperty("title")String title, @JsonProperty("text")String text, @JsonProperty("options")String[] options, @JsonProperty("answer")int answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
