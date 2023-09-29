package med.voll.api.medicos;

import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedicos(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosDireccion direccion
) {
}
