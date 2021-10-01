package guide.springboot.sample.controller;

import guide.springboot.sample.todo.Todo;
import guide.springboot.sample.todo.TodoAttributes;
import guide.springboot.sample.todo.TodoIdentifier;
import guide.springboot.sample.todo.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@Validated
public class TodoController {

    private final TodoService todoService;

    TodoController(final TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    List<Todo> retrieveAll() {
        return todoService.selectAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> retrieveById(@PathVariable("id") final String id){
        final var todo = todoService.select(id);
        return ResponseEntity.of(todo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Todo create(@RequestBody final TodoAttributes todoAttributes) {
        var newTodo = todoService.insert(todoAttributes);
        return newTodo;
    }

    @PutMapping("/{id}")
    TodoIdentifier update(@PathVariable("id") final String id, @RequestBody final TodoAttributes todoAttributes) {
        var updatedId = todoService.update(id, todoAttributes);
        return new TodoIdentifier(updatedId);
    }

    @PatchMapping("/{id}")
    Todo patch(@PathVariable("id") final String id, @RequestBody final TodoAttributes todoAttributes) {
        var patchTodo = todoService.patch(id, todoAttributes);
        return patchTodo;
    }

    @PatchMapping
    void patchAllStatus(@RequestBody final TodoAttributes todoAttributes) {
        todoService.patchAllStatus(todoAttributes.getStatus());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") final String id) {
        todoService.delete(id);
    }
}
