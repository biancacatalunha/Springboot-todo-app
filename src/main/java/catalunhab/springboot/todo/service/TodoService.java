package catalunhab.springboot.todo.service;

import catalunhab.springboot.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "bianca", "Learn String MVC", new Date(), false));
        todos.add(new Todo(2, "bianca", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "bianca", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        return todos.stream()
                .filter(todo -> todo.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public Todo retrieveTodo(int id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateTodo(Todo todo) {
        deleteTodo(todo.getId());
        todos.add(todo);
    }

    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
