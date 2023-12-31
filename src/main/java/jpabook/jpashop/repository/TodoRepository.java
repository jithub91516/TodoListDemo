package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findFirstByOrderByDateDesc();

}
