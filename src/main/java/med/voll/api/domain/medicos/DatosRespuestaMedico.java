package med.voll.api.domain.medicos;

import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id, String nombre, String email, String telefono, String especialidad, DatosDireccion datosDireccion) {
}
