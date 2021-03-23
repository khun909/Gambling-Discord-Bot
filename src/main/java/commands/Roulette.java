package commands;



import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Roulette  {
    static public final
    Map<String, Double> userBank =new HashMap<String , Double>();

    public static void randomSet(String name, double points){
        Random rn = new Random();
        int answer = rn.nextInt(10) + 1;
        if(answer <= 5){
            userBank.put(name,userBank.get(name)+points);
        }
        else{
            userBank.put(name,userBank.get(name)-points);
            if (userBank.get(name)<0){userBank.put(name, (double) 0);}

        }
        if (userBank.get(name)<0){userBank.put(name, (double) 0);}

    }
}





