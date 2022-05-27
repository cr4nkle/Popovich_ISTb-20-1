package program.utility;

import program.model.Product;

import java.util.ArrayList;

public class CancelBuffer {
    private ArrayList<Product> bufferList;

    public CancelBuffer(ArrayList list){
        this.bufferList = list;
    }

    public ArrayList<Product> getBufferList() {
        return bufferList;
    }
}
