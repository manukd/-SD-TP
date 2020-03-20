import visidia.simulation.process.algorithm.LC2_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;
public class SpanningT_TP5 extends LC2_Algorithm {
    @Override
    public Object clone() {
        return new SpanningT_TP5();
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    protected void beforeStart() {
        setLocalProperty("label", vertex.getLabel());
    }

    @Override
    protected void onStarCenter() {
        boolean bool = true;
        for (int i : getActiveDoors()) {
            if (getLocalProperty("label").equals("A") && getNeighborProperty(i, "label").equals("N") && !(getEdgeProperty(i, "label").equals("actif"))) {
                setNeighborProperty(i,"label", "A");
                setDoorState(new MarkedState(true), i);
                setEdgeProperty(i, "label", "actif");
                bool = false;
            }
            if (bool) {
                if (getLocalProperty("label").equals("A")) {
                    localTermination();
                }
            }
        }
    }
}
