import java.io.*;
import java.lang.reflect.Field;

public class Deserial {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {

        try (FileReader fileReader = new FileReader("fileclass.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line = bufferedReader.readLine();
            Class clasz = Class.forName(line);
            Object object = clasz.newInstance();

            System.out.println(clasz);

            Field name = clasz.getDeclaredField("name");
            name.setAccessible(true);
            String nameof = (String) name.get(object);
            System.out.println(name.getName() + " " + nameof);

            Field diff = clasz.getDeclaredField("difficulty");
            diff.setAccessible(true);
            String  diffof = (String) diff.get(object);
            System.out.println(diff.getName() + " " + diffof);

            Field cost = clasz.getDeclaredField("cost");
            cost.setAccessible(true);
            int costof = cost.getInt(object);
            System.out.println(cost.getName() + " " + costof);

            Field vict = clasz.getDeclaredField("victoryChance");
            vict.setAccessible(true);
            Double victof = vict.getDouble(object);
            System.out.println(vict.getName() + " " + victof);

//            Field bg = clasz.getDeclaredField("bgStore");
//            String  bgof = bg.getName();
//            System.out.println(bg.getName() + " " + bgof);
//

//
//            Field store = clasz.getDeclaredField("nameStore");
//            store.setAccessible(true);
//            String storeof = (String) store.get(object);
//            System.out.println(storeof);

            // TODO: 28.05.2020 заполнение полей object

        }
    }

}
