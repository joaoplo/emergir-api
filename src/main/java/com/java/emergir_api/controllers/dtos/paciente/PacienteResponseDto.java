package com.java.emergir_api.controllers.dtos.paciente;

import com.java.emergir_api.controllers.dtos.ficha_anamnese.FichaAnamneseResponseDto;
import com.java.emergir_api.domain.enumeration.ModalidadeAtendimentoEnum;
import com.java.emergir_api.domain.enumeration.PlanoPacienteEnum;
import com.java.emergir_api.domain.enumeration.SituacaoPacienteEnum;

import javax.annotation.Nullable;
import java.time.LocalDate;

public record PacienteResponseDto( Long id,
                                   String cpf,
                                   String nome,
                                   LocalDate dataNascimento,
                                   LocalDate dataInicio,
                                   @Nullable LocalDate dataTermino,
                                   ModalidadeAtendimentoEnum atendimento,
                                   PlanoPacienteEnum plano,
                                   SituacaoPacienteEnum situacao,
                                   FichaAnamneseResponseDto fichaAnamnese ){
}
