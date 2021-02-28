package se.lexicon.data_access;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentDaoTest {

    @Autowired
    StudentDao testObject;

    @Test
    public void test_save(){
        Student expected = new Student(1, "Betty Boop");
        Student actual = testObject.save(new Student("Betty Boop"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_find(){
        Student createdStudent = testObject.save(new Student("Roger Moore"));
        Student createdStudent2 = testObject.save(new Student("Dolly Parton"));
        int expectedId1 = 1;
        int expectedId2 = 2;
        int actualId1 = createdStudent.getStudentId();
        int actualId2 = createdStudent2.getStudentId();
        Assert.assertEquals(expectedId1, actualId1);
        assertEquals(expectedId2, actualId2);
    }

    @Test
    public void test_findAll(){
        //List<Student> findAll()
        List<Student> students = new ArrayList<>();
        Student createdStudent = testObject.save(new Student("Roger Moore"));
        Student createdStudent2 = testObject.save(new Student("Dolly Parton"));
        Student createdStudent3 = testObject.save(new Student("Alo Såvlu"));
        Student createdStudent4 = testObject.save(new Student("Jari Kurri"));
        students.add(createdStudent);
        students.add(createdStudent2);
        students.add(createdStudent3);
        students.add(createdStudent4);

        List<Student> expectedList = students;
        List<Student> actualList = testObject.findAll();
        assertEquals(expectedList, actualList);
    }
    @Test
    public void test_delete(){
        List<Student> students = new ArrayList<>();
        Student createdStudent = testObject.save(new Student("Roger Moore"));
        Student createdStudent2 = testObject.save(new Student("Dolly Parton"));
        Student createdStudent3 = testObject.save(new Student("Alo Såvlu"));
        Student createdStudent4 = testObject.save(new Student("Jari Kurri"));
        students.add(createdStudent);
        students.add(createdStudent2);
        students.add(createdStudent3);
        students.add(createdStudent4);

        testObject.delete(1);

        int expectedListSize = 3;
        int actualListSize = testObject.findAll().size();

        assertEquals(expectedListSize, actualListSize);
    }


}
