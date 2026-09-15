public class Vector {
    private String[] elements;
    private int size;

    public Vector(final int size) {
        this.elements = new String[size];
        this.size = 0;
    }


    public boolean add(final String element) throws Exception {
        updateSize();

        if (size < elements.length) {
            elements[size] = element;
            size++;
            return  true;
        }else{
            return false;
        }
    }

    private void updateSize() {
        if(size == elements.length) {
            String[] newElements = new String[elements.length * 2];

            for(int i = 0; i< elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
}
