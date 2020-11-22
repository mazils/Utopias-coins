import java.util.HashMap;

public class Main
{
    private static HashMap<Integer, Integer> hashMap;


    public static void main(String[] args)
    {
        hashMap = new HashMap<>();
        Main utopiaCoins = new Main();
        hashMap.put(1, 1);
        hashMap.put(7, 1);
        hashMap.put(10, 1);
        hashMap.put(22, 1);

        for (int i = -6; i < 70; i++)
        {
            System.out.println("Result for number :" + i + "  " + utopiaCoins.findChange(i));
        }

    }

    public int findChange(int amount)
    {
        int tempMinChange = 0;
        int minChange = 0;

        if (amount == 0)
        {

            return 0;
        }

        if (amount < 0)
            return 0;
        if (hashMap.containsKey(amount))
            return hashMap.get(amount);

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

        return minChange;
    }
}
