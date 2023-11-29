package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.entity.Turno;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.repository.TurnoRepository;
import com.backend.clinicaodontologica.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TurnoService implements ITurnoService {

    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;
    private final PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntrada) throws ResourceNotFoundException {

        if(pacienteService.buscarPacientePorId(turnoEntrada.getPaciente()) == null) {
            LOGGER.error("No se ha encontrado el paciente con id {}", turnoEntrada.getPaciente());
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id " + turnoEntrada.getPaciente());
        }

        if(odontologoService.buscarOdontologoPorId(turnoEntrada.getOdontologo()) == null) {
            LOGGER.error("No se ha encontrado el odontologo con id {}", turnoEntrada.getPaciente());
            throw new ResourceNotFoundException("No se ha encontrado el odontologo con id " + turnoEntrada.getPaciente());
        }

        Turno turno = turnoRepository.save(modelMapper.map(turnoEntrada, Turno.class));
        return modelMapper.map(turno, TurnoSalidaDto.class);

    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        return turnoRepository
                .findAll()
                .stream().map(o -> modelMapper.map(o, TurnoSalidaDto.class))
                .toList();
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if(turnoRepository.findById(id).isEmpty()) {
            LOGGER.error("No se ha encontrado el turno con id " + id);
            throw new ResourceNotFoundException("No se ha encontrado el turno con id " + id);
        }
        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turnoModificacionEntradaDto) throws ResourceNotFoundException {
        Turno turnoRecibido = modelMapper.map(turnoModificacionEntradaDto, Turno.class);
        if(turnoRepository.findById(turnoModificacionEntradaDto.getId()).isEmpty()) {
            LOGGER.error("No fue posible actualizar los datos ya que el turno no se encuentra registrado");
            throw new ResourceNotFoundException("No fue posible actualizar los datos ya que el turno no se encuentra registrado con ID  " + turnoModificacionEntradaDto.getId());
        }
        return modelMapper.map(turnoRepository.save(turnoRecibido), TurnoSalidaDto.class);
    }
}
