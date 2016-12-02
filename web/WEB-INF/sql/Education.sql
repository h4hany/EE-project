INSERT INTO `INSTRUCTOR` (`ID`, `EMAIL`, `FNAME`, `LNAME`, `PASSWORD`) VALUES (0, 'inst@inst.com', 'instFname', 'instLname', '123456');
INSERT INTO `STUDENT` (`ID`, `AGE`, `EMAIL`, `FILE`, `FNAME`, `GENDER`, `INTEREST`, `LNAME`, `PASSWORD`) VALUES(0, 20, 'stud@stud.com', 'file1.jpg', 'fname', 'Male', '[Interest1]', 'lname', '123456');
INSERT INTO `COURSE` (`ID`, `COURSENAME`, `instractor_fk`) VALUES(0, 'Course', 0);
INSERT INTO `students_courses` (`student_fk`, `course_fk`) VALUES(0, 0);