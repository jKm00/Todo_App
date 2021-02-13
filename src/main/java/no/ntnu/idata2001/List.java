package no.ntnu.idata2001;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a todo list in the application. You can have multiple todo list that have different topics.
 * When you first create a list it will be empty.
 */
public class List {
    private String name;
    private String author;
    private final LocalDate creationDate;
    private ArrayList<Item> items;

    /**
     * Creates an object of List
     *
     * @param name, name of the list
     */
    public List(String name, String author) {
        this.name = name;
        this.author = author;
        this.creationDate = LocalDate.now();
        this.items = new ArrayList<>();
    }

    /**
     * Adds a item to the list
     *
     * @param item item to be added
     */
    public void addItem(Item item)
    {
        this.items.add(item);
    }

    /**
     * Returns the name of the list
     *
     * @return name of the list
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the author who created the list
     *
     * @return author who created the list
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the date the list was created
     *
     * @return the date the list was created
     */
    public LocalDate getCreationDate() {
        return this.getCreationDate();
    }

    /**
     * Returns a list of every item as an arraylist
     *
     * @return a list with every item
     */
    public ArrayList<Item> getAllItems() {
        return this.items;
    }

    /**
     * Returns a list with every completed item, if no item is completed {@code null} is returned
     *
     * @return a list with every completed item
     */
    public ArrayList<Item> getCompletedItems() {
        ArrayList<Item> completedItems = new ArrayList<>();

        for (Item item : items) {
            if (item.getCheckmark()) {
                completedItems.add(item);
            }
        }

        return completedItems;
    }

    /**
     * Returns a list with every item yet to be completed, if every item is completed {@code null} is returned
     *
     * @return a list with every item yet to be completed
     */
    public ArrayList<Item> getUncompletedItems()
    {
        ArrayList<Item> uncompletedItems = new ArrayList<>();

        for(Item item : items)
        {
            if (!item.getCheckmark())
            {
                uncompletedItems.add(item);
            }
        }

        return uncompletedItems;
    }

    /**
     * Returns an iterator for every item in the list
     *
     * @return an iterator for every item in the list
     */
    public Iterator<Item> getIterator()
    {
        Iterator<Item> it = this.items.iterator();
        return it;
    }

    /**
     * Switches the checkmark of an item
     *
     * @param itemNumber number of the item (E.g. first item has itemNumber: 1)
     */
    public void changeCheckmark(int itemNumber)
    {
        Item item = this.items.get(itemNumber - 1);
        item.changeCheckmark();
    }

}
