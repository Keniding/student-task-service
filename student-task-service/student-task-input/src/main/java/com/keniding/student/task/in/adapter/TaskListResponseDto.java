package com.keniding.student.task.in.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskListResponseDto {
    private int total;
    private List<TaskResponseDto> tasks;
}
