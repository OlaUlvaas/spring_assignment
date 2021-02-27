package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);

        UserInputService userInputService= context.getBean(UserInputService.class);

        StudentManagement studentManagement = context.getBean(StudentManagement.class);


        System.out.println("########## create() and save() ###########");
        System.out.println(studentManagement.create());
        Student student1 = studentDao.save(new Student("Kalle Kula"));
        Student student2 = studentDao.save(new Student("Mulliga Molly"));
        Student student3 = studentDao.save(new Student("Pelle Plutt"));
        Student student4 = studentDao.save(new Student("Tant Gredelin"));
        Student student5 = studentDao.save(new Student("Karl XII"));
        Student student6 = studentDao.save(new Student("Karl-Johan Swamph"));
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println("-------------------------------");
        System.out.println("########## find() ###########");
        System.out.println(studentDao.find(6));
        System.out.println("-------------------------------");
        System.out.println("########## findAll() ###########");
        List<Student> students = studentManagement.findAll();
        students.forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println("########## remove() ###########");
        studentDao.delete(4);
        students.forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println("########## edit() ###########");
        Student theOneToEdit = studentManagement.edit(student4);
        System.out.println("Updated = " + theOneToEdit);
        students.forEach(System.out::println);
        System.out.println("-------------------------------");
    }
}
