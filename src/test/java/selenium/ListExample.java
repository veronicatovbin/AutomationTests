package selenium;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        String[] names = new String[5];
        names[0] = "John";
        names[1] = "Sandy";

        for (int i = 0; i < names.length; i++) {
            //System.out.println(names[i]);
        }

        List<String> namesList = new ArrayList<>();
        namesList.add("John");
        namesList.add("Nancy");
        namesList.add("Sam");

        for (String name : namesList){
            System.out.println(name);
        }

        for (int i = 0; i < namesList.size(); i++) {
            System.out.println(namesList.get(i));
        }

    }
}
