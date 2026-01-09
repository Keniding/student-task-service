package pe.keniding.student.task.in.adapter;

import pe.keniding.student.task.core.port.in.TaskReturnValue;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {

    TaskResponseDto toDto(TaskReturnValue value);

    default List<TaskResponseDto> toDtoList(List<TaskReturnValue> values) {
        return values.stream().map(this::toDto).toList();
    }
}
