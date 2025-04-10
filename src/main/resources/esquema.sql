
-- Tabla de Estudiantes
CREATE TABLE Estudiantes (
                             id SERIAL PRIMARY KEY,
                             nombre VARCHAR(100),
                             apellido VARCHAR(100),
                             email VARCHAR(100) UNIQUE,
                             fecha_nacimiento DATE,
                             direccion TEXT
);

-- Tabla de Profesores
CREATE TABLE Profesores (
                            id SERIAL PRIMARY KEY,
                            nombre VARCHAR(100),
                            apellido VARCHAR(100),
                            email VARCHAR(100) UNIQUE,
                            especialidad VARCHAR(100)
);

-- Tabla de Asignaturas
CREATE TABLE Asignaturas (
                             id SERIAL PRIMARY KEY,
                             nombre VARCHAR(100),
                             descripcion TEXT
);

-- Tabla de Cursos
CREATE TABLE Cursos (
                        id SERIAL PRIMARY KEY,
                        nombre VARCHAR(100),
                        descripcion TEXT,
                        fecha_inicio DATE,
                        fecha_fin DATE,
                        profesor_id INTEGER REFERENCES Profesores(id),
                        asignatura_id INTEGER REFERENCES Asignaturas(id)
);

-- Tabla de Inscripciones
CREATE TABLE Inscripciones (
                               id SERIAL PRIMARY KEY,
                               estudiante_id INTEGER REFERENCES Estudiantes(id),
                               curso_id INTEGER REFERENCES Cursos(id),
                               fecha_inscripcion DATE
);

-- Tabla de Evaluaciones
CREATE TABLE Evaluaciones (
                              id SERIAL PRIMARY KEY,
                              curso_id INTEGER REFERENCES Cursos(id),
                              titulo VARCHAR(100),
                              descripcion TEXT,
                              fecha DATE
);

-- Evaluaciones de Estudiantes
CREATE TABLE EvaluacionesEstudiantes (
                                         id SERIAL PRIMARY KEY,
                                         evaluacion_id INTEGER REFERENCES Evaluaciones(id),
                                         estudiante_id INTEGER REFERENCES Estudiantes(id),
                                         nota NUMERIC(5,2)
);

-- Tabla de Tareas
CREATE TABLE Tareas (
                        id SERIAL PRIMARY KEY,
                        curso_id INTEGER REFERENCES Cursos(id),
                        titulo VARCHAR(100),
                        descripcion TEXT,
                        fecha_entrega DATE
);

-- Tabla de Asistencias
CREATE TABLE Asistencias (
                             id SERIAL PRIMARY KEY,
                             estudiante_id INTEGER REFERENCES Estudiantes(id),
                             curso_id INTEGER REFERENCES Cursos(id),
                             fecha DATE,
                             presente BOOLEAN
);

-- Recursos Multimedia
CREATE TABLE RecursosMultimedia (
                                    id SERIAL PRIMARY KEY,
                                    curso_id INTEGER REFERENCES Cursos(id),
                                    titulo VARCHAR(100),
                                    tipo VARCHAR(50),
                                    url TEXT
);

-- Tabla de Usuarios
CREATE TABLE Usuarios (
                          id SERIAL PRIMARY KEY,
                          username VARCHAR(50) UNIQUE,
                          password TEXT,
                          email VARCHAR(100) UNIQUE,
                          activo BOOLEAN DEFAULT TRUE
);

-- Tabla de Roles
CREATE TABLE Roles (
                       id SERIAL PRIMARY KEY,
                       nombre VARCHAR(50) UNIQUE,
                       descripcion TEXT
);

-- Tabla de Permisos
CREATE TABLE Permisos (
                          id SERIAL PRIMARY KEY,
                          nombre VARCHAR(50) UNIQUE,
                          descripcion TEXT
);

-- Asignación de Roles a Usuarios
CREATE TABLE AsignacionRoles (
                                 id SERIAL PRIMARY KEY,
                                 usuario_id INTEGER REFERENCES Usuarios(id),
                                 rol_id INTEGER REFERENCES Roles(id)
);

-- Relación entre Roles y Permisos
CREATE TABLE RolesPermisos (
                               id SERIAL PRIMARY KEY,
                               rol_id INTEGER REFERENCES Roles(id),
                               permiso_id INTEGER REFERENCES Permisos(id)
);

-- Horarios
CREATE TABLE Horarios (
                          id SERIAL PRIMARY KEY,
                          curso_id INTEGER REFERENCES Cursos(id),
                          dia_semana VARCHAR(20),
                          hora_inicio TIME,
                          hora_fin TIME
);

-- Aulas
CREATE TABLE Aulas (
                       id SERIAL PRIMARY KEY,
                       nombre VARCHAR(50),
                       capacidad INTEGER,
                       ubicacion TEXT
);

-- Relación Curso-Aula
CREATE TABLE CursoAula (
                           id SERIAL PRIMARY KEY,
                           curso_id INTEGER REFERENCES Cursos(id),
                           aula_id INTEGER REFERENCES Aulas(id)
);

-- Materiales
CREATE TABLE Materiales (
                            id SERIAL PRIMARY KEY,
                            curso_id INTEGER REFERENCES Cursos(id),
                            nombre VARCHAR(100),
                            tipo VARCHAR(50),
                            descripcion TEXT
);

-- Evaluaciones por estudiante por curso
CREATE TABLE EstudianteCursoEvaluaciones (
                                             id SERIAL PRIMARY KEY,
                                             estudiante_id INTEGER REFERENCES Estudiantes(id),
                                             curso_id INTEGER REFERENCES Cursos(id),
                                             evaluacion_id INTEGER REFERENCES Evaluaciones(id),
                                             nota NUMERIC(5,2)
);

-- Historial académico
CREATE TABLE HistorialAcademico (
                                    id SERIAL PRIMARY KEY,
                                    estudiante_id INTEGER REFERENCES Estudiantes(id),
                                    curso_id INTEGER REFERENCES Cursos(id),
                                    calificacion_final NUMERIC(5,2),
                                    aprobado BOOLEAN
);

-- Mensajes
CREATE TABLE Mensajes (
                          id SERIAL PRIMARY KEY,
                          emisor_id INTEGER REFERENCES Usuarios(id),
                          receptor_id INTEGER REFERENCES Usuarios(id),
                          contenido TEXT,
                          fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Objetivos del Curso
CREATE TABLE ObjetivosCurso (
                                id SERIAL PRIMARY KEY,
                                curso_id INTEGER REFERENCES Cursos(id),
                                descripcion TEXT
);

-- Eventos del Calendario
CREATE TABLE CalendarioEventos (
                                   id SERIAL PRIMARY KEY,
                                   curso_id INTEGER REFERENCES Cursos(id),
                                   titulo VARCHAR(100),
                                   descripcion TEXT,
                                   fecha_evento DATE
);

