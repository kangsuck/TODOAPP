package ToDoApp_BackEnd.ToDo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDo(ToDo toDo){

        return toDoRepository.save(toDo);
    }

    public List<ToDo> findAllToDo(){
        return toDoRepository.findAll();
    }

    public ToDo findToDo(int id){
        return findVerifiedToDoByQuery(id);
    }

    public void deleteToDo(int toDoId){
        ToDo todo = findVerifiedToDoByQuery(toDoId);
        toDoRepository.delete(todo);
    }

    public void deleteAllToDo(){
        toDoRepository.deleteAll();
    }


    public ToDo updateToDo(ToDo toDo){
        ToDo findToDo = findVerifiedToDoByQuery(toDo.getId());

        Optional.ofNullable(toDo.getTitle())
                .ifPresent(title -> findToDo.setTitle(title));
        Optional.ofNullable(toDo.getTodoOrder())
                .ifPresent(eodoOrder -> findToDo.setTodoOrder(eodoOrder));
        Optional.ofNullable(toDo.isCompleted())
                .ifPresent(completed -> findToDo.setCompleted(completed));


        return toDoRepository.save(findToDo);
    }

    private ToDo findVerifiedToDoByQuery(int id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        ToDo findToDo =
                optionalToDo.orElse(null);

        return findToDo;
    }



}
