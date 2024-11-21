CREATE TABLE IF NOT EXISTS "package" (
                           id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                           create_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                           update_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);