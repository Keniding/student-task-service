-- Crear la base de datos si no existe
SELECT 'CREATE DATABASE taskdb'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskdb')\gexec

-- Conectar a la base de datos
    \c taskdb

-- Crear tabla de tareas (opcional, JPA lo puede hacer automáticamente)
CREATE TABLE IF NOT EXISTS tasks (
                                     id BIGSERIAL PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
                                     description TEXT,
                                     category VARCHAR(50) NOT NULL,
                                     status VARCHAR(50) NOT NULL,
                                     due_date VARCHAR(50) NOT NULL,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertar datos de ejemplo
INSERT INTO tasks (title, description, category, status, due_date) VALUES
                                                                       ('Estudiar Cálculo Diferencial', 'Repasar límites y derivadas para el examen', 'MATHEMATICS', 'PENDING', '2026-01-15'),
                                                                       ('Proyecto de Programación', 'Completar el sistema de gestión de tareas', 'PROGRAMMING', 'IN_PROGRESS', '2026-01-20'),
                                                                       ('Leer Capítulo 5 de Física', 'Mecánica cuántica básica', 'PHYSICS', 'PENDING', '2026-01-12'),
                                                                       ('Ensayo de Literatura', 'Análisis de Don Quijote de la Mancha', 'LITERATURE', 'COMPLETED', '2026-01-10');

-- Índices para mejorar el rendimiento
CREATE INDEX IF NOT EXISTS idx_tasks_category ON tasks(category);
CREATE INDEX IF NOT EXISTS idx_tasks_status ON tasks(status);
