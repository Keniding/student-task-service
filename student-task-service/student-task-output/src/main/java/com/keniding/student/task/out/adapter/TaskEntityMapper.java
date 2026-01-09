package com.keniding.student.task.out.adapter;

import com.keniding.student.task.core.port.out.TaskData;
import org.mapstruct.Mapper;

@Mapper
public interface TaskEntityMapper {
    TaskEntity toEntry(TaskData data);
    TaskData toData(TaskEntity entity);
}
