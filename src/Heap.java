import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        int parentIndex = getParentIndex(currentIndex);
        while (parentIndex >= 0 && heap.get(currentIndex) < heap.get(parentIndex)) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
    }

    public boolean contains(int value) {
        List<Integer> visitedElements = new ArrayList<>();
        for (int i = 0; i < heap.size(); i++) {
            visitedElements.add(heap.get(i));
            if (heap.get(i) == value) {
                System.out.println("Visited elements before finding " + value + ": " + visitedElements);
                return true;
            }
        }
        return false;
    }


    public void delete(int value) {
        int indexToRemove = heap.indexOf(value);
        if (indexToRemove == -1) {
            System.out.println(value + " not found in the heap.");
            return;
        }
        heap.set(indexToRemove, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(indexToRemove);
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);
        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public void printHeap() {
        System.out.println("Heap: " + heap);
    }
}
