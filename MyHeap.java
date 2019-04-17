public class MyHeap {
  private static void pushDown(int[] data, int size, int index) {
    //Swap the element at the desired index with the topmost element so that it can be pushed down
    swap(data, 0, index);
    int elIdx = 0;

    while (elIdx <= size) {
      if (2 * elIdx + 1 > size) //at bottomost branch, can't go any lower
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
    }
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
