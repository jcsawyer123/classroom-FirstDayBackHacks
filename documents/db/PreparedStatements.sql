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


-----------------------------------
-- GENERIC UPDATES
-----------------------------------

-- TEACHER
-----------------------------------

-- Update Discord ID
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

-- STUDENT
-----------------------------------

-- Update Discord ID
UPDATE student s
SET discord_id = (?)
WHERE s.student_id = (?);

-- Update FirstName
UPDATE student s
SET first_name = (?)
WHERE s.student_id = (?) OR s.discord_id = (?);

-- Update LastName
UPDATE student s
SET last_name = (?)
WHERE s.student_id = (?) OR s.discord_id = (?);

-- COURSE
-----------------------------------

-- Update Short Name
UPDATE course c
SET short_name = (?)
WHERE c.course_id = (?);

-- Update Full Name
UPDATE course c
SET full_name = (?)
WHERE c.course_id = (?) OR c.short_name = (?);

-- Change OPT_SELF_ENROLL
UPDATE course c
SET opt_self_enroll = (?)
WHERE c.course_id = (?) OR c.short_name = (?);

-- SESSION
-----------------------------------

-- Update Start Date - Shouldn't use
UPDATE session s
SET date_started = (?)
WHERE s.session_id = (?);

-- Add End Date
UPDATE session s
SET date_ended = (?)
WHERE s.session_id = (?) && s.date_ended = null;

-- Update End Date - Shouldn't use
UPDATE session s
SET date_ended = (?)
WHERE s.session_id = (?);

-- Update Text Channel ID
UPDATE session s
SET txt_channel_id = (?)
WHERE s.session_id = (?);

-- Update Voice Channel ID
UPDATE session s
SET voice_channel_id = (?)
WHERE s.session_id = (?);

-- Update Role ID
UPDATE session s
SET role_id = (?)
WHERE s.session_id = (?);

-- Update Register ID
UPDATE session s
SET register_id = (?)
WHERE s.session_id = (?);

-- Update Max Attendance
UPDATE session s
SET max_attendance = (?)
WHERE s.session_id = (?);



-----------------------------------
-- SELECTORS (Getters)
-----------------------------------

-- TEACHER
-----------------------------------
-- Get ID From Discord ID
SELECT teacher_id
FROM teacher
WHERE discord_id = (?);

-- Get Discord ID From ID
SELECT discord_id
FROM teacher
WHERE teacher_id = (?);

-- STUDENT
-----------------------------------
-- Get ID From Discord ID
SELECT student_id
FROM student
WHERE discord_id = (?);

-- Get Discord ID From ID
SELECT discord_id
FROM student
WHERE student_id = (?);