package med.voll.api.domain.pacientes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private boolean activo;
    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPacientes datosRegistroPacientes) {
        this.activo = true;
        this.nombre = datosRegistroPacientes.nombre();
        this.email = datosRegistroPacientes.email();
        this.telefono = datosRegistroPacientes.telefono();
        this.documento = datosRegistroPacientes.documento();
        this.direccion = new Direccion(datosRegistroPacientes.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if (datosActualizarPaciente.nombre() != null) {
            this.nombre = datosActualizarPaciente.nombre();
        }
        if (datosActualizarPaciente.documento() != null) {
            this.documento = datosActualizarPaciente.documento();
        }
        if (datosActualizarPaciente.email() != null) {
            this.email = datosActualizarPaciente.email();
        }
        if (datosActualizarPaciente.direccion() != null) {
            this.direccion = direccion.actualizarDatos(datosActualizarPaciente.direccion());
        }
    }

    public void desactivarPaciente() {
        this.activo = false;
    }
    public void activarPaciente() {
        this.activo = true;
    }

}
