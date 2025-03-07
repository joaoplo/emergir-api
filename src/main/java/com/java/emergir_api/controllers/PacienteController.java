package com.java.emergir_api.controllers;

import com.java.emergir_api.commons.support.Response;
import com.java.emergir_api.controllers.dtos.paciente.PacienteRequestDto;
import com.java.emergir_api.controllers.dtos.paciente.PacienteResponseDto;
import com.java.emergir_api.services.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/pacientes")
@Tag( name = "Pacientes" )
public class PacienteController{

    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Response<PacienteResponseDto>> salvarPaciente( @RequestBody PacienteRequestDto pacienteRequestDto ) {
        return ResponseEntity.status( HttpStatus.CREATED )
                             .body( Response.<PacienteResponseDto>builder()
                                            .code( 0 )
                                            .success( Boolean.TRUE )
                                            .message( "OK" )
                                            .data( this.pacienteService.salvarPaciente( pacienteRequestDto ) )
                                            .build() );
    }
}
