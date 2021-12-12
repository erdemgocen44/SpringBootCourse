package springboot_kurs_controller_service_repository_basic_authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class StudentBean05Controller {
    private StudentBean05Service studentBean05Service;
    @Autowired
    public StudentBean05Controller(StudentBean05Service studentBean05Service) {
        this.studentBean05Service = studentBean05Service;
    }
    @GetMapping(path = "/selectStudentById/{id}")
    public StudentBean05 selectStudentById(@PathVariable Long id) {
        return studentBean05Service.selectStudentById(id);
    }
    @GetMapping(path = "/selectAllStudents")
    public List<StudentBean05> selectAllStudents(){
        return studentBean05Service.selectAllStudents();
    }
    @DeleteMapping(path="/deleteById/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return  studentBean05Service.deleteStudentById(id);
    }
}