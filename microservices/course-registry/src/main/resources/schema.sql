DROP TABLE IF EXISTS public.tbl_usercoursedetail;
DROP TABLE IF EXISTS public.tbl_courses;
DROP TABLE IF EXISTS public.tbl_usercoursehead;
DROP TABLE IF EXISTS public.tbl_faculty;

CREATE TABLE public.tbl_faculty
(
    faculty_id character varying(25) NOT NULL,
    description character varying(50),
    CONSTRAINT tbl_faculty_pkey PRIMARY KEY (faculty_id)
);

CREATE TABLE public.tbl_courses
(
    course_id character varying(25) NOT NULL,
    description character varying(50),
    CONSTRAINT tbl_courses_pkey PRIMARY KEY (course_id)
);

CREATE TABLE public.tbl_usercoursehead
(
    student_id character varying(25) NOT NULL,
    term int NOT NULL,
    faculty_id character varying(25) NOT NULL,
    programme_id character varying(25) NOT NULL,
    CONSTRAINT "tbl_usercourseshead-pk" PRIMARY KEY (student_id, term, faculty_id, programme_id),
    CONSTRAINT fkusercoursehead FOREIGN KEY (faculty_id)
        REFERENCES public.tbl_faculty (faculty_id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.tbl_usercoursedetail
(
    student_id character varying(25) NOT NULL,
    term integer NOT NULL,
    faculty_id character varying(25) NOT NULL,
    programme_id character varying(25) NOT NULL,
    course_id character varying(25) NOT NULL,
    CONSTRAINT tbl_usercoursedetail_pkey PRIMARY KEY (student_id, term, faculty_id, programme_id, course_id),
    CONSTRAINT fkcourses FOREIGN KEY (course_id)
        REFERENCES public.tbl_courses (course_id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fksrtudent FOREIGN KEY (student_id, term, faculty_id, programme_id)
        REFERENCES public.tbl_usercoursehead (student_id, term, faculty_id, programme_id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
