public class MyHeap {
  public static void pushDown(int[] data, int size, int index) {
    //Swap the element at the desired index with the topmost element so that it can be pushed down
    System.out.println(printArr(data));
    swap(data, 0, index);
    int elIdx = 0;
    System.out.println("swap: " + printArr(data));

    while (2 * elIdx + 1 < size || 2 * elIdx + 2 < size) {
      if (data[elIdx] >= data[2 * elIdx + 1] && data[elIdx] >= data[2 * elIdx + 2])
        return;

      else if ( (2 * elIdx + 1 <= size) && (2 * elIdx + 2 > size) ) { //only have left branch
        swap(data, elIdx, 2 * elIdx + 1);
        elIdx = 2 * elIdx + 1;
      }

      else {
        if (data[2 * elIdx + 1] >= data[2 * elIdx + 2]) {
          swap(data, elIdx, 2 * elIdx + 1);
          elIdx = 2 * elIdx + 1;
        }

        else {
          swap(data, elIdx, 2 * elIdx + 2);
          elIdx = 2 * elIdx + 2;
        }
      }

      System.out.println(printArr(data));
    }
  }

  private static String printArr(int[] data) {
    String output = "";
    for (int i = 0; i < data.length; ++i) {
      output += data[i] + "(" + i + ")" + " ";
    }

    return output;
  }

  private static int[] swap(int[] data, int idx1, int idx2) {
    //idx1 is parent el, idx2 is child el
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
