-----------------------------------
-- Inserts
-----------------------------------

-- MAKE TEACHER
INSERT INTO teacher (discord_id, first_name, last_name, title) values(?, ?, ?, ?);

-- COURSE CREATE
INSERT INTO course (short_name, full_name) values (?, ?);

-- REGISTER STUDENT / FORCE REGISTER
INSERT INTO student (discord_id, first_name, last_name) VALUES (?, ?, ?);