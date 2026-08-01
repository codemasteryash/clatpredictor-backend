package com.clatpredictor.api.model;

import jakarta.persistence.*;


@Entity
@Table(name = "programs", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Program() {}

    public Program(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
