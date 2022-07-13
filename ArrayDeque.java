public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity){
            Item[] a = (Item[]) new Object[capacity];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
    }

    public void addFirst(Item x){
        if (items.length == size) {
            resize(size + 1);
        }
            items[0] = x;
            size++;
    }

    public void addLast(Item x){
        if (items.length == size){
            resize(size + 1);
        }
        items[size] = x;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Item getFirst(){
        return items[0];
    }

    public Item getLast(){
        return items[size - 1];
    }

    public Item get(int index){
        return items[index];
    }

    public Item removeFirst(){
        Item first = items[0];
        Item[] b = (Item[]) new Object[size];
        System.arraycopy(items, 1, b, 0, size);
        items = b;
        size -= 1;
        return first;
    }

    public Item removeLast(){
        Item last = getLast();
        items[size - 1] = null;
        size -= 1;
        return last;
    }

    public void printDeque(){
        for (int i=0; i < size; i++){
            System.out.print(items[i] + " ");
        }
    }

    public ArrayDeque(ArrayDeque<Item> other){
        items = (Item[]) new Object[size];
        System.arraycopy(other, 0, this, 0, size);
        size = other.size;
    }

    public static void main(String[] args){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.printDeque();
    }

}
