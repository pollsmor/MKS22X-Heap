public class MyHeap {
  public static void pushDown(int[] data, int size, int index) {
    //Swap the element at the desired index with the topmost element so that it can be pushed down
    System.out.println(printArr(data));
    swap(data, 0, index);
    int elIdx = 0;
    System.out.println("swap: " + printArr(data));

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

      System.out.println(printArr(data));
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

  private static void pushUp(int[] data, int index) {

  }

  public static void heapify(int[] data) {

  }

  public static void heapsort(int[] data) {

  }
}
