package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medicos.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository repository;
    public void validar(DatosAgendarConsulta datos) {
        if(datos.idMedico() == null) {
            return;
        }

        var medico = repository.findActivoById(datos.idMedico());

        if(!medico) {
            throw new ValidationException("No se puede agendar consulta con medicos inactivos");
        }

    }

}
