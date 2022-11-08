package structures;

public abstract class Heap {

    protected Integer[] array;
    protected int size;

    private static final int ROOT = 1;

    private static final int DEFAULT_CAPACITY = 100;

    public Heap() {
        this.size = 0;
        this.array = new Integer[DEFAULT_CAPACITY + 1];
    }

    public void makeEmpty() {
        size = 0;
    }

    public void insert(int nuevo) {
        if (this.isFull()) {
            System.out.println("MONTICULO LLENO");
        }
        this.array[++this.size] = nuevo;
        this.flotar(this.size);
        this.montar();
    }

    public int removeRoot() {
        if (this.isEmpty()) {
            System.out.println("No se puede eliminar un elemento. Montículo vacío.");
        }
        int aux = this.array[ROOT];
        this.array[ROOT] = this.array[this.size--];
        this.percolateDown(ROOT);
        return aux;
    }

    public int removeElement(int element) {
        boolean flag = false;

        for (int i = 1; i < size; i++) {

            if (element == array[i]) {
                this.array[i] = this.array[this.size--];
                this.percolateDown(i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("\nEL ELEMENTO NO SE ENCUENTRA EN EL MONTICULO");
        }
        return element;
    }

    public int getMax() {
        if (this.isEmpty()) {
            System.out.println("MONTICULO VACIO");
        }
        return this.array[ROOT];
    }

    public void printInOrder() {
        Integer[] aux = array.clone();
        sort(aux);

        for (int i = this.size; i >= 1; i--) {
            System.out.print(aux[i - 1] + "\t");
        }
    }

    public void print() {
        if (this.isEmpty()) {
            System.out.println("MONTICULO VACIO");
        } else {
            for (int i = 1; i <= this.size / 2; i++) {
                System.out.print("Padre: " + this.array[i]);
                if (this.tieneHijoIzquierdo(i)) {
                    System.out.print(" HijoIzquierdo: " + this.array[2 * i]);
                }
                if (this.tieneHijoDerecho(i)) {
                    System.out.print(" HijoDerecho: " + this.array[2 * i + 1]);
                }
                System.out.println();
            }
        }
    }

    public Integer find(int element) {

        for (int i = 1; i <= size; i++) {
            if (element == array[i]) {
                return element;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.array.length - 1;
    }

    protected abstract boolean condicion(int hijo, int padre);

    private int padre(int i) {
        return i / 2;
    }

    private int hijoIzquierdo(int i) {
        return 2 * i;
    }

    private int hijoDerecho(int i) {
        return 2 * i + 1;
    }

    private boolean tieneHijoIzquierdo(int i) {
        return this.hijoIzquierdo(i) <= this.size;
    }

    private boolean tieneHijoDerecho(int i) {
        return this.hijoDerecho(i) <= this.size;
    }

    private boolean tieneHijoUnico(int i) {
        return this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
    }


    protected boolean esHoja(int i) {
        return !this.tieneHijoIzquierdo(i) && !this.tieneHijoDerecho(i);
    }

    protected void intercambiar(int i, int j) {
        int tmp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = tmp;
    }

    private void montar() {
        for (int i = this.size / 2; i >= 1; i--) {
            this.percolateDown(i);
        }
    }

    private void flotar(int actual) {
        while (!this.condicion(actual, this.padre(actual))) {
            this.intercambiar(actual, this.padre(actual));
            actual = this.padre(actual);
        }
    }

    private void percolateDown(int i) {
        if (!this.esHoja(i)) {
            if (!this.tieneHijoUnico(i)) {
                if (!this.condicion(this.hijoIzquierdo(i), i) || !this.condicion(this.hijoDerecho(i), i)) {
                    if (!this.condicion(this.hijoIzquierdo(i), this.hijoDerecho(i))) {
                        this.intercambiar(i, this.hijoIzquierdo(i));
                        this.percolateDown(this.hijoIzquierdo(i));
                    } else {
                        this.intercambiar(this.hijoDerecho(i), i);
                        this.percolateDown(this.hijoDerecho(i));
                    }
                }
            } else {
                if (!this.condicion(this.hijoIzquierdo(i), i)) {
                    this.intercambiar(i, this.hijoIzquierdo(i));
                    this.percolateDown(this.hijoIzquierdo(i));
                }
            }
        }
    }

    private void sort(Integer[] array) {
        for (int i = 0; i < size; i++) {
            boolean didSwap = false;
            for (int j = 0; j < size; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Integer temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }
    }

    private void doubleArray() {
        Integer[] arrayAux;

        arrayAux = new Integer[array.length * 2];

        for (int i = 0; i < size; i++, size++) {
            arrayAux[i] = array[i];
        }
        array = arrayAux;
    }

    public void printDraw(){
        printDraw("", size, 1);
    }

    private void printDraw(String prefix, int size, int i) {

        if (size >= i) {
            printDraw(prefix + "     ", size,i+2);
            System.out.println(prefix + ("|-- ") + array[i]);
            printDraw(prefix + "     ", size, i+1);
        }
    }
}