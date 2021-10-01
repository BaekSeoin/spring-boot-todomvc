package guide.springboot.sample.todo;

import guide.springboot.sample.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

interface TodoSpringDataRepository extends JpaRepository<Todo, String> {
}
