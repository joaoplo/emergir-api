package com.java.emergir_api.services;

import com.java.emergir_api.controllers.dtos.ficha_anamnese.FichaAnamneseResponseDto;
import com.java.emergir_api.controllers.dtos.paciente.PacienteRequestDto;
import com.java.emergir_api.domain.entities.FichaAnamneseEntity;
import com.java.emergir_api.domain.entities.PacienteEntity;
import com.java.emergir_api.repositories.FichaAnamneseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FichaAnamneseService{

    private FichaAnamneseRepository fichaAnamneseRepository;

    public FichaAnamneseResponseDto salvarFicha( PacienteEntity pacienteEntity, PacienteRequestDto pacienteRequestDto ) {
        FichaAnamneseEntity fichaAnamneseEntity = new FichaAnamneseEntity();

        fichaAnamneseEntity.setDescricao( pacienteRequestDto.fichaAnamnese().descricao() );
        fichaAnamneseEntity.setDataRegistro( pacienteRequestDto.fichaAnamnese().dataRegistro() );
        fichaAnamneseEntity.setPaciente( pacienteEntity );
        fichaAnamneseEntity.setIdPaciente( pacienteEntity.getId() );

        FichaAnamneseEntity fichaAnamneseSalva = fichaAnamneseRepository.save( fichaAnamneseEntity );

        return new FichaAnamneseResponseDto( fichaAnamneseSalva.getId(), fichaAnamneseSalva.getDescricao(), fichaAnamneseSalva.getDataRegistro(),
                                             fichaAnamneseSalva.getIdPaciente() );
    }
}
