import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testEveryBranchCriterium() {
            // Тest 1
            RuntimeException exception1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 1000));
            assertEquals("allItems list can't be null!", exception1.getMessage());

            //Тest 2
            Item item2 = new Item(null, "11111", 10, 0);
            SILab2.checkCart(List.of(item2), 10);
            assertEquals("unknown", item2.getName());

            // Тest 3
            Item item3 = new Item("", "22222", 10, 0);
            SILab2.checkCart(List.of(item3), 10);
            assertEquals("unknown", item3.getName());

            // Тest 4
            Item item4 = new Item("item4", null, 100, 0);
            RuntimeException exception4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item4), 100));
            assertEquals("No barcode!", exception4.getMessage());

            // Тest 5
            Item item5 = new Item("item5", "123a5", 100, 0);
            RuntimeException exception5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item5), 100));
            assertEquals("Invalid character in item barcode!", exception5.getMessage());

            // Тest 6
            Item item6 = new Item("item6", "12345", 200, 0.2f);
            assertTrue(SILab2.checkCart(List.of(item6), 40));

            // Тest 7
            Item item7 = new Item("item7", "12345", 200, 0);
            assertTrue(SILab2.checkCart(List.of(item7), 200));

            // Тest 8
            Item item8 = new Item("item8", "012345", 400, 0.1f);
            assertTrue(SILab2.checkCart(List.of(item8), 10));

            // Тest 9
            Item item9 = new Item("item9", "012345", 200, 0.1f);
            assertTrue(SILab2.checkCart(List.of(item9), 20));

            // Тest 10
            Item item10 = new Item("item10", "012345", 400, 0);
            assertTrue(SILab2.checkCart(List.of(item10), 400));

            // Тest 11
            Item item11 = new Item("item11", "12345", 400, 0.1f);
            assertTrue(SILab2.checkCart(List.of(item11), 40));

             // Тest 12
            Item item12 = new Item("item12", "12345", 100, 0);
            assertTrue(SILab2.checkCart(List.of(item12), 100));

            // Тest 13
            Item item13 = new Item("item13", "12345", 150, 0);
            assertFalse(SILab2.checkCart(List.of(item13), 100));
    }


    @Test
        public void testMultipleConditionCriterium () {
            // Тest 1: item.getPrice() > 300, item.getDiscount() > 0, item.getBarcode().charAt(0) == '0'
            Item item14 = new Item("item14", "012345", 400, 0.1f);
            assertTrue(SILab2.checkCart(List.of(item14), 10));

            // Тest 2: item.getPrice() <= 300, item.getDiscount() > 0, item.getBarcode().charAt(0) == '0'
            Item item15 = new Item("item15", "012345", 200, 0.1f);
            assertTrue(SILab2.checkCart(List.of(item15), 20));

            // Тest 3: item.getPrice() > 300, item.getDiscount() <= 0, item.getBarcode().charAt(0) == '0'
            Item item16 = new Item("item16", "012345", 400, 0);
            assertTrue(SILab2.checkCart(List.of(item16), 400));

            // Тest 4: item.getPrice() > 300, item.getDiscount() > 0, item.getBarcode().charAt(0) != '0'
            Item item17 = new Item("item17", "12345", 400, 0.1f);
            assertTrue(SILab2.checkCart(List.of(item17), 40));

            // Тest 5: item.getPrice() > 300,item.getDiscount() <= 0,item.getBarcode().charAt(0) != '0'
            Item item18 = new Item("item18", "12345", 350, 0);
            assertTrue(SILab2.checkCart(List.of(item18), 350));

            // Тest 6: Тест кога item.getPrice() <= 300 ,item.getDiscount()  <= 0,item.getBarcode().charAt(0) == '0'
            Item item19 = new Item("item19", "02345", 200, 0);
            assertTrue(SILab2.checkCart(List.of(item19), 200));

            // Тest 7: item.getPrice() <= 300 ,item.getDiscount() > 0,item.getBarcode().charAt(0) != '0'
            Item item20 = new Item("item20", "02345", 200, 0.1f);
            assertTrue(SILab2.checkCart(List.of(item20), 20));

            // Тest 8: item.getPrice() <= 300 ,item.getDiscount() <= 0,item.getBarcode().charAt(0) != '0'
            Item item21= new Item("item21", "02345", 200, 0);
            assertTrue(SILab2.checkCart(List.of(item21), 200));

    }

}
