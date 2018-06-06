import java.util.ArrayList;

public class Scorer {
    double score = 0d;
    Net net;
//    ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<Double>>>>> x = new ArrayList<>();
    ArrayList<ArrayList<Double>> answers;
    ArrayList<ArrayList<Double>> inputs;
    public Scorer(Net net, ArrayList<ArrayList<Double>> inputss, ArrayList<ArrayList<Double>> answers) {
        this.net = net;
        this.answers = answers;
        this.inputs = inputss;
        for(int i = 0; i < inputs.size() && i < answers.size(); i++) {
            net.run(inputs.get(i));
            score += (new Tester(net, answers.get(i))).calc();
        }
    }
    public double calc(ArrayList<ArrayList<Double>> inputss, ArrayList<ArrayList<Double>> ans) {
        this.score = 0d;
        this.answers = ans;
        this.inputs = inputss;
        for(int i = 0; i < inputs.size() && i < answers.size(); i++) {
            net.run(inputs.get(i));
            score += (new Tester(net, answers.get(i))).calc();
        }
        return score;
    }


}
