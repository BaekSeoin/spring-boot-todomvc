package guide.springboot.sample.todo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String content;
    private String status;
    private Boolean edit;

    protected Todo() {

    }

    Todo(final String content, final String status, final Boolean edit) {
        this(null, content, status, edit);
    }

    Todo(final String id, final String content, final String status, final Boolean edit) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.edit = edit;
    }

    public String getId() {return this.id;}

    public String getContent() {return this.content; }

    public String getStatus() {return this.status; }

    public Boolean getEdit() {return this.edit; }

    public void setContent(String content) {
        this.content = content;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", edit='" + edit + '\'' +
                '}';
    }
}
