package questions;

public class ImmutableRank implements AcademicRank{
    private AcademicRank mRank;

    public ImmutableRank(AcademicRank mRank){
        this.mRank = mRank;
    }

    @Override
    public void lecture() {
        mRank.lecture(); // Assuming method doesn't change class' internal state
    }

    @Override
    public void writePapers() {
        mRank.writePapers(); // Assuming method doesn't change class' internal state
    }

    // No other methods or attributes here for this example
}
