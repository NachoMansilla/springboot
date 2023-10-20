package med.voll.api.medicos;

import med.voll.api.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id, String nombre, String email, String telefono, String especialidad, DatosDireccion datosDireccion) {
}
