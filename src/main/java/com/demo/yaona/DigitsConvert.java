package com.demo.yaona;


import java.util.*;

public class DigitsConvert {
  private static Map<String, String[]> RULER = new HashMap<>();

  static {
    RULER.put("0", null);
    RULER.put("1", null);
    RULER.put("2", new String[]{"A", "B", "C"});
    RULER.put("3", new String[]{"D", "E", "F"});
    RULER.put("4", new String[]{"G", "H", "I"});
    RULER.put("5", new String[]{"J", "K", "L"});
    RULER.put("6", new String[]{"M", "N", "O"});
    RULER.put("7", new String[]{"P", "Q", "R", "S"});
    RULER.put("8", new String[]{"T", "U", "V"});
    RULER.put("9", new String[]{"W", "X", "Y", "Z"});
    RULER.put("*", null);
    RULER.put("#", null);
  }

  /**
   * @param digits convert digits to letters
   */
  public static void convert(String... digits) {
    List<List<String>> dimvalue = new ArrayList<>();
    List<String> result = new ArrayList<>();
    for (String arg : digits) {
      String[] strings = RULER.get(arg);
      if (strings != null) {
        List<String> objects = new ArrayList<>();
        Collections.addAll(objects, strings);
        dimvalue.add(objects);
      }


    }
    run(dimvalue, result, 0, "");

    int i = 1;
    for (String s : result) {
      System.out.print(s + "\t");
    }
    System.out.println();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    String[] arr = new String[]{"2","3"};
    convert(arr);
    convert("9");
    convert("1", "0");
  }

  public static void run(List<List<String>> dimvalue, List<String> result, int layer, String curstring) {
    //大于一个集合时：
    if (layer < dimvalue.size() - 1) {
      //大于一个集合时，第一个集合为空
      if (dimvalue.get(layer).size() == 0) {
        run(dimvalue, result, layer + 1, curstring);
      } else {
        for (int i = 0; i < dimvalue.get(layer).size(); i++) {
          StringBuilder s1 = new StringBuilder();
          s1.append(curstring);
          s1.append(dimvalue.get(layer).get(i));
          run(dimvalue, result, layer + 1, s1.toString());
        }
      }
    }
    //只有一个集合时：
    else if (layer == dimvalue.size() - 1) {
      //只有一个集合，且集合中没有元素
      if (dimvalue.get(layer).size() == 0) {
        result.add(curstring);
      }
      //只有一个集合，且集合中有元素时：其笛卡尔积就是这个集合元素本身
      else {
        for (int i = 0; i < dimvalue.get(layer).size(); i++) {
          result.add(curstring + dimvalue.get(layer).get(i));
        }
      }
    }
  }

}
