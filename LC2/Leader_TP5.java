import visidia.simulation.process.algorithm.LC2_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;
public class Leader_TP5 extends LC2_Algorithm {
    @Override
    public Object clone() {
        return new Leader_TP5();
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    protected void beforeStart() {
        setLocalProperty("label", vertex.getLabel());
        setLocalProperty("compteur", String.valueOf(getArity()));
    }

    @Override
    protected void onStarCenter() {
        if (getLocalProperty("label").equals("N")) {
            boolean bool = true;
            for (int i : getActiveDoors()) {
                if (getLocalProperty("label").equals("N") && getNeighborProperty(i, "label").equals("N") && getNeighborProperty(i, "compteur").equals("1")) {
                    setNeighborProperty(i,"label", "F");
                    int add = Integer.parseInt((String)getLocalProperty("compteur"));
                    add -= 1;
                    setLocalProperty("compteur", String.valueOf(add));
                }
                if (getNeighborProperty(i, "label").equals("N")) {
                    bool = false;
                }
            }
            if (bool) {
                setLocalProperty("label", "E");
            }
        }
        if (getLocalProperty("label").equals("F")) {
            localTermination();
        }
    }
}
