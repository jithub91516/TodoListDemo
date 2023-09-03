package jpabook.jpashop.domain;

import jdk.vm.ci.meta.Local;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private  Long id;

    private String title;

    private String description;

    private Date date;

    private String status;

}
