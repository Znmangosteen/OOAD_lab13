public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 0;

        result += daysRented * 3;

        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        int result = 0;
        //determine amounts for each line
        // add frequent renter points
        result++;
        // add bonus for a two day new release rental
        if (daysRented > 1) result++;
        return result;
    }
}
