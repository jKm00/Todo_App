package no.ntnu.idata2001;

import java.util.Iterator;

public class Test
{
    public static void main(String[] args) {
        List list = new List("Test", "Joakim");
        Item item = new Item("Go shopping", "Go to the store and get your items", "Joakim", "15-02-2021");
        list.addItem(item);
        list.addItem(new Item("Test 2", "Test description", "Joakim", "20-02-2021"));

        Iterator<Item> it = list.getUncompletedItems();
        while (it.hasNext())
        {
            Item itemFound = it.next();
            System.out.println(itemFound.getTitle());
        }

        list.changeCheckmark(1);

        Iterator<Item> it2 = list.getUncompletedItems();
        while (it2.hasNext())
        {
            Item itemFound = it2.next();
            System.out.println(itemFound.getTitle());
        }
    }
}


