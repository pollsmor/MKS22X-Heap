public class Driver {
  private static String printArr(int[] data) {
    String output = "";
    for (int i = 0; i < data.length; ++i) {
      output += data[i] + "(" + i + ")" + " ";
    }

    return output;
  }

  public static void main(String[] args) {
    int[] test = {5, 8, 16, 12, 7, 0, 4, 900, 20, -5};

    System.out.println(HeapHelp.toString(test));

    MyHeap.pushDown(test, 10, 9);

    System.out.println(HeapHelp.toString(test));
  }
}
