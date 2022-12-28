package com.ltp.gradesubmission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.*;

@Getter
@Setter
// AllArgsConstructor = Inicializa todos los atributos para no necesitar de un
// constructor o @Autowired
@AllArgsConstructor
@NoArgsConstructor
@Entity

// Como esta tabla tiene dos llaves foraneas, se le agrega la caracteristica de
// unique
// Asi se evita el tener elementos duplicados.
@Table(name = "grade", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "student_id", "course_id" })
})

public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "score", nullable = false)
    private String score;

    // referencedColumnName = nombre del atributo en la entidad
    // name= Nombre dentro de la base de datos
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

}
