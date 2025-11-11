package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
	
	private final TaskService taskService;
	
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTask();
		}
	
	@GetMapping("/{id}")
	public Optional<Task> getTaskById(@PathVariable Long id){
		return taskService.getTaskById(id);
	}
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
		
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updatedtask) {
		return taskService.updatetask(id, updatedtask);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}
	
	@GetMapping("/status/{status}")
	public List<Task> getTasksByStatus(@PathVariable String status) {
	    return taskService.getTasksByStatus(status);
	}

	

}
