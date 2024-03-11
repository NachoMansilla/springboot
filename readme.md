# API REST para Gestión de Médicos y Pacientes

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de médicos y pacientes. Ofrece endpoints para el registro, listado, actualización y eliminación de médicos y pacientes, siguiendo los principios de las APIs RESTful.

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