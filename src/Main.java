import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        ArrayList<Double> in = new ArrayList<Double>();
        in.add(.46);
        in.add(.89);
        in.add(.923);
        in.add(.432);
        in.add(.234);
        in.add(.129);
        in.add(.667238);
        in.add(.076);
        ArrayList<Double> answers = new ArrayList<>();
        answers.add(.1);
        answers.add(.2);
        answers.add(.3);


//
//        Generation gen = new Generation(6,in,722);
//        gen.answers = answers;
//        gen.best();
//        System.out.println(gen.best.out);
//        Net net = new Net(in,3,3);

        Generation gen = new Generation(1000000, 3, in, answers);
        System.out.println(gen.best);
        System.out.println(gen.bestScore);
        for(int i = 0; i < gen.best.org.size(); i++) {
            for(int q = 0; q < gen.best.org.get(i).size(); q++) {
                System.out.println("Neuron "+i+", "+q +" "+ "weights = " + gen.best.org.get(i).get(q).w+ "\t\t| bias = "+gen.best.org.get(i).get(q).bias + " | out = "+ gen.best.org.get(i).get(q).val);
                System.out.println();
            }
        }
    }
}