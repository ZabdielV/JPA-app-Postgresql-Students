package com.ltp.gradesubmission.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter

// @RequiredArgsConstructor generates a constructor with 1 parameter for each
// field that requires special handling
@RequiredArgsConstructor

// Por defecto una entidad no ocupa de un constructor y de forma inconciente se
// agrega @NoArgsConstructor.
// Pero si se define un costructor entonces se tiene que poner
// @NoArgsConstructor.
// @NoArgsConstructor will generate a constructor with no parameters
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "subject", nullable = false)
    private String subject;

    @NonNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    // MappedBy sirve para indicar que no cree otra tabla SQL.
    // JsonIgnore = Avoids recursive error.
    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;

}
