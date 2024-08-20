CREATE SCHEMA IF NOT EXISTS main;

CREATE TABLE IF NOT EXISTS main.user(
    id uuid PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    email VARCHAR(64) NOT NULL,
    password VARCHAR(24) NOT NULL,
    role VARCHAR(6) NOT NULL
);

CREATE TABLE IF NOT EXISTS main.task(
    id uuid PRIMARY KEY,
    title VARCHAR(64) NOT NULL,
    description TEXT NOT NULL,
    difficulty VARCHAR(6) CHECK (difficulty IN ('EASY', 'MEDIUM', 'HARD'))
);

CREATE TABLE IF NOT EXISTS main.solution(
    id uuid PRIMARY KEY,
    task_id INT NOT NULL,
    user_id INT NOT NULL,
    code TEXT NOT NULL,
    submission_date TIMESTAMP
);


