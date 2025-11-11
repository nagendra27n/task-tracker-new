package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Task;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> getAllTask(){
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskById(Long id){
	    if (!taskRepository.existsById(id)) {
	        throw new TaskNotFoundException(id);
	    }
		return taskRepository.findById(id);
		
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
//	public Task updateTask(Long id, Task updatedTask) {
//		
//		return taskRepository.findById(id).map(task ->{
//			task.setTitle(updatedTask.getTitle());
//			task.setDiscription(updatedTask.getDiscription());
//			task.setStatus(updatedTask.getStatus());
//			return taskRepository.save(task);
//		})
//				.orElse(null);
//		
//	}
	
	public Task updatetask(Long id, Task updatedTask) {
		
		return taskRepository.findById(id).map(task ->{
			task.setDiscription(updatedTask.getDiscription());
			task.setStatus(updatedTask.getStatus());
			task.setTitle(updatedTask.getTitle());	
			return taskRepository.save(task);
		}).orElseThrow(()->new TaskNotFoundException(id));
	}
	
	public void deleteTask(Long id) {
	    if (!taskRepository.existsById(id)) {
	        throw new TaskNotFoundException(id);
	    }
	    taskRepository.deleteById(id);
	}
	
	public List<Task> getTasksByStatus(String status) {
	    return taskRepository.findByStatus(status);
	}


}
