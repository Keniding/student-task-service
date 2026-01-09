package pe.keniding.student.task.in.adapter;

import pe.keniding.student.task.core.business.TaskCategory;
import pe.keniding.student.task.core.business.TaskStatus;
import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private TaskCategory category;
    private TaskStatus status;
    private String dueDate;
}
