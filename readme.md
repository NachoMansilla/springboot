# API REST para Gestión de Médicos y Pacientes

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de médicos y pacientes. Ofrece endpoints para el registro, listado, actualización y eliminación de médicos y pacientes, siguiendo los principios de las APIs RESTful.


## Autenticación

El sistema utiliza **JWT (JSON Web Tokens)** para manejar la autenticación de los usuarios. Esto asegura que las operaciones realizadas en la API sean por usuarios autorizados.

### Login
- **POST** `/login` - Este endpoint permite a los usuarios autenticarse en el sistema. Al proporcionar credenciales válidas, el sistema responde con un `jwt_token` generado por **Auth0**, que debe ser utilizado para las subsiguientes peticiones a la API que requieran autenticación.
## Especificaciones de Información Requerida

### Para Médicos
Al registrar un médico, se deben proporcionar los siguientes datos:
- **Nombre**: Nombre completo del médico.
- **Correo Electrónico**: Dirección de correo válida del médico.
- **Teléfono**: Número de contacto del médico.
- **Documento**: Número de identificación o documento oficial del médico.
- **Especialidad**: Área de especialización médica, que puede ser Ortopedia, Cardiología, Ginecología o Dermatología.
- **Dirección Completa**: Incluye calle, número (opcional), complemento (opcional), barrio, ciudad, estado y código postal.

### Para Pacientes
Al registrar un paciente, se deben proporcionar los siguientes datos:
- **Nombre**: Nombre completo del paciente.
- **Correo Electrónico**: Dirección de correo válida del paciente.
- **Teléfono**: Número de contacto del paciente.
- **Documento**: Número de identificación o documento oficial del paciente.
- **Dirección Completa**: Incluye calle, número, complemento (opcional), barrio, ciudad y código postal.

### Validaciones
- Todos los campos son obligatorios, excepto el número y el complemento en la dirección.
- No se permite la modificación del correo electrónico, documento o especialidad una vez registrado el médico.
- La eliminación de registros no borra los datos, sino que cambia el estado a "inactivo".


## Características

### Registro de Médicos
- **POST** `/medicos` - Registra un nuevo médico con la información requerida.

### Listado de Médicos
- **GET** `/medicos` - Muestra una lista paginada y ordenada de médicos registrados.

### Actualización de Médicos
- **PUT** `/medicos/{id}` - Actualiza la información de un médico existente.

### Eliminación de Médicos
- **DELETE** `/medicos/{id}` - Marca a un médico como inactivo en el sistema.

### Registro de Pacientes
- **POST** `/pacientes` - Registra un nuevo paciente con la información requerida.

### Listado de Pacientes
- **GET** `/pacientes` - Muestra una lista paginada y ordenada de pacientes registrados.

### Actualización de Pacientes
- **PUT** `/pacientes/{id}` - Actualiza la información de un paciente existente.

### Eliminación de Pacientes
- **DELETE** `/pacientes/{id}` - Marca a un paciente como inactivo en el sistema.

## Reglas de Negocio
- No se permite la modificación del correo electrónico, documento o especialidad del médico.
- La eliminación de un médico o paciente no borra sus datos, sino que los marca como "inactivo".

## Tecnologías Utilizadas
- Spring Boot
- Maven
- JPA/Hibernate
- MySQL

## Instalación y Ejecución
Instrucciones para la instalación y ejecución del proyecto.