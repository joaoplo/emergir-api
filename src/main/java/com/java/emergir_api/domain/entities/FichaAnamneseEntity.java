package com.java.emergir_api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table( name = "FICHAS_ANAMNESE", schema = "EMERGIR_DIGITAL" )
public class FichaAnamneseEntity{

    @Id
    @Column( name = "IDT_FICHAS_ANAMNESE" )
    @SequenceGenerator( name = "SEQ_FICHAS_ANAMNESE", sequenceName = "SEQ_FICHAS_ANAMNESE", allocationSize = 1 , schema = "EMERGIR_DIGITAL" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_FICHAS_ANAMNESE" )
    private Long id;

    @Column( name = "DESCRICAO", nullable = false )
    private String descricao;

    @Column( name = "DT_REGISTRO", nullable = false )
    private LocalDate dataRegistro;

    @Column( name = "IDT_PACIENTE", nullable = false, insertable = false, updatable = false )
    private Long idPaciente;

    @OneToOne
    @JoinColumn( name = "IDT_PACIENTE", unique = true )
    private PacienteEntity paciente;
}
