CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    texto VARCHAR NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at      TIMESTAMP DEFAULT NOW(),
    updated_at      TIMESTAMP,
    deleted_at      TIMESTAMP
)