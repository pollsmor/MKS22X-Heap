public class Driver {
  private static String printArr(int[] data) {
    String output = "";
    for (int i = 0; i < data.length; ++i)
      output += data[i] + " ";

    return output;
  }

  public static void main(String[] args) {
    int[] test = {5, 8, 16, 12, 7, 0, 4, 900, 20, -5, -2, 30, 40, 851, 387, 34, 571, -25491};
    int[] test2 = {5, 8, 16, 12, 7, 0, 4, 900, 20, -5, -2, 30, 40, 851, 387, 34, 8000, 941, 571, -25491, 8512581};

    System.out.println(HeapHelp.toString(test2));
    //MyHeap.pushDown(test, 21, 20);
    //MyHeap.pushUp(test, 2);
    //MyHeap.heapify(test2);
    MyHeap.heapsort(test2);

    System.out.println(HeapHelp.toString(test2));
    System.out.println(printArr(test2));
  }
}
