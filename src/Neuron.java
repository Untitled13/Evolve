import java.util.ArrayList;
import java.util.Random;

public class Neuron {
    public ArrayList<Double> w = new ArrayList<>();
    public ArrayList<Double> in = new ArrayList<>();
    public double val;
    public double bias;

    public Neuron(double maxW, double maxBias, ArrayList<Double> in1) {
        this.in = in1;
        this.bias = Math.random() * 2 * maxBias - maxBias;
        for (int i = 0; i < in.size(); i++) {
            w.add(Math.random() * maxW * 2 - maxW);
        }
        this.val = calc();
    }
    public Neuron() {
        this.bias = Math.random() * 10;
        for (int i = 0; i < w.size(); i++) {
            w.add(Math.random());
        }
        this.val = calc();
    }
    public double mult(ArrayList<Double> a, ArrayList<Double> b) {
        double stor = 0.0;
        for (int i = 0; i < a.size() && i < b.size(); i++) {
            stor+=(a.get(i) * b.get(i));
        }
        return stor;
    }
    public double sigmoid(double x) {
        return 1/(1+Math.exp(-x));
    }

    public double calc() {
        return sigmoid(mult(this.w, this.in)+this.bias);
    }
    public void modulate(double maxW, double maxBias) {
        for (int i = 0; i < w.size(); i++) {
            w.set(i, w.get(i) + Math.random()*2*maxW - maxW);
        }
        this.bias += (Math.random() * 2 * maxBias - maxBias);
    }
}

