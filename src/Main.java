import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BookingManager bookingManager = new BookingManager();
        fillBookings(bookingManager);

        // Výpis všech rezervací
        System.out.println("Výpis všech rezervací:");
        printAllBookings(bookingManager);

        // Výpis prvních osmi rekreačních rezervací
        System.out.println("Prvních osm rekreačních rezervací:");
        printFirstRecreationalBookings(bookingManager);

        // Statistika podle počtu hostů
        System.out.println("Statistika podle počtu hostů:");
        printGuestStatistics(bookingManager);
    }

    // Metoda pro vytvoření testovacích rezervací
    private static void fillBookings(BookingManager bookingManager) {
        // Rezervace pro pracovní pobyt (vacationtype.work)
        bookingManager.addBooking(new Booking("Karel Dvořák", LocalDate.of(1990, 5, 15),
                LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), VacationType.WORK, 1));
//prvni locadaldate of je narozeni, pak zacatek pobytu a nasleduje konec pobytu
        // Rezervace pro rekreační pobyt (vacationtype.recreational)
        bookingManager.addBooking(new Booking("Jiný pan Karel Dvořák", LocalDate.of(1979, 1, 3),
                LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), VacationType.RECREATIONAL, 1));

        // Rezervace pro rekreační pobyty Karolíny Tmavé (start date zacatek, enddate konec)jakoby ten cyklus je 1 az 10dnu a pak to znamena kolik se ma pricitat dnu takze plusdays a cislo
        LocalDate startDate = LocalDate.of(2023, 8, 1);
        LocalDate endDate = LocalDate.of(2023, 8, 2);
        for (int i = 1; i <= 10; i++) {
            bookingManager.addBooking(new Booking("Karolína Tmavá", LocalDate.of(1985, 8, 12),
                    startDate, endDate, VacationType.RECREATIONAL, 1));
            startDate = startDate.plusDays(2);
            endDate = endDate.plusDays(2);
        }

        // Rezervace pro celý srpen, mame to vlastne od 1.srpna do 31.srpna)
        bookingManager.addBooking(new Booking("Karolína Tmavá", LocalDate.of(1985, 8, 12),
                LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), VacationType.RECREATIONAL, 1));
    }

    // Metoda pro výpis všech rezervací snad to bude fungovat ale bylo tam napsane pouzit ten static void tak jsem zkusil
    private static void printAllBookings(BookingManager bookingManager) {
        for (Booking booking : bookingManager.getBookings()) {
            System.out.println(booking);
        }
    }
//uz tady je neco i z treti lekce napr. pouziti break v cyklu if a for
    // Metoda pro výpis prvních osmi rekreačních rezervací
    private static void printFirstRecreationalBookings(BookingManager bookingManager) {
        int count = 0;
        for (Booking booking : bookingManager.getBookings()) {
            if (booking.getVacationType() == VacationType.RECREATIONAL) {
                System.out.println(booking);
                count++;
            }
            if (count >= 8) {
                break;
            }
        }
    }

    // Metoda pro výpis statistiky podle počtu hostů, stalo se to podtrzene nevim proc, asi to tak ma byt ale mozna se zeptam nezapomen
    private static void printGuestStatistics(BookingManager bookingManager) {
        int singleGuestCount = 0;
        int doubleGuestCount = 0;
        int moreThanDoubleGuestCount = 0;
//tady je cyklus kdyz je neco vic nez neco udelej toto, pak vic nez tamto udelej tamto a kdyz jeste neco jine udelej tamto if neco... else if... else (at zkousi porad kdyz bude vic hostu)
        for (Booking booking : bookingManager.getBookings()) {
            int numberOfGuests = booking.getNumberOfGuests();
            if (numberOfGuests == 1) {
                singleGuestCount++;
            } else if (numberOfGuests == 2) {
                doubleGuestCount++;
            } else {
                moreThanDoubleGuestCount++;
            }
        }
//Vytisknuti na obrazovku 1, 2 a více hostů
        System.out.println("Celkový počet rezervací s jedním hostem: " + singleGuestCount);
        System.out.println("Celkový počet rezervací se dvěma hosty: " + doubleGuestCount);
        System.out.println("Celkový počet rezervací s více než dvěma hosty: " + moreThanDoubleGuestCount);
    }
    }
//plno veci co jsi nepochopil ptej se, napis, nezapomen a hlavne at ti to funguje.. rikal ze je lepsi mit 1 ukol kteremu rozumim a mam nez nekolik k nicemu tento uz celkem chapu jen jeste musim doladit plno veci co mam cervene a nejdou mi)