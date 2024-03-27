public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(15);
        heap.insert(40);
        heap.insert(30);
        heap.insert(50);
        heap.insert(10);
        heap.insert(100);
        heap.insert(40);

        // Check if 40 is in the heap and print visited elements
        System.out.println("Check if 40 is in the heap:");
        if (heap.contains(40)) {
            System.out.println("40 is in the heap.");
        } else {
            System.out.println("40 is not in the heap.");
        }

        heap.delete(10);
        heap.printHeap();
    }
}
