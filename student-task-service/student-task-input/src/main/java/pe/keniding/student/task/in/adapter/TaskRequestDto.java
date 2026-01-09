package pe.keniding.student.task.in.adapter;

import pe.keniding.student.task.core.business.TaskCategory;
import pe.keniding.student.task.core.port.in.TaskInputValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDto implements TaskInputValue {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Category is required")
    private TaskCategory category;

    @NotBlank(message = "Due date is required")
    private String dueDate;
}
