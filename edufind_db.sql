CREATE DATABASE edufind;

USE edufind;

CREATE TABLE admin(
 adminID VARCHAR(20) NOT NULL,
 adminPassword VARCHAR(15) NOT NULL
);

INSERT INTO `admin` (`adminID`, `adminPassword`) VALUES
('admin@gmail.com', 'admin@123');

CREATE TABLE admissionrequest(
 requestID INT NOT NULL,
 userID VARCHAR(20) DEFAULT NULL,
 courseID INT DEFAULT NULL,
 instituteID VARCHAR(20) NOT NULL,
 requestDate DATE DEFAULT NULL,
 status TINYINT(1) DEFAULT NULL,
 rejected TINYINT(1) NOT NULL
);

CREATE TABLE `course` (
  `courseID` INT NOT NULL,
  `courseName` VARCHAR(20) NOT NULL,
  `price` INT NOT NULL,
  `seats` INT NOT NULL,
  `filledseats` INT NOT NULL DEFAULT '0'
);

CREATE TABLE `course_institute` (
  `courseID` INT NOT NULL,
  `instituteID` VARCHAR(20) NOT NULL
);

CREATE TABLE `faculty` (
  `facultyID` INT NOT NULL,
  `facultyName` VARCHAR(20) NOT NULL,
  `instituteID` VARCHAR(20) NOT NULL,
  `courseID` INT NOT NULL
);

CREATE TABLE `feedback` (
  `feedbackID` INT NOT NULL,
  `userID` VARCHAR(20) NOT NULL,
  `instituteID` VARCHAR(20) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `feedbackDate` DATE NOT NULL
);

CREATE TABLE `institute` (
  `instituteID` VARCHAR(20) NOT NULL,
  `instituteName` VARCHAR(50) NOT NULL,
  `institutePassword` VARCHAR(15) NOT NULL,
  `startDate` DATE NOT NULL,
  `address` VARCHAR(100) NOT NULL
);

CREATE TABLE `student` (
  `userID` VARCHAR(20) NOT NULL,
  `emailID` VARCHAR(20) NOT NULL,
  `studentName` VARCHAR(40) NOT NULL,
  `qualification` VARCHAR(20) NOT NULL,
  `studentPassword` VARCHAR(15) NOT NULL,
  `number` VARCHAR(13) NOT NULL,
  `address` VARCHAR(100) NOT NULL
);

CREATE TABLE `student_course` (
  `userID` VARCHAR(20) NOT NULL,
  `courseID` INT NOT NULL
);

ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

ALTER TABLE `admissionrequest`
  ADD PRIMARY KEY (`requestID`),
  ADD KEY `userID` (`userID`),
  ADD KEY `courseID` (`courseID`),
  ADD KEY `instituteID` (`instituteID`);

ALTER TABLE `course`
  ADD PRIMARY KEY (`courseID`);

ALTER TABLE `course_institute`
  ADD KEY `courseID` (`courseID`),
  ADD KEY `instituteID` (`instituteID`);

ALTER TABLE `faculty`
  ADD PRIMARY KEY (`facultyID`),
  ADD KEY `courseID` (`courseID`),
  ADD KEY `instituteID` (`instituteID`);
  
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedbackID`),
  ADD KEY `instituteID` (`instituteID`),
  ADD KEY `userID` (`userID`);

ALTER TABLE `institute`
  ADD PRIMARY KEY (`instituteID`);

ALTER TABLE `student`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `emailID` (`emailID`);

ALTER TABLE `student_course`
  ADD KEY `userID` (`userID`),
  ADD KEY `courseID` (`courseID`);

ALTER TABLE `admissionrequest`
  MODIFY `requestID` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `course`
  MODIFY `courseID` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `faculty`
  MODIFY `facultyID` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `feedback`
  MODIFY `feedbackID` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `admissionrequest`
  ADD CONSTRAINT `admissionrequest_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `student` (`userID`),
  ADD CONSTRAINT `admissionrequest_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`),
  ADD CONSTRAINT `admissionrequest_ibfk_3` FOREIGN KEY (`instituteID`) REFERENCES `institute` (`instituteID`);

ALTER TABLE `course_institute`
  ADD CONSTRAINT `course_institute_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`),
  ADD CONSTRAINT `course_institute_ibfk_2` FOREIGN KEY (`instituteID`) REFERENCES `institute` (`instituteID`);

ALTER TABLE `faculty`
  ADD CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`),
  ADD CONSTRAINT `faculty_ibfk_2` FOREIGN KEY (`instituteID`) REFERENCES `institute` (`instituteID`);

ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`instituteID`) REFERENCES `institute` (`instituteID`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `student` (`userID`);

ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `student` (`userID`),
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`);  
  
CREATE TABLE roles (
    roleID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    roleName VARCHAR(50) NOT NULL
);

CREATE TABLE user_roles (
    userID VARCHAR(20) NOT NULL,
    roleID INT NOT NULL,
    PRIMARY KEY (userID, roleID),
    FOREIGN KEY (userID) REFERENCES student(userID),
    FOREIGN KEY (roleID) REFERENCES roles(roleID)
);

ALTER TABLE student ADD jwtRefreshToken VARCHAR(255);
ALTER TABLE institute ADD jwtRefreshToken VARCHAR(255);
ALTER TABLE admin ADD jwtRefreshToken VARCHAR(255);

ALTER TABLE student MODIFY studentPassword VARCHAR(255);
ALTER TABLE institute MODIFY institutePassword VARCHAR(255);
ALTER TABLE admin MODIFY adminPassword VARCHAR(255);

CREATE TABLE audit_log (
    logID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    userID VARCHAR(20) NOT NULL,
    action VARCHAR(100) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES student(userID)
);

ALTER TABLE student DROP COLUMN address;

CREATE TABLE InstituteRegistrationRequest (
    requestID INT NOT NULL AUTO_INCREMENT,
    instituteName VARCHAR(50) NOT NULL,
    instituteEmail VARCHAR(50) NOT NULL UNIQUE,
    institutePassword VARCHAR(255) NOT NULL,
    address VARCHAR(100) NOT NULL,
    status TINYINT(1) DEFAULT NULL, -- NULL = Pending, 1 = Approved, 0 = Denied
    requestDate DATE NOT NULL,
    PRIMARY KEY (requestID)
);

ALTER TABLE institute ADD instituteEmail VARCHAR(50) NOT NULL UNIQUE;

ALTER TABLE InstituteRegistrationRequest DROP COLUMN address;

CREATE TABLE InstituteImages (
    imageID INT AUTO_INCREMENT PRIMARY KEY,
    instituteID VARCHAR(20) NOT NULL,
    imageData BLOB NOT NULL, -- Store the actual binary image data
    uploadDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (instituteID) REFERENCES Institute(instituteID)
);

CREATE TABLE CourseImages (
    imageID INT AUTO_INCREMENT PRIMARY KEY,
    courseID INT NOT NULL,
    imageData BLOB NOT NULL, -- Store the actual binary image data
    uploadDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

ALTER TABLE Faculty ADD faculty_image BLOB;

ALTER TABLE Course ADD brochureData BLOB;











SHOW TABLES;
