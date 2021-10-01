package guide.springboot.sample.todo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoAttributes {
    private final String content;
    private final String status;
    private final Boolean edit;

    @JsonCreator
    TodoAttributes(@JsonProperty("content") final String content, @JsonProperty("status") final String status, @JsonProperty("edit") final Boolean edit) {
        this.content = content;
        this.status = status;
        this.edit = edit;
    }

    public String getContent() {return content;}

    public String getStatus() {return status; }

    public Boolean getEdit() {return edit; }
}
