package jpabook.jpashop.service;

import jpabook.jpashop.domain.Todo;
import jpabook.jpashop.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {

    private final TodoRepository todoRepository;
    @Transactional
    public void saveItem(Todo item){
        item.setDate(new Date());
        item.setStatus("todo");

        todoRepository.save(item);
    }

    public List<Todo> findItems(){

        List<Todo> res = todoRepository.findAll();

        return res;
    }

    public List<Todo> findRecentItem(){

        List<Todo> res = todoRepository.findFirstByOrderByDateDesc();

        return res;
    }

    public int updateItems(Todo data){
        Long id = data.getId();

        Optional<Todo> res = todoRepository.findById(id);
        if (res.isPresent()) {
            Todo todo = res.get();
            todo.setStatus(data.getStatus());
            todoRepository.save(todo);
            return 1;
        } else {
            return 0;
        }
    }

}
