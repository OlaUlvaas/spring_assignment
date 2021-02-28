package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement{

    private final UserInputService inputService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService inputService, StudentDao studentDao) {
        this.inputService = inputService;
        this.studentDao = studentDao;
    }
    @Override
    public Student create() {
        System.out.println("Enter students name: ");
        String studentName = inputService.getString();
        Student student = new Student();
        student.setName(studentName);

        return save(student);
    }

    @Override
    public Student save(Student student) {
        if (student.equals(null)){
            throw new IllegalArgumentException("Student name can not be null");
        }
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        if (id == 0){
            throw new IllegalArgumentException("Students ID can not be Zero");
        }
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = find(id);

        if (id == 0){
            throw new IllegalArgumentException("Students ID can not be Zero");
        }
        studentDao.delete(id);

        return studentToRemove;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student.getStudentId() == 0)
            throw new NullPointerException("Students ID can not be Zero");

        System.out.println("Enter the new name: ");
        String studentToUpdate = inputService.getString();
        student.setName(studentToUpdate);
        studentDao.save(student);
        return student;

    }
}
