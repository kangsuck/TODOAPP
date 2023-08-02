package ToDoApp_BackEnd.ToDo;

import ToDoApp_BackEnd.ToDo.Dto.ToDoPatchDto;
import ToDoApp_BackEnd.ToDo.Dto.ToDoPostDto;
import ToDoApp_BackEnd.ToDo.Dto.ToDoResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    ToDo toDoPostDtoToToDo(ToDoPostDto toDoPostDto);
    ToDo toDoPatchDtoToToDo(ToDoPatchDto toDoPatchDto);
    ToDoResponseDto toDoToToDoResponseDto(ToDo toDo);
//    List<ToDoResponseDto> toDosToToDoResponseDtos(List<ToDo> toDos);
}
