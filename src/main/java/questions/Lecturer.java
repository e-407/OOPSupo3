package questions;

public class Lecturer implements AcademicRank {
    @Override
    public void lecture() {
        System.out.println("Lecturer is lecturing");
    }

    @Override
    public void writePapers() {
        System.out.println("Lecturer is writing");
    }
}