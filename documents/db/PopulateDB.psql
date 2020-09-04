---------------------------------------------
-- Create Teachers
---------------------------------------------
INSERT INTO teacher (discord_id, first_name, last_name, title) VALUES (187979032904728576, 'Oliver', 'Graham', 'Mr');
INSERT INTO teacher (discord_id, first_name, last_name, title) VALUES (215896259356000266, 'Joshua', 'Sawyer', 'Mr');

---------------------------------------------
-- Enroll Students
---------------------------------------------
INSERT INTO student (discord_id, first_name, last_name) VALUES (128557129912156161, 'Tom', 'Bailey');
INSERT INTO student (discord_id, first_name, last_name) VALUES (184941413245517824, 'Cameron', 'Jones');
INSERT INTO student (discord_id, first_name, last_name) VALUES (514363906940993561, 'Megi', 'Braholli');
INSERT INTO student (discord_id, first_name, last_name) VALUES (332083833912426497, 'Isaac', 'Scarisbrick');

---------------------------------------------
-- Create Course
---------------------------------------------
INSERT INTO course (short_name, full_name, opt_self_enroll) VALUES ('D101', 'Introduction to Discord', false);
INSERT INTO course (short_name, full_name, opt_self_enroll) VALUES ('CS420', 'Getting Through Coursework', true);

---------------------------------------------
-- Add Teachers to Courses
---------------------------------------------
-- Add Joshua to D101
INSERT INTO teachers_of_course (teacher_id, course_id)
VALUES ((SELECT teacher_id FROM teacher WHERE discord_id = 215896259356000266),
        (SELECT course_id FROM course WHERE short_name = 'D101'));
-- Add Oliver to CS420
INSERT INTO teachers_of_course (teacher_id, course_id)
VALUES ((SELECT teacher_id FROM teacher WHERE discord_id = 187979032904728576),
        (SELECT course_id FROM course WHERE short_name = 'CS420'));

---------------------------------------------
-- Add Students to Course D101
---------------------------------------------
-- Add Tom to D101
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 128557129912156161),
        (SELECT course_id FROM course WHERE short_name = 'D101'));
-- Add Cameron to D101
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 184941413245517824),
        (SELECT course_id FROM course WHERE short_name = 'D101'));
-- Add Megi to D101
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 514363906940993561),
        (SELECT course_id FROM course WHERE short_name = 'D101'));
-- Add Isaac to D101
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 128557129912156161),
        (SELECT course_id FROM course WHERE short_name = 'D101'));

---------------------------------------------
-- Add Students to Course CS420
---------------------------------------------
-- Add Tom to CS420
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 128557129912156161),
        (SELECT course_id FROM course WHERE short_name = 'CS420'));
-- Add Cameron to CS420
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 184941413245517824),
        (SELECT course_id FROM course WHERE short_name = 'CS420'));
-- Add Megi to CS420
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 514363906940993561),
        (SELECT course_id FROM course WHERE short_name = 'CS420'));
-- Add Isaac to CS420
INSERT INTO students_of_course(student_id, course_id)
VALUES ((SELECT student_id FROM student WHERE discord_id = 128557129912156161),
        (SELECT course_id FROM course WHERE short_name = 'CS420'));
