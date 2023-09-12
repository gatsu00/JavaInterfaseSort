package TicketManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 7);
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortNotTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MSK", 300, 11, 13);
        Ticket ticket2 = new Ticket("MSK", "SPB", 250, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 500, 10, 15);
        Ticket ticket5 = new Ticket("UFA", "SPB", 600, 9, 15);
        Ticket ticket6 = new Ticket("MSK", "SAM", 800, 5, 8);
        Ticket ticket7 = new Ticket("LA", "NEW", 900, 8, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 400, 11, 13);
        Ticket ticket9 = new Ticket("SPB", "MSK", 750, 12, 3);
        Ticket ticket10 = new Ticket("SPB", "MSK", 650, 4, 7);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("UFA", "NEW");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MSK", 300, 11, 13);
        Ticket ticket2 = new Ticket("MSK", "SPB", 250, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 500, 10, 15);
        Ticket ticket5 = new Ticket("UFA", "SPB", 600, 9, 15);
        Ticket ticket6 = new Ticket("MSK", "SAM", 800, 5, 8);
        Ticket ticket7 = new Ticket("LA", "NEW", 900, 8, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 400, 11, 13);
        Ticket ticket9 = new Ticket("SPB", "MSK", 750, 12, 3);
        Ticket ticket10 = new Ticket("SPB", "MSK", 650, 4, 7);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("SPB", "UFA");
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //2
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17); // 10
        Ticket ticket5 = new Ticket("UFA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8); //1

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MSK", 300, 11, 13); //2
        Ticket ticket2 = new Ticket("MSK", "SPB", 250, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 500, 10, 15); // 5
        Ticket ticket5 = new Ticket("UFA", "SPB", 600, 9, 15);
        Ticket ticket6 = new Ticket("MSK", "SAM", 800, 5, 8);
        Ticket ticket7 = new Ticket("LA", "NEW", 900, 8, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 400, 11, 13); //2
        Ticket ticket9 = new Ticket("SPB", "MSK", 750, 12, 3); // 3
        Ticket ticket10 = new Ticket("SPB", "MSK", 650, 4, 8); // 4
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SPB", "NEW", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MSK", 300, 11, 13); //2
        Ticket ticket2 = new Ticket("MSK", "SPB", 250, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 500, 10, 15); // 5
        Ticket ticket5 = new Ticket("UFA", "SPB", 600, 9, 15);
        Ticket ticket6 = new Ticket("MSK", "SAM", 800, 5, 8);
        Ticket ticket7 = new Ticket("LA", "NEW", 900, 8, 17);
        Ticket ticket8 = new Ticket("SPB", "MSK", 400, 11, 13); //2
        Ticket ticket9 = new Ticket("SPB", "MSK", 750, 12, 3); // 3
        Ticket ticket10 = new Ticket("SPB", "MSK", 650, 4, 8); // 4
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("LA", "NEW", comparator);
        Ticket[] expected = {ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }
}
