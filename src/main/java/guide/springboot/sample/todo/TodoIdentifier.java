package guide.springboot.sample.todo;

public class TodoIdentifier {
    private final String value;

    public TodoIdentifier (final String value) {
        this.value = value;
    }

    public String getValue() {return value; }

}
