package Lession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;


class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();


    public void add(String name, Integer phoneNum) {
      if(phoneBook.containsKey (name))
      {
        phoneBook.get(name).add(phoneNum);
      }
      else
      {
        ArrayList<Integer> _list = new ArrayList<>();
        _list.add(phoneNum);
        phoneBook.put(name, _list);
      }


    }

    public ArrayList<Integer> find(String name) {
        
        return phoneBook.containsKey (name)? phoneBook.get(name):new ArrayList<>();
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    public static LinkedHashMap<String, ArrayList<Integer>> getPhoneBookDesc ()
    {

        LinkedHashMap<String, ArrayList<Integer>> _result = new LinkedHashMap<>();

        Integer max = -1;
        for(var item :phoneBook.entrySet()){
            if (item.getValue().size()>max){
                max = item.getValue().size();
            }
        }
        while (max!=-1) {
            for(var item :phoneBook.entrySet()){
                if (item.getValue().size()==max){
                    _result.put(item.getKey(), item.getValue());
                }
            }
            max=max-1;
        }



        return _result;
    }

}
// Не удаляйте этот класс - он нужен для 

public class Task_5_1 {

    public static void main(String[] args) {
       

      
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Ivanov", 122234);
        myPhoneBook.add("Ivanov", 4356723);
        myPhoneBook.add("Ivanov", 6653556);
        myPhoneBook.add("Petrov", 122234);
        myPhoneBook.add("Sorokin", 4356723);
        myPhoneBook.add("Petrov", 6653556);

        System.out.println(myPhoneBook.find("Petrov"));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
        System.out.println(PhoneBook.getPhoneBookDesc());

    }
}
