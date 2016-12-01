package exampe.exmpe_01;


import exampe.CreateInventoryUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * The Simple example of using the interface Comparator and the class TreeSet
 */
public class TreeSet_01 {

    public static void main(String[] args) {

        List<String> list = CreateInventoryUtil.generateList("ACACIA KNIFEBLADE",
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


        System.out.println("List: " + list.size() + "\n");

        // Set without comparator
        Set<String> set_without_comparator = new TreeSet<>(list);
        System.out.println("Set without Comparator: " + set_without_comparator.size() + "\n");

        // Set with comparator A_Z
        Set<String> set_comparator_a_z = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int comp = str1.compareTo(str2);
                if (comp == 0) {
                    return -1;
                }
                return comp;
            }
        });
        set_comparator_a_z.addAll(list);
        System.out.println("Set with Comparator A_Z: " + set_comparator_a_z.size() + "\n" + set_comparator_a_z + "\n");

        // Set with comparator Z_A
        Set<String> set_comparator_z_a = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int comp = -str1.compareTo(str2);
                if (comp == 0) {
                    return -1;
                }
                return comp;
            }
        });
        set_comparator_z_a.addAll(list);
        System.out.println("Set with Comparator A_Z: " + set_comparator_z_a.size() + "\n" + set_comparator_z_a);

    }
}
