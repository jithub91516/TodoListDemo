package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Todo;
import jpabook.jpashop.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final TodoService todoService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new TodoForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(Todo form) {
        todoService.saveItem(form);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String list(Model model) {

        List<Todo> items = todoService.findItems();

        model.addAttribute("items", items);
        return "items/itemList";
    }

    @PostMapping("/items/update")
    public String updateItems(@RequestBody Todo data) {

        int res = todoService.updateItems(data);

        return "items/itemList";
    }

    @GetMapping("/items/recent")
    public String getRecent(Model model) {

        List<Todo> items = todoService.findRecentItem();
        model.addAttribute("items", items);

        return "items/itemList";
    }


}






