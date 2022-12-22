CREATE SEQUENCE  IF NOT EXISTS role_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS Role (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_role PRIMARY KEY (id)
);

ALTER TABLE Role DROP CONSTRAINT IF EXISTS uc_role_name;
ALTER TABLE Role ADD CONSTRAINT uc_role_name UNIQUE (name);

CREATE TABLE IF NOT EXISTS users_roles (
  role_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL,
   CONSTRAINT pk_users_roles PRIMARY KEY (role_id, user_id)
);

ALTER TABLE users_roles DROP CONSTRAINT IF EXISTS fk_userol_on_role;
ALTER TABLE users_roles ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES Role (id);

ALTER TABLE users_roles DROP CONSTRAINT IF EXISTS fk_userol_on_user;
ALTER TABLE users_roles ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES user_table (id);






