package com.java.emergir_api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table( name = "EVOLUCOES_CLINICAS", schema = "EMERGIR_DIGITAL")
public class EvolucaoClinicaEntity{

    @Id
    @Column( name = "IDT_EVOLUCOES_CLINICAS" )
    @SequenceGenerator( name = "SEQ_EVOLUCOES_CLINICAS", sequenceName = "SEQ_EVOLUCOES_CLINICAS", allocationSize = 1 , schema = "CMC_DIGITAL" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_EVOLUCOES_CLINICAS" )
    private Long id;

    @Column( name = "DESCRICAO", nullable = false )
    private String descricao;

    @Column( name = "DT_REGISTRO", nullable = false )
    private LocalDate dtRegistro;

    @Column( name = "IDT_PACIENTE", nullable = false, insertable = false, updatable = false )
    private Long idPaciente;

    @ManyToOne
    @JoinColumn( name = "IDT_PACIENTE", nullable = false )
    private PacienteEntity paciente;
}
