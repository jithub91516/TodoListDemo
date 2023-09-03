package jpabook.jpashop.controller;

import lombok.Data;

import java.util.Date;

@Data
public class TodoForm {
    private String title;
    private String description;
    private Date date;
}
