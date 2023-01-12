package qub;

import java.util.Comparator;

public interface Problem12IntegerToRoman
{
    public static java.util.SortedMap<Integer,String> getRomanNumerals()
    {
        final Comparator<Integer> comparator = Comparator.comparingInt(Integer::intValue).reversed();
        final java.util.SortedMap<Integer,String> romans = new java.util.TreeMap<>(comparator);

        romans.put(1000, "M");
        romans.put(500, "D");
        romans.put(100, "C");
        romans.put(50, "L");
        romans.put(10, "X");
        romans.put(5, "V");
        romans.put(1, "I");

        romans.put(900, "CM");
        romans.put(400, "CD");
        romans.put(90, "XC");
        romans.put(40, "XL");
        romans.put(9, "IX");
        romans.put(4, "IV");

        return romans;
    }

    public static String intToRoman(int num)
    {
        final java.util.SortedMap<Integer,String> romans = getRomanNumerals();

        final StringBuilder result = new StringBuilder();

        for (final java.util.Map.Entry<Integer,String> entry : romans.entrySet())
        {
            final int romanValue = entry.getKey();
            while (num >= romanValue)
            {
                num -= romanValue;
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }
}
