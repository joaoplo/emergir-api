package com.java.emergir_api.domain.entities;

import com.java.emergir_api.domain.FichaAnamneseEntity;
import com.java.emergir_api.domain.enumeration.ModalidadeAtendimentoEnum;
import com.java.emergir_api.domain.enumeration.PlanoPacienteEnum;
import com.java.emergir_api.domain.enumeration.SituacaoPacienteEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table( name = "PACIENTES", schema = "EMERGIR_DIGITAL" )
public class PacienteEntity{

    @Id
    @Column( name = "IDT_PACIENTES" )
    @SequenceGenerator( name = "SEQ_PACIENTES", sequenceName = "SEQ_PACIENTES", allocationSize = 1, schema = "EMERGIR_DIGITAL" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_PACIENTES" )
    private Long id;

    @Column( name = "CPF", nullable = false )
    private String cpf;

    @Column( name = "NOME", nullable = false )
    private String nome;

    @Column( name = "DT_NASCIMENTO", nullable = false )
    private LocalDate dataNascimento;

    @Column( name = "DT_INICIO", nullable = false )
    private LocalDate dataInicio;

    @Column( name = "DT_TERMINO" )
    private LocalDate dataTermino;

    @Column( name = "ATENDIMENTO", nullable = false )
    @Enumerated( EnumType.STRING )
    private ModalidadeAtendimentoEnum atendimento;

    @Column( name = "PLANO", nullable = false )
    @Enumerated( EnumType.STRING )
    private PlanoPacienteEnum plano;

    @Column( name = "SITUACAO", nullable = false )
    @Enumerated( EnumType.STRING )
    private SituacaoPacienteEnum situacao;

    @OneToMany( mappedBy = "paciente", fetch = FetchType.LAZY )
    private List<EvolucaoClinicaEntity> evolucoesClinicas;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FichaAnamneseEntity fichaAnamnese;
}
