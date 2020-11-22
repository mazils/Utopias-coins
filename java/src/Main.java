import java.util.HashMap;

public class Main
{
    private static HashMap<Integer, Integer> hashMap;
    private static HashMap<Integer, Integer> pastValuesHashMap;

    public static void main(String[] args)
    {
        hashMap = new HashMap<>();
        pastValuesHashMap = new HashMap<>();

        hashMap.put(1, 1);
        hashMap.put(7, 1);
        hashMap.put(10, 1);
        hashMap.put(22, 1);

        for (int i = 2; i < 1000000000; i++)
        {
            System.out.println("Result for number :" + i + "  " + findChange(i));
        }

    }

    public static int findChange(int amount)
    {
        int tempMinChange = 0;
        int minChange = 0;

        if (amount == 0)
        {

            return 0;
        }

        if (amount < 0)
            return 0;
        if (pastValuesHashMap.containsKey(amount))
            return pastValuesHashMap.get(amount);

        for (Integer key : hashMap.keySet())
        {
            int var = amount - key;
            if (var > 0)
            {
                tempMinChange = findChange(var) + 1;
                if (tempMinChange < minChange || minChange == 0)
                {
                    minChange = tempMinChange;
                }

            }

        }
        pastValuesHashMap.put(amount,minChange);
        return minChange;
    }
}
