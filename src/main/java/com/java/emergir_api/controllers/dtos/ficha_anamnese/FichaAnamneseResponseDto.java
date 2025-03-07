package com.java.emergir_api.controllers.dtos.ficha_anamnese;

import java.time.LocalDate;

public record FichaAnamneseResponseDto( Long id,
                                        String descricao,
                                        LocalDate dataRegistro,
                                        Long idPaciente ){
}
