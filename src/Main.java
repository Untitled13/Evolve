import java.util.ArrayList;
import java.util.Arrays;
// This Program was Created in April 2018, By Cal Colbert-Pollack SWHS Class of 2020
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
        ArrayList<Double> in2 = new ArrayList<Double>();
        for(double i = 0; i < 8; i++) {
            in2.add(i*i/100);
        }
        ArrayList<ArrayList<Double>> input = new ArrayList<>();
        input.add(in);
//        input.add(in2);



        ArrayList<Double> answers = new ArrayList<>();
        answers.add(.1);
        answers.add(.2);
        answers.add(.3);
        ArrayList<Double> answers2 = new ArrayList<>();
        answers2.add(.4);
        answers2.add(.5);
        answers2.add(.6);

        ArrayList<ArrayList<Double>> ans = new ArrayList<>();
        ans.add(answers);
//        ans.add(answers2);

//
//        Generation gen = new Generation(6,in,722);
//        gen.answers = answers;
//        gen.best(); hello can  you hear me I'm in California dreamin about who we used to be it's no secret that the both of us are running out of time, so hello from the other side other side at least I coundn't say
//        System.out.println(gen.best.out);
//        Net net = new Net(in,3,3);
//        Generation gen = new Generation(500000, input, ans);
//        print(gen);
//        Net best = gen.best;
//        for(int i = 1; i < 30; i++) {
//            Generation current = new Generation(best, 300000, input, ans, 2/(Math.sqrt(i)+1), 20/(Math.sqrt(i)+4));
//            print(current);
//            best = current.best;
//        }



//        Net x = new Net(in, 5,4,3);
//        print(x);
//        System.out.println();
//        x.modulate(.1,.1);
//        x.run();
//        print(x);


        Generation gen = new Generation(10000000, input, ans);
        System.out.println("Important -> " + gen.bestScore);
        print(gen);
//        Generation gen2 = new Generation(gen.best, 1000000, input, ans, .5, 3);
//        System.out.println("Important -> " + gen2.bestScore);
//        print(gen2);
//        Generation gen3 = new Generation(gen2.best, 1000000, input, ans, .4, 2);
//        System.out.println("Important -> " + gen3.bestScore);
//        print(gen3);
//        Generation gen4 = new Generation(gen3.best, 1000000, input, ans, .2, 1);
//        System.out.println("Important -> " + gen4.bestScore);
//        print(gen4);
    }
    public static void print(Generation gen) {
        for(int i = 0; i < gen.best.org.size(); i++) {
            for(int q = 0; q < gen.best.org.get(i).size(); q++) {
                System.out.println("Neuron "+i+", "+q +" "+ "weights = " + gen.best.org.get(i).get(q).w+ "\t\t| bias = "+gen.best.org.get(i).get(q).bias + " | out = "+ gen.best.org.get(i).get(q).val);
            }
        }
    }
    public static void print(Net net) {
        for(int i = 0; i < net.org.size(); i++) {
            for(int q = 0; q < net.org.get(i).size(); q++) {
                System.out.println("Neuron "+i+", "+q +" "+ "weights = " + net.org.get(i).get(q).w+ "\t\t| bias = "+net.org.get(i).get(q).bias + " | out = "+ net.org.get(i).get(q).val);
            }
        }
    }
}