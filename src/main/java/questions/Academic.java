package questions;

public class Academic {
    AcademicRank mRank = new Lecturer();

    public AcademicRank getRank(){
        return new ImmutableRank(mRank);
    }

    // Functionality
}
