import java.util.ArrayList;

public class Net {
    public double MAX_W = 3;
    public double MAX_BIAS = 10;

    int[] plan = new int[20];
    public ArrayList<ArrayList<Neuron>> org = new ArrayList<>();
    public ArrayList<Double> in = new ArrayList<>();
    public ArrayList<Double> out = new ArrayList<>();

    public Net(ArrayList<Double> in1, int... x ) {
        this.in = in1;
        plan = x;
        for(int q = 0; q < plan.length; q++) {
            org.add(new ArrayList<Neuron>());
            for(int i = 0; i < plan[q]; i++) {
                if (q==0) {
                    org.get(q).add(new Neuron(MAX_W,MAX_BIAS, this.in));
                }
                else {
                    ArrayList<Double> store = new ArrayList<>();
                    for(int z = 0; z < org.get(q-1).size(); z++) {
                        store.add(org.get(q-1).get(z).val);
                    }
                    org.get(q).add(new Neuron(MAX_W, MAX_BIAS, store));
                }
            }
        }
        ArrayList<Double> stor = new ArrayList<>();
        for(int i = 0; i < org.get(org.size()-1).size(); i++) {
            stor.add(org.get(org.size()-1).get(i).val);
        }
        this.out = stor;
    }
    public void run(ArrayList<Double> in) {
        this.in = in;
        for(int q = 0; q < plan.length; q++) {
            for(int i = 0; i < plan[q]; i++) {
                if (q==0) {
                    org.get(q).get(i).in = this.in;
                    org.get(q).get(i).val = org.get(q).get(i).calc();
                }
                else {
                    for(int z = 0; z < org.get(q-1).size(); z++) {
                        org.get(q).get(i).in.set(z, org.get(q-1).get(z).val);
                    }
                    org.get(q).get(i).val = org.get(q).get(i).calc();
                }
            }
        }

        ArrayList<Double> stor = new ArrayList<>();
        for(int i = 0; i < org.get(org.size()-1).size(); i++) {
            stor.add(org.get(org.size()-1).get(i).val);
        }
        this.out = stor;
    }
    public void run() {
        for(int q = 0; q < plan.length; q++) {
            for(int i = 0; i < plan[q]; i++) {
                if (q==0) {
                    org.get(q).get(i).in = this.in;
                    org.get(q).get(i).val = org.get(q).get(i).calc();
                }
                else {
                    for(int z = 0; z < org.get(q-1).size(); z++) {
                        org.get(q).get(i).in.set(z, org.get(q-1).get(z).val);
                    }
                    org.get(q).get(i).val = org.get(q).get(i).calc();
                }
            }
        }

        ArrayList<Double> stor = new ArrayList<>();
        for(int i = 0; i < org.get(org.size()-1).size(); i++) {
            stor.add(org.get(org.size()-1).get(i).val);
        }
        this.out = stor;
    }
    public void modulate(double max_w, double max_bias) {
        for(int q = 0; q < plan.length; q++) {
            for(int i=0; i < plan[q]; i++) {
                org.get(q).get(i).modulate(max_w, max_bias);
            }
        }
        this.run();
    }
    public double score(ArrayList<ArrayList<Double>> in, ArrayList<ArrayList<Double>> answers) {
        return (new Scorer(this, in, answers)).score;
    }
}

