package sn.isi.studentcrud.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.studentcrud.model.Student;

@Repository
public interface IStudent extends JpaRepository<Student,Long> {

    Page<Student> findByNameContains(String motCle, Pageable pageable);
}
