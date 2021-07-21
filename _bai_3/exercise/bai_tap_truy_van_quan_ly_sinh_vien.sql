use quan_ly_sinh_vien;
select * 
from student 
where student.student_name regexp '^h';
select * 
from class 
where month(class.start_date)=12;
select * 
from subject 
where subject.credit >= 3 and subject.credit <=5;
update student set student.class_id = 2 
where student.student_name = 'Hung';
select student.student_name,`subject`.sub_name,mark.mark
from student join  mark on student.student_id= mark.student_id join `subject` on mark.sub_id =`subject`.sub_id
order by mark.mark desc,student.student_name asc;