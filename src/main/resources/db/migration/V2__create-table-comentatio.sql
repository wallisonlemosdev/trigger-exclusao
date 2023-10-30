CREATE TABLE comentarios (
    id SERIAL PRIMARY KEY,
    texto VARCHAR NOT NULL,
    post_id INTEGER NOT NULL REFERENCES posts,
    deleted BOOLEAN DEFAULT FALSE,
    created_at      TIMESTAMP DEFAULT NOW(),
    updated_at      TIMESTAMP,
    deleted_at      TIMESTAMP
)