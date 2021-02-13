package no.ntnu.idata2001;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an item in a todo list.
 * An item contains a title, a description, a creation date, a deadline date, an author.
 * You can flag an item to mark it as important. Every flagged item should be display at the top of your todo list.
 */
public class Item
{
    private String title;
    private String description;
    private final LocalDate creationDate;
    private LocalDate deadline;
    private String author;
    private boolean checkmark; // false if item is not completed, true if it is
    //add a flag field

    /**
     * Creates an instance of item
     *
     * @param title, title of the todo item
     * @param description, description of the todo item with more details
     * @param author, name of the person who added the item
     * @param deadline, when the item has to be completed (String "dd-mm-yyy")
     */
    public Item(String title, String description, String author, String deadline)
    {
        this.title = title;
        this.description = description;
        this.creationDate = LocalDate.now();

        String[] deadlineArray = deadline.split("[-]", 0);
        this.deadline = LocalDate.of(Integer.parseInt(deadlineArray[2]), Integer.parseInt(deadlineArray[1]), Integer.parseInt(deadlineArray[0]));

        this.author = author;
        this.checkmark = false;
    }

    /**
     * Returns the title of the item
     *
     * @return title of the item
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns the description of the item
     *
     * @return description of the item
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Returns the date the item was created
     *
     * @return the date the item was created
     */
    public LocalDate getCreationDate()
    {
        return this.creationDate;
    }

    /**
     * Returns the deadline of the item
     *
     * @return the deadline
     */
    public LocalDate getDeadline()
    {
        return this.deadline;
    }

    /**
     * Returns the author who created the item
     *
     * @return the author
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * Returns the checkmark
     *
     * @return {@code true} if item is completed, {@code false} if not
     */
    public boolean getCheckmark()
    {
        return this.checkmark;
    }

    /**
     * Edits the title of the item to the title give in parameter
     *
     * @param newTitle, title to replace old title
     * @return {@code true} if title was succesfully replaced, {@code false} if not
     */
    public boolean editTitle(String newTitle)
    {
        boolean titleEdited = false;

        if (!newTitle.trim().isEmpty())
        {
            titleEdited = true;
            this.title = newTitle;
        }

        return titleEdited;
    }

    /**
     * Edits the description of the item to the description give in parameter
     *
     * @param newDescription, description to replace old description
     * @return {@code true} if title was succesfully replaced, {@code false} if not
     */
    public boolean editDescription(String newDescription)
    {
        boolean descriptionEdited = false;

        if (!newDescription.trim().isEmpty())
        {
            descriptionEdited = true;
            this.description = newDescription;
        }

        return descriptionEdited;
    }

    /**
     * Edits the deadline of the item to the deadline give in parameter ("dd-mm-yyyy")
     *
     * @param newDeadline, deadline to replace old deadline
     * @return {@code true} if deadline was succesfully replaced, {@code false} if not
     */
    public boolean editDeadline(String newDeadline)
    {
        boolean deadlineEdited = false;

        if (!newDeadline.trim().isEmpty())
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            try
            {
                LocalDate date = LocalDate.parse(newDeadline, formatter);
                deadlineEdited = true;
                String[] deadlineArray = newDeadline.split("[-]", 0);
                this.deadline = LocalDate.of(Integer.parseInt(deadlineArray[2]), Integer.parseInt(deadlineArray[1]), Integer.parseInt(deadlineArray[0]));
            }
            catch (DateTimeParseException dtpe)
            {
                deadlineEdited = false;
            }


        }

        return deadlineEdited;
    }

    /**
     * Edites the author to the new author give as parameter
     *
     * @param newAuthor, the author to replace the old author
     * @return {@code true} if author was replaced, {@code false} if not
     */
    public boolean editAuthor(String newAuthor)
    {
        boolean authorEdited = false;

        if (!newAuthor.trim().isEmpty())
        {
            authorEdited = true;
            this.author = newAuthor;
        }

        return authorEdited;
    }

    /**
     * Changes the checkmark. If it is {@code true} it will be change to {@code false} and vice versa
     */
    public void changeCheckmark()
    {
        if (this.checkmark == false)
        {
            this.checkmark = true;
        }
        else if (this.checkmark == true)
        {
            this.checkmark = false;
        }
    }
}
