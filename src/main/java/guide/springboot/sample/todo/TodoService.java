package guide.springboot.sample.todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> selectAll();
    Optional<Todo> select(final String id);
    Todo insert(final TodoAttributes todoAttributes);
    String update(final String id, final TodoAttributes todoAttributes);
    Todo patch(final String id, final TodoAttributes todoAttributes);
    void patchAllStatus(final String status);
    void delete(final String id);
}
