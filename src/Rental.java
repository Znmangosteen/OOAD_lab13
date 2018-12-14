import java.util.Date;

class Rental {
    private final Movie movie = new Movie("movie_title", Movie.REGULAR);

    private int _daysRented;
    public Rental(String title, int priceCode, Date start, Date end) {
        movie._title = title;
        movie._priceCode = priceCode;
        _daysRented = (int)((end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return movie._title;
    }
    
    public int getPriceCode() {
        return movie._priceCode;
    }
}
