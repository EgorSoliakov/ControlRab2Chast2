import Model.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

import static Service.Randomizer.randomToy;


public class Main {
    public static void main(String[] args)  {
        Toy[] toysA = new Toy[3];
        PriorityQueue<Toy> toys = new PriorityQueue<>((t1,t2) -> t2.getDrop() - t1.getDrop());
        toysA[0] =new Toy(1,"Робот", 2);
        toysA[1] =new Toy(2,"Кукла", 6);
        toysA[2] =new Toy(3,"Конструктор", 2);
        for(Toy toy: toysA){
            toys.add(toy);
        }


        try(FileWriter fileWriter = new FileWriter("text.txt")) {
            for (int i = 0; i < 10; i++) {
                Toy toy = randomToy(toysA);
                fileWriter.write(toy.getName());
                fileWriter.write("\n");
            }
        }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }
    }
}
