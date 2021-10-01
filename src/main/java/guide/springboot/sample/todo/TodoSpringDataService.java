package guide.springboot.sample.todo;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component //Bean으로 등록
public class TodoSpringDataService implements TodoService {

    private TodoSpringDataRepository todoSpringDataRepository;

    TodoSpringDataService(final TodoSpringDataRepository todoSpringDataRepository) {
        this.todoSpringDataRepository = todoSpringDataRepository;
    }

    @Override
    public List<Todo> selectAll() {
        return todoSpringDataRepository.findAll();
    }

    @Override
    public Optional<Todo> select(final String id) {
        try {
            return todoSpringDataRepository.findById(id);
        }
        catch (EmptyResultDataAccessException ignored) {

        }
        return null;
    }

    @Override
    public Todo insert(final TodoAttributes todoAttributes) {
        final var entity = new Todo(todoAttributes.getContent(), todoAttributes.getStatus(), todoAttributes.getEdit());

        final var saved = todoSpringDataRepository.save(entity);

        return saved;
    }

    @Override
    public String update(final String id, final TodoAttributes todoAttributes) {

        final var existingEntity = todoSpringDataRepository.findById(id).orElseThrow();

        existingEntity.setContent(todoAttributes.getContent());
        existingEntity.setStatus(todoAttributes.getStatus());
        existingEntity.setEdit(todoAttributes.getEdit());

        final var saved = todoSpringDataRepository.save(existingEntity);

        return saved.getId();
    }

    @Override
    public Todo patch(final String id, final TodoAttributes todoAttributes) {

        final var existingEntity = todoSpringDataRepository.findById(id).orElseThrow();

        if (todoAttributes.getContent() != null) {
            existingEntity.setContent(todoAttributes.getContent());
        }

        if (todoAttributes.getStatus() != null) {
            existingEntity.setStatus(todoAttributes.getStatus());
        }

        if (todoAttributes.getEdit() != null) {
            existingEntity.setEdit(todoAttributes.getEdit());
        }

        final var saved = todoSpringDataRepository.save(existingEntity);
        return saved;
    }

    @Override
    public void patchAllStatus(final String status) {
        final var existingEntities = todoSpringDataRepository.findAll();

        existingEntities.forEach(existingEntity -> {
            existingEntity.setStatus(status);
            final var saved = todoSpringDataRepository.save(existingEntity);
        });
    }

    @Override
    public void delete(final String id){
        try {
            todoSpringDataRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException ignored){
        }
    }
}
