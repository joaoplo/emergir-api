package com.java.emergir_api.controllers.dtos.paciente;

import com.java.emergir_api.controllers.dtos.ficha_anamnese.FichaAnamneseRequestDto;
import com.java.emergir_api.domain.enumeration.ModalidadeAtendimentoEnum;
import com.java.emergir_api.domain.enumeration.PlanoPacienteEnum;
import com.java.emergir_api.domain.enumeration.SituacaoPacienteEnum;

import java.time.LocalDate;

public record PacienteRequestDto( String cpf,
                                  String nome,
                                  LocalDate dataNascimento,
                                  LocalDate dataInicio,
                                  ModalidadeAtendimentoEnum atendimento,
                                  PlanoPacienteEnum plano,
                                  SituacaoPacienteEnum situacao,
                                  FichaAnamneseRequestDto fichaAnamnese ){
}
