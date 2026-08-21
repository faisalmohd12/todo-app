package com.app.todoapp.controller;


import org.springframework.ui.Model;
import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;



    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public String getTask(Model model) {
        List<Task> task = taskService.getAllTask();
        model.addAttribute("task", task);
        return "task";
    }
    @PostMapping
    public String createTask(@RequestParam String title) {
       taskService.createTask(title);
        return "redirect:/task";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/task";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/task";
    }
}
