CREATE TABLE task (
                         id BIGSERIAL PRIMARY KEY,
                         title VARCHAR(100) NOT NULL,
                         description TEXT,
                         completed BOOLEAN DEFAULT FALSE,
                         create_date DATE NOT NULL
);