package com.java.emergir_api.services;

import com.java.emergir_api.commons.exceptions.NegocioException;
import com.java.emergir_api.controllers.dtos.ficha_anamnese.FichaAnamneseResponseDto;
import com.java.emergir_api.controllers.dtos.paciente.PacienteRequestDto;
import com.java.emergir_api.controllers.dtos.paciente.PacienteResponseDto;
import com.java.emergir_api.domain.entities.PacienteEntity;
import com.java.emergir_api.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                                        pacienteSalvo.getDataInicio(), pacienteSalvo.getDataTermino(), pacienteSalvo.getAtendimento(),
                                        pacienteSalvo.getPlano(), pacienteSalvo.getSituacao(), fichaAnamneseResponseDto );
    }

    public PacienteResponseDto consultarPaciente( Long id ) {
        PacienteEntity pacienteEntity = pacienteRepository.findById( id )
                .orElseThrow( () -> new NegocioException( "Paciente não encontrado" ) );

        return new PacienteResponseDto( pacienteEntity.getId(), pacienteEntity.getCpf(), pacienteEntity.getNome(), pacienteEntity.getDataNascimento(),
                                        pacienteEntity.getDataInicio(), pacienteEntity.getDataTermino(), pacienteEntity.getAtendimento(),
                                        pacienteEntity.getPlano(), pacienteEntity.getSituacao(),
                                        new FichaAnamneseResponseDto( pacienteEntity.getFichaAnamnese().getId(),
                                                                      pacienteEntity.getFichaAnamnese().getDescricao(),
                                                                      pacienteEntity.getFichaAnamnese().getDataRegistro(),
                                                                      pacienteEntity.getFichaAnamnese().getIdPaciente() ) );
    }

    public List<PacienteResponseDto> listarPacientes() {
        return pacienteRepository.findAll().stream()
                                 .map( pacienteEntity -> new PacienteResponseDto(
                                         pacienteEntity.getId(),
                                         pacienteEntity.getCpf(),
                                         pacienteEntity.getNome(),
                                         pacienteEntity.getDataNascimento(),
                                         pacienteEntity.getDataInicio(),
                                         pacienteEntity.getDataTermino(),
                                         pacienteEntity.getAtendimento(),
                                         pacienteEntity.getPlano(),
                                         pacienteEntity.getSituacao(),
                                        new FichaAnamneseResponseDto( pacienteEntity.getFichaAnamnese().getId(),
                                                                      pacienteEntity.getFichaAnamnese().getDescricao(),
                                                                      pacienteEntity.getFichaAnamnese().getDataRegistro(),
                                                                      pacienteEntity.getFichaAnamnese().getIdPaciente() )
                                 ) )
                                .collect( Collectors.toList() );
    }
}
