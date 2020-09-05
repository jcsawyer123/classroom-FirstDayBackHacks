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

-- TEACHER-COURSE RELATION - ADD TEACHER
INSERT INTO teachers_of_course (teacher_id, course_id) VALUES (?, ?);

-----------------------------------
-- SPECIFIC UPDATES
-----------------------------------

-- CHANGE STATE OF STUDENT-COURSE RELATION - UNENROLL/REENROLL
UPDATE students_of_course s
SET active = (?)
WHERE s.student_id = (?);

-- CHANGE STATE(ATTENDANCE) OF STUDENT-SESSION RELATION - SIGN-IN/SIGN-OUT
UPDATE membership_of_session r
SET attendance = (?)
WHERE r.student_id = (?);

-- ADD DATE-ENDED
UPDATE session s
SET date_ended = (?)
WHERE s.session_id = (?) && s.date_ended = null;

-----------------------------------
-- GENERIC UPDATES
-----------------------------------

-- TEACHER
UPDATE teacher t
SET discord_id = (?)
WHERE t.teacher_id = (?);

-- Update FirstName
UPDATE teacher t
SET first_name = (?)
WHERE t.teacher_id = (?) OR discord_id = (?);

-- Update LastName
UPDATE teacher t
SET last_name = (?)
WHERE t.teacher_id = (?) OR discord_id = (?);

-- Update Title
UPDATE teacher t
SET title = (?)
WHERE t.teacher_id = (?) OR discord_id = (?);