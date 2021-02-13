package no.ntnu.idata2001;

public class Test
{
    public static void main(String[] args) {
        Item item = new Item("Go shopping", "Go to the store and get your items", "Joakim", "15-2-2021");
        System.out.println(item.getDeadline());
        if (item.editDeadline("16-02-2021"))
        {
            System.out.println(item.getDeadline());
        }
    }
}


