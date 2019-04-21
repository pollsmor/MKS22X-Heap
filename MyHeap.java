public class MyHeap {
  //idx1 is parent el, idx2 is child el
  private static int[] swap(int[] data, int idx1, int idx2) {
    int temp = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = temp;

    return data;
  }

  private static void pushDown(int[] data, int size, int index) {
    //Swap the element at the desired index with the topmost element so that it can be pushed down
    swap(data, 0, index);
    int elIdx = 0;

    while (2 * elIdx + 1 < size || 2 * elIdx + 2 < size) {
      int leftChildIdx = 2 * elIdx + 1;
      int rightChildIdx = 2 * elIdx + 2;

      if (rightChildIdx == size)  { //only have left branch
        if (data[elIdx] >= data[leftChildIdx])
          return;

        swap(data, elIdx, leftChildIdx);
        return;
      }

      else if (data[elIdx] >= data[leftChildIdx] && data[elIdx] >= data[rightChildIdx]) //children aren't bigger, stop
        return;

      else {
        if (data[leftChildIdx] >= data[rightChildIdx]) { //left child is bigger
          swap(data, elIdx, leftChildIdx);
          elIdx = leftChildIdx;
        }

        else { //right child is bigger
          swap(data, elIdx, rightChildIdx);
          elIdx = rightChildIdx;
        }
      }
    }
  }

  private static void pushUp(int[] data, int index) {
    //Swap the element at the desired index with the bottomost element so that it can be pushed up
    int size = data.length;
    swap(data, size - 1, index);
    int elIdx = size - 1;

    while ( (elIdx - 1) / 2 >= 0) {
      int parentIdx = (elIdx - 1) / 2;

      if (data[elIdx] <= data[parentIdx]) //parent is bigger, stop
        return;

      else { //parent is smaller, keep going
        swap(data, elIdx, parentIdx);
        elIdx = parentIdx;
      }
    }
  }

  public static void heapify(int[] data) {
    for (int i = data.length - 1; i >= 0; --i)
      pushDown(data, data.length, i);
  }

  public static void heapsort(int[] data) {
    heapify(data);
    int size = data.length;

    while (size > 0) {
      swap(data, 0, size - 1);
      --size;
      pushDown(data, size, 0);
    }
  }
}
