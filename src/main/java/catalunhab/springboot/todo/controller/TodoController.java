package catalunhab.springboot.todo.controller;

import catalunhab.springboot.todo.model.Todo;
import catalunhab.springboot.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/list-todos")
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName();
        model.put("todos", service.retrieveTodos(name));
        log.info("todos" + service.retrieveTodos(name));
        return "list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = service.retrieveTodo(id);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateTodo(ModelMap model, @ModelAttribute("todo") Todo todo) {
        todo.setUser(getLoggedInUserName());
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }
}
