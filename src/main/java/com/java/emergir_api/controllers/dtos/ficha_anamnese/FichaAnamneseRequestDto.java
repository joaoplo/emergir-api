package com.java.emergir_api.controllers.dtos.ficha_anamnese;

import java.time.LocalDate;

public record FichaAnamneseRequestDto( String descricao,
                                       LocalDate dataRegistro ){
}
