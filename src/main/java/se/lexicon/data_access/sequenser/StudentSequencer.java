package se.lexicon.data_access.sequenser;

public class StudentSequencer {
    private static int studentSequencer;

    public static int nextStudentId(){
        return ++studentSequencer;
    }
    public static int getStudentIdSequencer(){
        return studentSequencer;
    }
}
