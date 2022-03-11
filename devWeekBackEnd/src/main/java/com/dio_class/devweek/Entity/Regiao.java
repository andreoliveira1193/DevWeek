package com.dio_class.devweek.Entity;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import javax.persistence.*;
import java.awt.*;

@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String regiao;
    private Integer total_exames;

    public Regiao(String regiao, Integer total){
        this.regiao = regiao;
        this.total_exames = total;
    }
    public Regiao(){}

    public Long getId() {
        return id;
    }

       public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Integer getTotal_exames() {
        return total_exames;
    }

    public void setTotal_exames(Integer total_exames) {
        this.total_exames = total_exames;
    }
}
