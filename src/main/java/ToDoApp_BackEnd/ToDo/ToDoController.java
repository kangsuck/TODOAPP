package ToDoApp_BackEnd.ToDo;



import ToDoApp_BackEnd.ToDo.Dto.ToDoPatchDto;
import ToDoApp_BackEnd.ToDo.Dto.ToDoPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/toDo")
@Validated
public class ToDoController {
    private final ToDoService toDoService;
    private final ToDoMapper toDoMapper;

    public ToDoController(ToDoService toDoService, ToDoMapper toDoMapper){
        this.toDoService = toDoService;
        this.toDoMapper = toDoMapper;
    }

    @PostMapping
    public ResponseEntity postToDo(@RequestBody ToDoPostDto toDoPostDto) {
            ToDo toDo = new ToDo();
            toDo.setTitle(toDoPostDto.getTitle());
            toDo.setTodoOrder(toDoPostDto.getTodoOrder());
            toDo.setCompleted(toDoPostDto.isCompleted());
            toDoService.createToDo(toDo);
        return new ResponseEntity<>(toDoPostDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity getToAllDo() {
        List<ToDo> toDos = toDoService.findAllToDo();
        return new ResponseEntity<>(toDos, HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity getToDo(@PathVariable("id") int id) {
        ToDo toDo = toDoService.findToDo(id);
        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }

    @PatchMapping("/id")
    public ResponseEntity patchToDo(@PathVariable("id") @Positive int id, @RequestBody ToDoPatchDto toDoPatchDto) {
        toDoPatchDto.setId(id);
        ToDo toDo = toDoService.updateToDo(toDoMapper.toDoPatchDtoToToDo(toDoPatchDto));

        return new ResponseEntity<>(toDoMapper.toDoToToDoResponseDto(toDo),
                HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteAllToDo(){
        toDoService.deleteAllToDo();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteToDo(@PathVariable("id") int id){
        toDoService.deleteToDo(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
