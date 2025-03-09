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

import java.util.List;

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

    @GetMapping( "/{idPaciente}" )
    public ResponseEntity<Response<PacienteResponseDto>> consultarPaciente( @PathVariable Long idPaciente ) {
        return ResponseEntity.ok( Response.<PacienteResponseDto>builder()
                                          .code( 0 )
                                          .success( Boolean.TRUE )
                                          .message( "OK" )
                                          .data( this.pacienteService.consultarPaciente( idPaciente ) )
                                          .build() );
    }

    @GetMapping( "/" )
    public ResponseEntity<Response<List<PacienteResponseDto>>> listarPacientes() {
        List<PacienteResponseDto> pacienteResponseDtoList = pacienteService.listarPacientes();
        return pacienteResponseDtoList.isEmpty() ? new ResponseEntity<>(
                Response.<List<PacienteResponseDto>>builder()
                        .build(), HttpStatus.NO_CONTENT ) : ResponseEntity.ok( Response.<List<PacienteResponseDto>>builder()
                                                                                       .code( 0 )
                                                                                       .success( Boolean.TRUE )
                                                                                       .message( "OK" )
                                                                                       .data( pacienteResponseDtoList )
                                                                                       .build() );
    }
}
