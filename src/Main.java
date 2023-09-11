import java.math.MathContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.DATE;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Problem 1
//        String name = in.next();
//        Integer age = in.nextInt();
//        User firstUser = new User(name, age);
//        name = in.next();
//        age = in.nextInt();
//        User secondUser = new User(name, age);
//        if (firstUser.getAge() > secondUser.getAge())
//            System.out.println(secondUser.toString());
//        else
//            System.out.println(firstUser.toString());

        //Problem2
//        ArrayList<User> arrayList = new ArrayList<User>();
//        for(int i = 0; i < 5; ++i){
//            arrayList.add(new User(in.next(), in.nextInt()));
//        }
//        Collections.sort(arrayList, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getAge().compareTo(o2.getAge());
//            }
//        });
//        for(User i : arrayList){
//            System.out.println(i.toString());
//        }
        String name;
        Integer age;
        HashMap<Integer, List<User>> hashMap = new HashMap<>();
        for(int i = 0; i < 5; ++i){
            name = in.next();
            age = in.nextInt();
            User user = new User(name, age);
            if(!hashMap.containsKey(age)){
                hashMap.put(age, new ArrayList<>());
            }
            hashMap.get(age).add(user);
        }
        System.out.println("Enter the user's age");
        int userAge = in.nextInt();
        if(hashMap.containsKey(userAge)){
            List<User> arr = hashMap.get(userAge);
            Collections.sort(arr, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            System.out.println(arr);
        }
        else
            System.out.println("User is not found");
    }
}
