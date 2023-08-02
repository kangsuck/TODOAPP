package ToDoApp_BackEnd.ToDo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    @Override
    List<ToDo> findAll();

    @Override
    Optional<ToDo> findById(Integer integer);

}
