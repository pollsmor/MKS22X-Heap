public class MyHeap {
  public static void pushDown(int[] data, int size, int index) {
    //Swap the element at the desired index with the topmost element so that it can be pushed down
    swap(data, 0, index);
    int elIdx = 0;

    while (2 * elIdx + 1 < size || 2 * elIdx + 2 < size) {
      int leftChildIdx = 2 * elIdx + 1;
      int rightChildIdx = 2 * elIdx + 2;

      if (data[elIdx] >= data[leftChildIdx] && data[elIdx] >= data[rightChildIdx]) //children aren't bigger, stop
        return;

      else if ( (leftChildIdx < size) && (rightChildIdx >= size) ) { //only have left branch
        swap(data, elIdx, leftChildIdx);
        elIdx = leftChildIdx;
      }

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

  public static void pushUp(int[] data, int index) {
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

  //Just for debugging, prints idx w/ data
  private static String printArr(int[] data) {
    String output = "";
    for (int i = 0; i < data.length; ++i) {
      output += data[i] + "(" + i + ")" + " ";
    }

    return output;
  }

  //idx1 is parent el, idx2 is child el
  private static int[] swap(int[] data, int idx1, int idx2) {
    int temp = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = temp;

    return data;
  }

  public static void heapify(int[] data) {

  }

  public static void heapsort(int[] data) {

  }
}
