CREATE TABLE IF NOT EXISTS "permission" (
                              id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                              alias VARCHAR(50) NOT NULL,
                              code VARCHAR(50) NOT NULL UNIQUE,
                              create_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                              update_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
