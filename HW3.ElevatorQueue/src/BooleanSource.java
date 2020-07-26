/**
 * This class represents a the probability, I am using the class given to us from lecture
 *
 * @author Paul Adu-Gyamfi
 *
 */
public class BooleanSource {

    private double probability;

    /**
     *
     * @param p
     * probability as a number between 0 an 1
     * @throws IllegalArgumentException
     * if probability is not in the range
     */
    public BooleanSource(double p) throws IllegalArgumentException {
        if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException();
        probability = p;
    }

    /**
     *
     * @return
     * true if request arrives else false
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }
}
