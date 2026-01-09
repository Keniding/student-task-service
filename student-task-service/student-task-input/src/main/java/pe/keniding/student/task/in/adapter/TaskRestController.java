package pe.keniding.student.task.in.adapter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.keniding.student.task.core.port.in.TaskInputPort;
import pe.keniding.student.task.core.port.in.TaskReturnValue;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    private TaskInputPort taskCore;
    private final TaskDtoMapper mapper = Mappers.getMapper(TaskDtoMapper.class);

    public TaskRestController(TaskInputPort taskCore) {
        this.taskCore = taskCore;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDto createTask(@Valid @RequestBody TaskRequestDto request) {
        log.info("Creating task: {}", request.getTitle());
        TaskReturnValue result = taskCore.createTask(request);
        return mapper.toDto(result);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponseDto getTask(@PathVariable Long id) {
        log.info("Getting task: {}", id);
        TaskReturnValue result = taskCore.getTask(id);
        return mapper.toDto(result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskListResponseDto getAllTasks() {
        log.info("Getting all tasks");
        List<TaskReturnValue> tasks = taskCore.getAllTasks();
        List<TaskResponseDto> dtos = mapper.toDtoList(tasks);
        return new TaskListResponseDto(dtos.size(), dtos);
    }

    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponseDto updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        log.info("Updating task {} to status {}", id, status);
        TaskReturnValue result = taskCore.updateTaskStatus(id, status);
        return mapper.toDto(result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        log.info("Deleting task: {}", id);
        taskCore.deleteTask(id);
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public TaskListResponseDto getTasksByCategory(@PathVariable String category) {
        log.info("Getting tasks by category: {}", category);
        List<TaskReturnValue> tasks = taskCore.getTasksByCategory(category);
        List<TaskResponseDto> dtos = mapper.toDtoList(tasks);
        return new TaskListResponseDto(dtos.size(), dtos);
    }
}
