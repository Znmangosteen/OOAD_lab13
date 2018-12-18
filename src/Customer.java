import java.util.Vector;

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : _rentals) {

            //determine amounts for each line
            double thisAmount = getThisAmount(each);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getPriceCode() == Movie.NEW_RELEASE)
                    && each.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result.append("\t").append(each.getTitle());
            result.append("\t").append(String.valueOf(thisAmount));
            result.append("\n");

            totalAmount += thisAmount;
        }

        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(totalAmount));
        result.append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints));
        result.append(" frequent renter points");
        return result.toString();
    }

    private double getThisAmount(Rental aRental) {
        double thisAmount=0;
        switch (aRental.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (aRental.getDaysRented() > 2) {
                    thisAmount += (aRental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (aRental.getDaysRented() > 3) {
                    thisAmount += (aRental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}
