package com.java.emergir_api.domain.entities;

import com.java.emergir_api.domain.enumeration.FormaPagamentoEnum;
import com.java.emergir_api.domain.enumeration.SituacaoAvaliacaoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table( name = "AVALIACOES_PSICOLOGICAS", schema = "EMERGIR_DIGITAL" )
public class AvaliacaoPsicologicaEntity{

    @Id
    @Column( name = "IDT_AVALIACOES_PSICOLOGICAS" )
    @SequenceGenerator( name = "SEQ_AVALIACOES_PSICOLOGICAS", sequenceName = "SEQ_AVALIACOES_PSICOLOGICAS", allocationSize = 1, schema = "EMERGIR_DIGITAL" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_AVALIACOES_PSICOLOGICAS" )
    private Long id;

    @Column( name = "NOME_PACIENTE", nullable = false )
    private String nomePaciente;

    @Column( name = "IDADE", nullable = false )
    private Long idade;

    @Column( name = "ENCAMINHAMENTO", nullable = false )
    private String encaminhamento;

    @Column( name = "VALOR", nullable = false )
    private BigDecimal valor;

    @Column( name = "FORMA_PAGAMENTO", nullable = false )
    @Enumerated( EnumType.STRING )
    private FormaPagamentoEnum formaPagamento;

    @Column( name = "TEM_CONTRATO", nullable = false )
    private Boolean temContrato;

    @Column( name = "ATENDIMENTOS", nullable = false )
    private Long atendimentos;

    @Column( name = "SITUACAO_AVALIACAO", nullable = false )
    @Enumerated( EnumType.STRING )
    private SituacaoAvaliacaoEnum situacaoAvaliacao;

    @Column( name = "DATA_INICIAL", nullable = false )
    private LocalDate dataInicial;

    @Column( name = "DATA_FINAL" )
    private LocalDate dataFinal;

    @Column( name = "DATA_DEVOLUTIVA" )
    private LocalDate dataDevolucao;

    @Column( name = "AVALIACAO_GOOGLE", nullable = false )
    private Boolean avaliacaoGoogle;

    @ManyToOne
    @JoinColumn( name = "IDT_PACIENTE" )
    private PacienteEntity paciente;
}
