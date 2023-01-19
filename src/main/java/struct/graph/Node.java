package struct.graph;

/**
 * @author jwang55
 */
public class Node {
    int no;
    int value;
//        boolean visited;

    public Node() {
    }

    public Node(int no, int value) {
        this.no = no;
        this.value = value;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
