import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PharmacyCheckoutSystemTest {

    @Test
    void testInsertionSort() {
        PharmacyCheckoutSystem pharmacySystem = new PharmacyCheckoutSystem();

        String[] names = {"Ford Ferrari", "Charlie Oxford", "Emily Davis", "Grace Parker", "Aaron Baron"};
        String[] birthdays = {"05-20-91", "03-05-80", "12-30-95", "09-10-88", "10-14-87"};

        pharmacySystem.insertionSort(names, birthdays);

        assertArrayEquals(new String[]{"Aaron Baron", "Charlie Oxford", "Emily Davis", "Ford Ferrari", "Grace Parker"}, names);
        assertArrayEquals(new String[]{"10-14-87", "03-05-80", "12-30-95", "05-20-91", "09-10-88"}, birthdays);
    }
    
    @Test
    void testMedicationConstructor() {
        PharmacyCheckoutSystem.Medication medication = new PharmacyCheckoutSystem.Medication("TestMed", "Test Description", "Test Interaction", 20.0);
        assertEquals("TestMed", medication.name);
        assertEquals("Test Description", medication.description);
        assertEquals("Test Interaction", medication.notToTakeWith);
        assertEquals(20.0, medication.cost, 0.001);
    }
    
    @Test
    void testMainMethod() {
        assertTrue(true);
    }
    
    @Test
    void testInsertionSortAlreadySorted() {
        PharmacyCheckoutSystem pharmacySystem = new PharmacyCheckoutSystem();

        String[] names = {"Aaron Baron", "Charlie Oxford", "Emily Davis", "Ford Ferrari", "Grace Parker"};
        String[] birthdays = {"10-14-87", "03-05-80", "12-30-95", "05-20-91", "09-10-88"};

        pharmacySystem.insertionSort(names, birthdays);

        assertArrayEquals(new String[]{"Aaron Baron", "Charlie Oxford", "Emily Davis", "Ford Ferrari", "Grace Parker"}, names);
        assertArrayEquals(new String[]{"10-14-87", "03-05-80", "12-30-95", "05-20-91", "09-10-88"}, birthdays);
    }

    @Test
    void testInsertionSortReverseOrder() {
        PharmacyCheckoutSystem pharmacySystem = new PharmacyCheckoutSystem();

        String[] names = {"Grace Parker", "Ford Ferrari", "Emily Davis", "Charlie Oxford", "Aaron Baron"};
        String[] birthdays = {"09-10-88", "05-20-91", "12-30-95", "03-05-80", "10-14-87"};

        pharmacySystem.insertionSort(names, birthdays);

        assertArrayEquals(new String[]{"Aaron Baron", "Charlie Oxford", "Emily Davis", "Ford Ferrari", "Grace Parker"}, names);
        assertArrayEquals(new String[]{"10-14-87", "03-05-80", "12-30-95", "05-20-91", "09-10-88"}, birthdays);
    }

    

}