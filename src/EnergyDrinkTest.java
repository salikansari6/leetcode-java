import java.util.LinkedList;
import java.util.ListIterator;

public class EnergyDrinkTest {
    public static void main(String[] args) {
        int[] arr = {10, 4, 22, 9, 5, 11, 8};
        LinkedList<Integer> energies = new LinkedList<Integer>();
        for(int num : arr){
            energies.add(num);
        }

        int hours = 0;
        int i = 1 ;
        while(energies.get(i) < energies.get(i - 1)){
            if(i > 0){
                if(energies.get(i) > energies.get(i - 1)){
                    energies.remove(i);
                }
                i++;
            }
            hours++;
            i = 1;
        }

        System.out.println(energies.toString());
    }
}
