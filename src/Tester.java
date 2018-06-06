import java.util.ArrayList;

public class Tester {
    Net net;
    ArrayList<Double> answers = new ArrayList<Double>();
    public double score = 1000000000000d;
    ArrayList<Double> scores = new ArrayList<Double>();
    public Tester(Net x, ArrayList<Double> Answers) {
        this.answers = Answers;
        this.net = x;
        for(int i = 0; i < net.out.size() && i < answers.size(); i++) {
            scores.add(0d);
        }
    }
    public void reset(Net x, ArrayList<Double> Answers, ArrayList<Double> in) {
        this.net = x;
        this.answers = Answers;
        for(int i = 0; i < net.out.size() && i < answers.size(); i++) {
            if(scores.get(i) == null) {
                scores.add(0d);
            }
        }
        score = 100000000000d;
    }
    public double calc() {
        this.net.run();
        score = 0d;
        for(int i = 0; i < net.out.size() && i < answers.size(); i++) {
            scores.set(i, Math.pow(answers.get(i)-net.out.get(i),2d));
        }
        for(int i = 0; i < scores.size(); i++) {
            score +=scores.get(i);
        }
        return score;
    }

}
