-----------------------------------
-- Inserts
-----------------------------------

-- MAKE TEACHER
INSERT INTO teacher (discord_id, first_name, last_name, title) values(?, ?, ?, ?);

-- COURSE CREATE
INSERT INTO course (short_name, full_name) values (?, ?);

-- REGISTER STUDENT / FORCE REGISTER
INSERT INTO student (discord_id, first_name, last_name) VALUES (?, ?, ?);

-- START SESSION
INSERT INTO session (date_started, date_ended, txt_channel_id, voice_channel_id, register_id, max_attendance) VALUES (?, ?, ?, ?, ?, ?);

-----------------------------------
-- Relations
-----------------------------------

-- CREATE MEMBERSHIP - REGISTRATION IN SESSION
INSERT INTO membership_of_session (student_id, session_id, attendance) VALUES (?, ?, ?);

-- SESSION RELATION TO COURSE
INSERT INTO session_of_course (course_id, session_id) VALUES (?, ?);

-- STUDENT-COURSE RELATION - ENROLL STUDENT
INSERT INTO students_of_course (student_id, course_id) VALUES  (?, ?, ?);
