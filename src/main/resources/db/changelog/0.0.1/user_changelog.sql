CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS "user" (
                      id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                      create_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                      update_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      phone VARCHAR(15) NOT NULL UNIQUE
);

-- DROP TABLE "user" CASCADE ;
-- DELETE FROM DATABASECHANGELOG WHERE filename = 'db/changelog/0.0.1/user_changelog.sql';