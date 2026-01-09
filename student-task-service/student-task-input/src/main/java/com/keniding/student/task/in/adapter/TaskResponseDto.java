package com.keniding.student.task.in.adapter;

import com.keniding.student.task.core.business.TaskCategory;
import com.keniding.student.task.core.business.TaskStatus;
import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private TaskCategory category;
    private TaskStatus status;
    private String dueDate;
}
