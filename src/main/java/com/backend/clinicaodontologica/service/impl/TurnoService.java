package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.OdontologoTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.PacienteTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.entity.Turno;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.repository.TurnoRepository;
import com.backend.clinicaodontologica.service.ITurnoService;
import com.backend.clinicaodontologica.utils.JsonPrinter;
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
        Turno turnoAPersistir = new Turno();

        PacienteSalidaDto pacienteSalidaDto = pacienteService.buscarPacientePorId(turnoEntrada.getPaciente());
        if(pacienteSalidaDto == null) {
            LOGGER.error("No se ha encontrado el paciente con id {}", turnoEntrada.getPaciente());
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id " + turnoEntrada.getPaciente());
        }

        turnoAPersistir.setPaciente(modelMapper.map(pacienteSalidaDto, Paciente.class));

        OdontologoSalidaDto odontologoSalidaDto = odontologoService.buscarOdontologoPorId(turnoEntrada.getOdontologo());
        if(odontologoSalidaDto == null) {
            LOGGER.error("No se ha encontrado el odontologo con id {}", turnoEntrada.getPaciente());
            throw new ResourceNotFoundException("No se ha encontrado el odontologo con id " + turnoEntrada.getPaciente());
        }

        turnoAPersistir.setOdontologo(modelMapper.map(odontologoSalidaDto, Odontologo.class));
        turnoAPersistir.setFechaYHora(turnoEntrada.getFechaYHora());
        Turno turno = turnoRepository.save(turnoAPersistir);

        return modelMapper.map(turno, TurnoSalidaDto.class);

    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        return turnoRepository
                .findAll()
                .stream().map(turno -> {

                    TurnoSalidaDto turnoSalidaDto = modelMapper.map(turno, TurnoSalidaDto.class);
                    turnoSalidaDto.setOdontologoTurnoSalidaDto(modelMapper.map(turno.getOdontologo(), OdontologoTurnoSalidaDto.class));
                    turnoSalidaDto.setPacienteTurnoSalidaDto(modelMapper.map(turno.getPaciente(), PacienteTurnoSalidaDto.class));
                    return turnoSalidaDto;

                })
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

        turnoRecibido.setOdontologo(modelMapper.map(odontologoService.buscarOdontologoPorId(turnoModificacionEntradaDto.getOdontologo()), Odontologo.class));
        turnoRecibido.setPaciente(modelMapper.map(pacienteService.buscarPacientePorId(turnoModificacionEntradaDto.getPaciente()), Paciente.class));

        if(turnoRepository.findById(turnoModificacionEntradaDto.getId()).isEmpty()) {
            LOGGER.error("No fue posible actualizar los datos ya que el turno no se encuentra registrado");
            throw new ResourceNotFoundException("No fue posible actualizar los datos ya que el turno no se encuentra registrado con ID  " + turnoModificacionEntradaDto.getId());
        }
        return modelMapper.map(turnoRepository.save(turnoRecibido), TurnoSalidaDto.class);
    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {
        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);
        TurnoSalidaDto turnoEncontrado = null;

        if (turnoBuscado != null) {

            turnoEncontrado = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);
            turnoEncontrado.setOdontologoTurnoSalidaDto(modelMapper.map(turnoBuscado.getOdontologo(), OdontologoTurnoSalidaDto.class));
            turnoEncontrado.setPacienteTurnoSalidaDto(modelMapper.map(turnoBuscado.getPaciente(), PacienteTurnoSalidaDto.class));
            LOGGER.info("Turno encontrado: {}", JsonPrinter.toString(turnoEncontrado));


        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return turnoEncontrado;
    }
}
