package structures;

public class MaximumHeap extends Heap{

    public MaximumHeap() {
        super();
        this.array[0] = Integer.MAX_VALUE;
    }

    @Override
    protected boolean condicion(int hijo, int padre) {
        return this.array[hijo] <= this.array[padre];
    }

}