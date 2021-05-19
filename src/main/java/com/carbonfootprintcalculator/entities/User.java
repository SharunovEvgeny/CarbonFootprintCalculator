package com.carbonfootprintcalculator.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  public User(String username, String name, String surname) {
    this.username = username;
    this.name = name;
    this.surname = surname;
  }
}
