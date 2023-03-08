package com.example.third.controller;

import com.example.third.domain.Item;
import com.example.third.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basic")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String items(Model model) {
        List<Item> items = itemService.allItems();
        model.addAttribute("items",items);
        return "basic/items";
    }
    @GetMapping("/item/{id}")
    public String item(@PathVariable Long id, Model model) {
        Item item = itemService.findItemById(id).get();
        model.addAttribute("item",item);
        return "basic/item";
    }
    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        Item item = itemService.findItemById(id).get();
        model.addAttribute("item",item);
        return "basic/editForm";
    }
    @GetMapping("/add")
    public String addItem() {
        return "basic/addForm";
    }
}
