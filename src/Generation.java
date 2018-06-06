import java.util.ArrayList;
public class Generation {
//    ArrayList<Net> pops = new ArrayList<Net>();
//    ArrayList<Double> answers = new ArrayList<Double>();
//    ArrayList<Double> scores  = new ArrayList<Double>();
//    public Net best;
//    int numOut;
//    public int population;
//    public Generation(int population, ArrayList<Double> in, int NumOut) {
//        this.population = population;
//        this.numOut = NumOut;
//        for (int i = 0; i < population; i++) {
//            pops.add(new Net(in, numOut*3, numOut*2, numOut));
//        }
//    }
//
//    public double rand(double x, double y) {
//        return Math.random()*(Math.abs(y-x))+x;
//    }
//    public int randInt(double x, double y) {
//        return (int) Math.round(rand(x,y));
//    }
//    public int randInt(int x, int y) {
//        return randInt((double) x, (double) y);
//    }
//
//    public void score() {
//        if(scores.size() != 0) {
//            scores = new ArrayList<Double>();
//        }
//        for(int q = 0; q < pops.size(); q++) {
//            scores.add((new Tester(pops.get(q), answers)).calc());
//        }
//    }
//    public void calcAll() {
//        for(int i = 0; i < pops.size(); i++) {
//            pops.get(i).run();
//        }
//    }
//    public void calcAll(ArrayList<Double> input) {
//        for(int i = 0; i < pops.size(); i++) {
//            pops.get(i).in = input;
//        }
//        calcAll();
//    }
//    public void best() {
//        double stor = 100000000000000.0;
//        int index = 0;
//        for (int i = 0; i < scores.size(); i++) {
//            if(scores.get(i) < stor) {
//                stor = scores.get(i);
//                index = i;
//            }
//        }
//        this.best = pops.get(index);
//    }





    //above is probly trash;

    // This stuff is importand





//    public Net best;
//    double bestScore;
//    Net current;
//    ArrayList<Double> answers;
//    public Generation(int population,  int valuesOut, ArrayList<Double> in, ArrayList<Double> answers) {
//        best = new Net(in, valuesOut*3, valuesOut*2, valuesOut);
//        current = new Net(in, valuesOut*3, valuesOut*2, valuesOut);
//        this.answers = answers;
//        bestScore = (new Tester(best, answers)).calc();
//        System.out.println(bestScore);
//        for (int i = 0 ; i < population; i++) {
//            if ((new Tester(current, answers)).calc() < bestScore) {
//                best = current;
//                bestScore = (new Tester(best,answers)).calc();
//                current = new Net(in, valuesOut*3, valuesOut*2, valuesOut);
//                System.out.println(i + " "+ bestScore);
//            }
//            else {
//                current = new Net(in, valuesOut*3, valuesOut*2, valuesOut);
//            }
//        }
//    }

    public Net best;
    double bestScore;
    Net current;
    ArrayList<ArrayList<Double>> answers;
    ArrayList<ArrayList<Double>> scores;


    public Generation(int population, ArrayList<ArrayList<Double>> in, ArrayList<ArrayList<Double>> answers) {
        int valuesOut = answers.get(0).size();
        best = new Net(in.get(0), valuesOut*3, valuesOut*2, valuesOut);
        current = new Net(in.get(0), valuesOut*3, valuesOut*2, valuesOut);
        this.answers = answers;
        bestScore = (new Scorer(best, in, answers)).score;
        System.out.println(bestScore);
        for (int i = 0 ; i < population; i++) {
            if ((new Scorer(current, in, answers)).score < bestScore) {
                best = current;
                bestScore = (new Scorer(best, in, answers)).score;
                current = new Net(in.get(0), valuesOut*3, valuesOut*2, valuesOut);
                System.out.println(i + " "+ bestScore);
            }
            else {
                current = new Net(in.get(0), valuesOut*3, valuesOut*2, valuesOut);
            }
        }
    }
//    public Generation(Net seed, int population, ArrayList<ArrayList<Double>> in, ArrayList<ArrayList<Double>> answers, double mod_W, double mod_Bias) {
//        int valuesOut = answers.get(0).size();
//        this.best = seed;
//        this.current = seed;
//        this.current.modulate(mod_W, mod_Bias);
//        this.answers = answers;
//        this.bestScore = new Scorer(seed, in, answers).score;
//
//        System.out.println(bestScore);
//
//        for(int i = 0; i < population; i++) {
//            if (new Scorer(this.current, in, answers).score < bestScore) {
//                this.best = current;
//                this.bestScore = (new Scorer(best, in, answers)).score;
//                current = seed;
//                current.modulate(mod_W, mod_Bias);
//                System.out.println(i + " " + bestScore);
//            }
//            else {
//                current = new Net(in.get(0), valuesOut*3, valuesOut*2, valuesOut);
//            }
//        }
//    }
    public Generation(Net seed, int population, ArrayList<ArrayList<Double>> in, ArrayList<ArrayList<Double>> answers, double mod_W, double mod_Bias) {
        double valuesOut = answers.get(0).size();
        this.best = seed;
        this.bestScore = seed.score(in, answers);
        this.current = this.best;
        this.current.modulate(mod_W, mod_Bias);

        System.out.println(this.bestScore);

        for(int i = 0; i < population; i++) {
            if (current.score(in, answers) < this.bestScore) {
                this.best = this.current;
                this.current.modulate(mod_W, mod_Bias);
                this.bestScore = best.score(in, answers);
                System.out.println(i + " " + bestScore);
            }
        }
    }
}
