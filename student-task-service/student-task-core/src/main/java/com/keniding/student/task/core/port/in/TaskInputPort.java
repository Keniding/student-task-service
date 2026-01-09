package com.keniding.student.task.core.port.in;

import java.util.List;

public interface TaskInputPort {
    TaskReturnValue createTask(TaskInputValue taskInputValue);
    TaskReturnValue getTask(Long id);
    List<TaskReturnValue> getAllTasks();
    TaskReturnValue updateTaskStatus(Long id, String status);
    void deleteTask(Long id);
    List<TaskReturnValue> getTasksByCategory(String category);
}
