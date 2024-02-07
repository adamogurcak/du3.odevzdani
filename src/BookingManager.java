import java.util.ArrayList;
import java.util.List;
public class BookingManager {
    private List<Booking> bookings;

    public BookingManager() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
    }

    public Booking getBooking(int index) {
        if (index >= 0 && index < bookings.size()) {
            return bookings.get(index);
        } else         {
            return null;
        }
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void clearBookings() {
        bookings.clear();
    }
//moc si nevim rady ale nejak jsem to zkusil (kouknout na to jeste jednou jak funguje cyklus for, else a if)
    public int getNumberOfWorkingBookings() {
        int count = 0;
        for (Booking booking : bookings) {
            if (booking.getVacationType() == VacationType.WORK) {
                count++;
            }
        }
        return count;
    }
//ten Booking mi nefunguje, a v mainu to mam cervene a tady zlute
    public double getAverageGuests() {
        if (bookings.isEmpty()) {
            return 0;
        }
        int totalGuests = 0;
        for (Booking booking : bookings) {
            totalGuests += booking.getNumberOfGuests();
        }
        return (double) totalGuests / bookings.size();
    }
//neco jsem klikl a vytvorilo to samo toto a od te doby mi nefunguje Booking
    private class Booking {
    }
}


