CREATE SCHEMA demo;

CREATE TABLE IF NOT EXISTS demo.employees (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  department_id INT
);

CREATE TABLE IF NOT EXISTS demo.departments (
  id SERIAL PRIMARY KEY,
  department_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS demo.projects (
  id SERIAL PRIMARY KEY,
  project_name VARCHAR(100) NOT NULL,
  department_id INT
);

CREATE TABLE IF NOT EXISTS demo.tasks (
  id SERIAL PRIMARY KEY,
  project_id INT,
  task_name VARCHAR(100) NOT NULL,
  assigned_to INT
);

INSERT INTO demo.departments (department_name) VALUES ('Sales'), ('IT'), ('HR');

INSERT INTO demo.employees (name, department_id) VALUES
  ('Alice', 1),
  ('Bob', 2),
  ('Charlie', NULL);

INSERT INTO demo.projects (project_name, department_id) VALUES
  ('Website Revamp', 2),
  ('Recruitment', 3),
  ('Sales Boost', 1),
  ('New Microservice', NULL),
  ('New Ad Campaign', 4);

INSERT INTO demo.tasks (project_id, task_name, assigned_to) VALUES
  (1, 'Design Mockup', 1),
  (1, 'Frontend Dev', 2)
  (2, 'Post Job Ad', 5),
  (3, 'Client Meeting', NULL);