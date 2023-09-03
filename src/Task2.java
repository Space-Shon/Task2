import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static java.util.Calendar.DATE;
public class Task2 {

    public static void problem1(){
            Scanner in = new Scanner(System.in);
            System.out.println("Как тебя зовут?");
            String name = in.nextLine();
            System.out.printf("Привет, %s!", name);
    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        String s = String.join("", a % 5 == 0 ? "a=" + a + ' ' : "", b % 5 == 0 ? "b=" + b + ' ' : "", c % 5 == 0 ? "c=" + c : "");
        System.out.println(!s.isEmpty() ? s : "Нет значений, кратных 5");
        System.out.println(a / b);
        System.out.println((double)a / b);
        System.out.println(Math.ceil((double)a / b));
        System.out.println(Math.floor((double)a / b));
        System.out.println(Math.round((double)a / b));
        System.out.println(b % c);
        System.out.println(Math.min(a, b));
        System.out.println(Math.min(b, c));
    }
    public static void problem3(){
        Random rd = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 20; ++i){
            arrayList.add(rd.nextInt(1, 16));
        }
        for(int i : arrayList){
            System.out.print(i + " ");
        }
        System.out.println("\n");
        Collections.sort(arrayList);
        for(int i : arrayList){
            System.out.print(i + " ");
        }
        System.out.println('\n');
        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        int tmpNumber = arrayList.get(0);
        int cnt = 1;
        for(int i = 1; i < arrayList.size(); ++i){
            if(tmpNumber == arrayList.get(i)){
                cnt++;
            }
            else{
                myHashMap.put(arrayList.get(i - 1), cnt);
                cnt = 1;
                tmpNumber = arrayList.get(i);
            }
            if(arrayList.size() - 1 == i)
                myHashMap.put(tmpNumber, cnt);
        }
        for(Map.Entry<Integer, Integer> entry: myHashMap.entrySet())
            if(entry.getValue() == 2 || entry.getValue() == 3 || entry.getValue() == 4)
                System.out.printf("Число %d встречается %d раза\n", entry.getKey(), entry.getValue());
            else if(entry.getValue() != 1 && entry.getValue() > 1)
                System.out.printf("Число %d встречается %d раз\n", entry.getKey(), entry.getValue());
    }

    public static void problem4(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String substrS = in.nextLine();
        int numberSubstr = str.indexOf(substrS);
        int cnt = 0;
        while(numberSubstr != -1){
            cnt++;
            str = str.substring(numberSubstr + 1);
            numberSubstr = str.indexOf(substrS);
        }
        System.out.println(cnt);
        String str2 = in.nextLine().replaceAll("([Кк]ака($|\\s))|([Бб]яка(\\s|$))", "вырезано цензурой");
        System.out.println(str2);

        String str3 = in.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = simpleDateFormat.parse(str3);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String result = simpleDateFormat1.format(date);
            System.out.println(result);
        }catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + simpleDateFormat);
        }
    }

    public static void problem5(){
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        String date2 = in.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date parsingDate;
        Date parsingDate2;
        try {
            parsingDate = simpleDateFormat.parse(date);
            parsingDate2 = simpleDateFormat.parse(date2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsingDate);
        calendar.add(Calendar.DATE, 45);
        System.out.println(calendar.getTime());
        calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1);
        System.out.println(calendar.getTime());
        int number = 10;
        for(int i = 0; i < number; ++i){
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
                calendar.add(DATE, 2);
            }
            calendar.add(DATE, 1);
        }
        System.out.println(calendar.getTime());
        long difference = parsingDate.getTime() - parsingDate2.getTime();
        int days =  (int)(difference / (24 * 60 * 60 * 1000));
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(parsingDate.after(parsingDate2) ? parsingDate2 : parsingDate);
        days = Math.abs(days);
        int daysWork = 0;
        for(int i = 0; i < days; ++i){
            if(calendar1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY || calendar1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
                daysWork++;
                calendar1.add(DATE, 1);
            }
            calendar1.add(DATE, 1);
        }
        System.out.println(daysWork);
    }

}
