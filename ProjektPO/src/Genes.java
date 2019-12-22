import java.util.*;
import java.lang.Math.*;

public class Genes
{
    public static final int genesCount = 32;
    public static final int genesTypesCount = Main.directionCount;
    public static final Random random = new Random();
    private Vector<Integer> genes;

    Genes()
    {
        genes = new Vector<>(genesCount);
        Vector<Integer> genesNum = new Vector<>(genesTypesCount);
        for (int i = 0; i < genesTypesCount; i++)
            genesNum.add(1);
        for (int i = 0; i < genesCount; i++)
            genes.add(-1);
        for (int i = 0; i < genesCount - genesTypesCount; i++)
        {
            int x = random.nextInt(genesTypesCount);
            genesNum.set(x, genesNum.get(x) + 1);
        }
        int j = 0;
        for(int i = 0; i < genesTypesCount;)
        {
            if(genesNum.get(i) > 0)
            {
                genesNum.set(i, genesNum.get(i) - 1);
                genes.set(j++, i);
            }
            else
                i++;
        }
    }

    Genes(Vector<Integer> genes1, Vector<Integer> genes2)
    {
        Random random = new Random();

        genes = new Vector<>(genesCount);
        Vector<Integer> genesNum = new Vector<>(genesTypesCount);
        for (int i = 0; i < genesTypesCount; i++)
            genesNum.add(0);
        for (int i = 0; i < genesCount; i++)
            genes.add(-1);

        int slice1 = 10; //random.nextInt(genesCount);
        int slice2 = 20; //random.nextInt(genesCount);
        for(int i = 0; i < genesCount; i++)
            if(i < Math.min(slice1, slice2) || i > Math.max(slice1, slice2))
                genesNum.set(genes1.get(i), genesNum.get(genes1.get(i)) + 1);
            else
                genesNum.set(genes2.get(i), genesNum.get(genes2.get(i)) + 1);

        for(int i = 0; i < genesTypesCount; i++)
            if(genesNum.get(i) == 0)
                for(int j = (i+1) % genesTypesCount; j != i; j = (j+1) % genesTypesCount)
                    if(genesNum.get(j) > 1)
                    {
                        genesNum.set(i, genesNum.get(i) + 1);
                        genesNum.set(j, genesNum.get(j) - 1);
                        break;
                    }

        int j = 0;
        for(int i = 0; i < genesTypesCount;)
        {
            if(genesNum.get(i) > 0)
            {
                genesNum.set(i, genesNum.get(i) - 1);
                genes.set(j++, i);
            }
            else
                i++;
        }
    }

    Genes(Vector<Integer> seed)
    {
        genes = (Vector<Integer>) seed.clone();
    }

    public Vector<Integer> getGenes()
    {
        return (Vector<Integer>) genes.clone();
    }

    public int direction()
    {
        return genes.get(random.nextInt(genesCount));
    }
}
