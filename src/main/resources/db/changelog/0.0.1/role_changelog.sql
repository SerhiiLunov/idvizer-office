CREATE TABLE IF NOT EXISTS "role" (
                        id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                        alias VARCHAR(50) NOT NULL, -- alias (user/admin/super_admin)
                        code VARCHAR(50) NOT NULL UNIQUE,
                        create_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                        update_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- DROP TABLE "role" CASCADE ;
-- DELETE FROM DATABASECHANGELOG WHERE filename = 'db/changelog/0.0.1/role_changelog.sql';