package com.example.exersise13_q1_controller.Controller;

import com.example.exersise13_q1_controller.Api.ApiResponse;
import com.example.exersise13_q1_controller.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TrackerController {
    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }
   @PostMapping("/add")
public ApiResponse addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponse("Task added successfully");
}
@PutMapping("/update/{index}")
public ApiResponse updateTask(@PathVariable int index,@RequestBody Task task){
        tasks.set(index, task);
        return new ApiResponse("Task updated successfully");
}
@DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponse("Task deleted successfully");
}
@PutMapping("/change/{index}")
public ApiResponse changeTaskStatus(@PathVariable int index){
       tasks.get(index);
       if(tasks.get(index).getStatus().equalsIgnoreCase("not done")){
           tasks.get(index).setStatus("done");

       }
        return new ApiResponse("Task changed successfully");

}
@GetMapping("/search/{title}")
public ArrayList<Task> searchTask(@PathVariable String title){
        ArrayList<Task> search = new ArrayList<>();

    for (Task task : tasks) {
        if (task.getTitle().contains(title)) {
            search.add(task);
        }
    }

    return search;
}
}



