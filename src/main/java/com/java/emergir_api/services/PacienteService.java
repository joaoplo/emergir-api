package com.java.emergir_api.services;

import com.java.emergir_api.controllers.dtos.ficha_anamnese.FichaAnamneseResponseDto;
import com.java.emergir_api.controllers.dtos.paciente.PacienteRequestDto;
import com.java.emergir_api.controllers.dtos.paciente.PacienteResponseDto;
import com.java.emergir_api.domain.entities.PacienteEntity;
import com.java.emergir_api.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PacienteService{

    private final ModelMapper        modelMapper;
    private       PacienteRepository pacienteRepository;
    private       FichaAnamneseService fichaAnamneseService;

    public PacienteResponseDto salvarPaciente( PacienteRequestDto pacienteRequestDto ) {
        PacienteEntity pacienteEntity = modelMapper.map( pacienteRequestDto, PacienteEntity.class );

        PacienteEntity pacienteSalvo = pacienteRepository.save( pacienteEntity );

        FichaAnamneseResponseDto fichaAnamneseResponseDto = fichaAnamneseService.salvarFicha( pacienteEntity, pacienteRequestDto );

        return new PacienteResponseDto( pacienteSalvo.getId(), pacienteSalvo.getCpf(), pacienteSalvo.getNome(), pacienteSalvo.getDataNascimento(),
                                        pacienteSalvo.getDataInicio(), pacienteSalvo.getAtendimento(), pacienteSalvo.getPlano(), pacienteSalvo.getSituacao(),
                                        fichaAnamneseResponseDto );
    }
}
