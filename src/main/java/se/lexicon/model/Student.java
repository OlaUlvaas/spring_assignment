package se.lexicon.model;

import java.util.Objects;

public class Student {
    private int studentId;
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.studentId = id;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
