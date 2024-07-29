package CountingSort;

import Common.Order;

import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(1, 5, 2, 4, 3, 7, 6, 8, 0, 9, 2));
        System.out.println(sort(input, Order.DESCENDING));
    }
    //TODO: Implement changing order
    public static List<Integer> sort(List<Integer> input, Order order){
        Map<Integer, Integer> counts = new LinkedHashMap<>();

        for(int i = 0; i <= Collections.max(input); i++){
            counts.put(i, 0);
        }

        List<Integer> output = new LinkedList<>();

        for (Integer element : input){
            counts.put(element, counts.getOrDefault(element, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()){
            for (int i = 0; i < entry.getValue(); i++){
                output.add(entry.getKey());
            }
        }

        return output;
    }
}
