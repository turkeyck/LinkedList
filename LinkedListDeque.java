import java.util.Objects;

public class LinkedListDeque {



    private static class LList {
        int item;
        public LList previous;
        public LList next;

        public LList(LList p, int i, LList n) {
            item = i;
            previous = p;
            next = n;
        }
    }

        public LList sentinel;
        public LList sentinellast;
        public LinkedListDeque(){
            sentinel = new LList(null, 51, sentinellast);
            sentinellast = new LList(sentinel,101, null);
            size = 0;
        }

        public int size;
        public LinkedListDeque(int x){
            sentinel = new LList(null,51, null);
            sentinellast = new LList(sentinel, 101, null);
            sentinel.next = new LList(sentinel, x, sentinellast);
            sentinellast.previous = sentinel.next;
            size = 1;
        }


        public void addFirst(int y){
            sentinel.next = new LList(sentinel,y, sentinel.next);
            sentinel.next.next.previous = sentinel.next;
            size += 1;
        }

        public int getfirst(){
            return sentinel.next.item;
        }

        public void addLast(int y){
            sentinellast.previous = new LList(sentinellast.previous, y, sentinellast);
            sentinellast.previous.previous.next = sentinellast.previous;
            size += 1;
        }

        public int getLast(){
            return sentinellast.previous.item;

        }


        public int size() {
            return size;
        }

        public boolean isEmpty(){
            if (size == 0){return true;}
            return false;
        }

        public void printDeque(){
            LList p = sentinel.next;
            LList pp = sentinellast;
            while (p.next != null) {
                    System.out.print(p.item + " ");
                    p = p.next;
                }
            System.out.println("\n");
        }

        public void removeFirst(){
            sentinel.next.next.previous = sentinel.next.previous;
            sentinel.next = sentinel.next.next;
            size -= 1;
        }

        public void removeLast(){
            sentinellast.previous.previous.next = sentinellast.previous.next;
            sentinellast.previous = sentinellast.previous.previous;
            size -= 1;
        }

        /**iterative method */
        public int get(int index){
            LList pt = sentinel.next;
            int i = 0;
            while (i != index){
                pt = pt.next;
                i += 1;
            }
            return pt.item;
        }

        /** deepcopy of LinkedListDeque other */
        public LinkedListDeque(LinkedListDeque other){
//            sentinel = new LList(null,51, null);
//            sentinellast = new LList(sentinel, 101, null);
            for (int j = 0; j < other.size; j++){
                if (j==0){
                /** same as public LinkedListDeque(int x) */
                sentinel = new LList(null,51, null);
                sentinellast = new LList(sentinel, 101, null);
                sentinel.next = new LList(sentinel, other.get(j), sentinellast);
                sentinellast.previous = sentinel.next;
                size = 1;}
                if (j > 0){
                /** same as public addLast(int x) */
                sentinellast.previous = new LList(sentinellast.previous, other.get(j), sentinellast);
                sentinellast.previous.previous.next = sentinellast.previous;
                size += 1;}

            }

        }

        /** recursive method */
        public int getRecursive(int index){
            int i = index;
            LList pt = sentinel.next;
            if (index == 0){
                return sentinel.next.item;
            }
            return getRecursive(index-1);

        }


        public static void main(String[] args){

            /** Create two lists, DL and DLL:
                DL is an empty list, while DLL is (43, 44, 45, 90, 91, 92). */
            LinkedListDeque DL = new LinkedListDeque();
            LinkedListDeque DLL = new LinkedListDeque(90);
            DLL.addFirst(45);
            DLL.addFirst(44);
            DLL.addFirst(43);
            DLL.addLast(91);
            DLL.addLast(92);

            /** Test functionalities: printDeque, removeLast, removeFirst, get, getrecursive,
             * and deepcopy. */
            System.out.println(DLL.getfirst());
            System.out.println(DLL.getLast());
            System.out.println(DLL.isEmpty());
//            DLL.printDeque();
            DLL.removeFirst();
//            DLL.printDeque();
            DLL.removeLast();
//            DLL.printDeque();
            DLL.addLast(99);
            DLL.addFirst(43);
            DLL.printDeque();
//
//            for (int i = 0; i<DLL.size; i++){
//                System.out.println(DLL.get(i));
//            }
            LinkedListDeque DLLcopy = new LinkedListDeque(DLL);
            DLLcopy.printDeque();
        }

}


