package sn.isi.studentcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.studentcrud.dao.IStudent;
import sn.isi.studentcrud.model.Student;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private IStudent studentdao;

    public List<Student> getAll(){
        return studentdao.findAll();
    }

    public void add(Student student){
        studentdao.save(student);
    }

    public Student get(long id){
        return studentdao.findById(id).get();
    }

    public void delete(long id){
        studentdao.deleteById(id);
    }
}
