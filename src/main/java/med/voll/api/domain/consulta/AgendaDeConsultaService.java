package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validaciones.ValidadorDeCancelamientos;
import med.voll.api.domain.consulta.validaciones.ValidadorDeConsultas;
import med.voll.api.domain.medicos.Medico;
import med.voll.api.domain.medicos.MedicoRepository;
import med.voll.api.domain.pacientes.Paciente;
import med.voll.api.domain.pacientes.PacienteRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    List<ValidadorDeConsultas> validadores;

    @Autowired
    List<ValidadorDeCancelamientos> validadoresDeCancelamiento;

    public DatosDetalleConsulta agendar(DatosAgendarConsulta datos) {

        if(!pacienteRepository.findById(datos.idPaciente()).isPresent()) {
            throw new ValidacionDeIntegridad("Este id para el paciente no fue encontrado");
        }

        if(datos.idMedico()!= null && !medicoRepository.existsById(datos.idMedico())) {
            throw new ValidacionDeIntegridad("Este id para el medico no fue encontrado");
        }

        validadores.forEach(v-> v.validar(datos));

        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        //var medico = medicoRepository.findById(datos.idMedico()).get();
        var medico = seleccionarMedico(datos);

        var consulta = new Consulta(medico, paciente, datos.fecha());
        consultaRepository.save(consulta);
        return new DatosDetalleConsulta(consulta);
    }

    public void cancelar(DatosCancelamientoConsulta datos) {
        if(!consultaRepository.existsById(datos.id())){
            throw new ValidacionDeIntegridad("Este id de consulta no fue encontrado");
        }

        validadoresDeCancelamiento.forEach(v-> v.validar(datos));

        var consulta = consultaRepository.getReferenceById(datos.id());
        consulta.cancelar(datos.motivoDeCancelacion());



    }

    private Medico seleccionarMedico(DatosAgendarConsulta datos) {
        if(datos.idMedico() != null) {
            return medicoRepository.getReferenceById(datos.id());
        }
        if(datos.especialidad() == null) {
            throw new ValidacionDeIntegridad("Debe seleccionar una especialidad para el medico");
        }

        return medicoRepository.seleccionarMedicoAleatoriamente(datos.especialidad(), datos.fecha());
    }

}
