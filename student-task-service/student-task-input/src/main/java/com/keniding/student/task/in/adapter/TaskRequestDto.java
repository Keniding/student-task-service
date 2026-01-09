package com.keniding.student.task.in.adapter;

import com.keniding.student.task.core.business.TaskCategory;
import com.keniding.student.task.core.port.in.TaskInputValue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequestDto implements TaskInputValue {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    @NotBlank(message = "Category is required")
    private TaskCategory category;
    @NotBlank(message = "Due date is required")
    private String dueDate;
}
