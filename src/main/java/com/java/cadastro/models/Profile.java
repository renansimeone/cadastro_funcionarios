package com.java.cadastro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id_profile;
    @Column(name = "linkedin", length = 50, nullable = true)
    private String linkedin;
    @Column(name = "facebook", length = 50, nullable = true)
    private String facebook;
    @Column(name = "instagram", length = 50, nullable = true)
    private String instagram;
    @Column(name = "twitter", length = 50, nullable = true)
    private String twitter;
    @Column(name = "github", length = 50, nullable = true)
    private String github;
}
