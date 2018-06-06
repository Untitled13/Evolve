import java.util.ArrayList;

public class Ctrl {
    Net best_Net;
    double best_Score;
    public Ctrl(int pop_per_generation, int number_of_generations, ArrayList<ArrayList<Double>> input, ArrayList<ArrayList<Double>> answers, double mod_W, double mod_Bias) {
        this.best_Net = (new Generation(pop_per_generation, input, answers)).best;
        this.best_Score = (new Scorer(this.best_Net, input, answers)).score;
        Net current = this.best_Net;
        for(int i = 0; i < pop_per_generation; i++) {
            current.modulate(mod_W, mod_Bias);
            if((new Scorer(current, input, answers)).score < this.best_Score) {
                this.best_Net = current;
                this.best_Score = (new Scorer(this.best_Net, input, answers)).score;
            }
        }
    }
}
