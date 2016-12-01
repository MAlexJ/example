package exampe.exmpe_01;

import exampe.CreateInventoryUtil;
import exampe.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * The simple example of using custom comparator
 *
 * @author malex
 */
public class TreeSet_02 {

    public static void main(String[] args) {

        List<Inventory> inventoryList = new ArrayList<>();

        float price = 12.34f;
        int count = 1;

        for (String name : listNames()) {

            inventoryList.add(new Inventory(name, Float.toString(price), price));

            if (count > 26) {
                price += 2.01f;
            } else {
                price -= 1.01f;
            }

            count++;

        }


        // added Inventory to list
        inventoryList.add(CreateInventoryUtil.createInventory("ASTER SOLDG MOR GLRY15PK", "234", -13.920004f));


        // List
        System.out.println("List size: " + inventoryList.size());
        System.out.println("List: " + inventoryList + "\n");


        // Set A_Z
        Set<Inventory> set_A_Z = new TreeSet<>(CreateInventoryUtil.createComparator("ALPH_A_Z"));
        set_A_Z.addAll(inventoryList);
        System.out.println("Set A_Z size: " + set_A_Z.size());
        System.out.println("Set A_Z : " + set_A_Z + "\n");


        // Set Z_A
        Set<Inventory> set_Z_A = new TreeSet<>(CreateInventoryUtil.createComparator("ALPH_Z_A"));
        set_Z_A.addAll(inventoryList);
        System.out.println("Set Z_A size: " + set_Z_A.size());
        System.out.println("Set Z_A : " + set_Z_A + "\n");

        // Set 9 >> 0
        Set<Inventory> set_9 = new TreeSet<>(CreateInventoryUtil.createComparator("PRICE_HIGH"));
        set_9.addAll(inventoryList);
        System.out.println("Set 9 >> 0 size: " + set_9.size());
        System.out.println("Set 9 >> 0 : " + set_9 + "\n");

        // Set 0 >> 9
        Set<Inventory> set_0 = new TreeSet<>(CreateInventoryUtil.createComparator("PRICE_LOW"));
        set_0.addAll(inventoryList);
        System.out.println("Set 0 >> 9 size: " + set_0.size());
        System.out.println("Set 0 >> 9: " + set_0 + "\n");

    }


    // Generate the list of names Inventory
    private static List<String> listNames() {
        return CreateInventoryUtil.generateList("ACACIA KNIFEBLADE",
                "ACACIA KNIFEBLADE",
                "ALSTRO COTE D&#039;AZ SS8PK",
                "ALSTRO KIMBERLY SS8PK",
                "ALSTRO ORG QUEEN SS8PK",
                "ALSTRO PRMADNA SS8PK",
                "ALSTRO PREM PK(GOLD)14PK",
                "ALSTRO VERDI SS8PK",
                "ALSTRO VIRGN SS8PK",
                "ALSTRO XMAS SEL10PK",
                "ALSTRO XMAS SS8PK",
                "ALSTRO AWESOME BLOSSUM",
                "ALSTRO COLORS GALORE SELECT",
                "ALSTRO COLORS GALORE SUPER SELECT",
                "ALSTRO COTE D&#039;AZUR SELECT",
                "ALSTRO HIMALAYA SEL12PK",
                "ALSTRO CHARMELIA PRM 8PK",
                "ALSTRO MAYFAIR SELECT",
                "ALSTRO PRIMADONNA SELECT",
                "ALSTRO REBECCA SELECT",
                "ALSTRO ASSORTED SELECT",
                "ALSTRO ASSORTED SELECT",
                "ALSTRO AMATISTA SEL10PK",
                "ALSTRO DIMENSION SELECT",
                "ALSTRO DUBAI SEL10PK",
                "ALSTRO NAPOLI SELECT",
                "ALSTRO ROSITA SELECT",
                "ALSTRO ASSORTED FANCY 22PK",
                "ALSTRO ASST EX9PK",
                "ALSTRO ASSORTED SELECT",
                "AMARANTHUS GREEN UPRIGHT",
                "AMARANTHUS RED HANGING 20PK",
                "AMARANTHUS RED UPRIGHT",
                "ASPIDISTRA GREEN",
                "ASPIDISTRA VARIEGATED",
                "ASTER SOLDG MOR GLRY15PK",
                "ASTER MATSU RED10PK",
                "ASTER MATSUMOTO LAVENDER",
                "ASTER MATSUMOTO PURPLE",
                "ASTER MATSUMOTO PURPLE",
                "ASTER MATSU PUR25PK");
    }
}
