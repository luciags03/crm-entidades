
package edu.altair.crmfaltas.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(
    name = "matriculas",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_matricula_estudiante_asignatura",
            columnNames = {"estudiante_dni", "asignatura_codigo"}
        )
    }
)
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula_id")
    private Long matriculaId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "estudiante_dni",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_matricula_estudiante")
    )
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "asignatura_codigo",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_matricula_asignatura")
    )
    private Asignatura asignatura;

    @Column(name = "fecha_matriculacion", nullable = false)
    private LocalDate fechaMatriculacion;

    @Column(name = "nota_final")
    private Double notaFinal;

    public Matricula() {
    }

    public Matricula(
            Estudiante estudiante,
            Asignatura asignatura,
            LocalDate fechaMatriculacion,
            Double notaFinal) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.fechaMatriculacion = fechaMatriculacion;
        this.notaFinal = notaFinal;
    }

    public Long getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Long matriculaId) {
        this.matriculaId = matriculaId;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }
}
