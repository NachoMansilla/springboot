package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAnticipacionCancelamiento implements ValidadorDeCancelamientos {

    @Autowired
    private ConsultaRepository repository;
    public void validar(DatosCancelamientoConsulta datos) {
        var consulta = repository.getReferenceById(datos.id());
        var horaDeConsulta = consulta.getFecha();
        var horaActual = LocalDateTime.now();
        var diferenciaDe24hrs = Duration.between(horaActual, horaDeConsulta).toHours() < 24;
        if(diferenciaDe24hrs) {
            throw new ValidationException("Las consultas se deben cancelar con 24hrs de anticipacion");
        }
    }
}
