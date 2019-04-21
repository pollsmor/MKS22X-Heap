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

    while (2 * index + 1 < size || 2 * index + 2 < size) {
      int leftChildIdx = 2 * index + 1;
      int rightChildIdx = 2 * index + 2;

      if (rightChildIdx == size)  { //only have left branch
        if (data[index] < data[leftChildIdx])
          swap(data, index, leftChildIdx); //do the final swap so larger child is swapped with smaller parent

        return;
      }

      else if (data[index] >= data[leftChildIdx] && data[index] >= data[rightChildIdx]) //children aren't bigger, stop
        return;

      else {
        if (data[leftChildIdx] >= data[rightChildIdx]) { //left child is bigger
          swap(data, index, leftChildIdx);
          index = leftChildIdx;
        }

        else { //right child is bigger
          swap(data, index, rightChildIdx);
          index = rightChildIdx;
        }
      }
    }
  }

  private static void pushUp(int[] data, int index) {
    //Swap the element at the desired index with the bottomost element so that it can be pushed up
    int size = data.length;
    swap(data, size - 1, index);
    index =  size - 1;

    while ( (index - 1) / 2 >= 0) {
      int parentIdx = (index - 1) / 2;

      if (data[index] <= data[parentIdx]) { //parent is bigger, stop
        return;
      }

      else { //parent is smaller, keep going
        swap(data, index, parentIdx);
        index = parentIdx;
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
