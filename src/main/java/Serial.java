import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serial implements Serializable {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Class<Boardgame> aClass = Boardgame.class;

        Boardgame boardgame = new Boardgame();

        System.out.println(boardgame.getClass());

        String write = printFields(boardgame);


        try (FileOutputStream out = new FileOutputStream("fileclass.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            assert write != null;
            byte[] buffer = write.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }



    private static String printFields(Boardgame boardgame) throws IllegalAccessException {
        Field[] fields = boardgame.getClass().getDeclaredFields();
        for (Field declaredField : fields) {
            System.out.print(
                    Modifier.toString(declaredField.getModifiers()) + " " +
                            declaredField.getType().getSimpleName() + " " +
                            declaredField.getName() + ": ");
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(boardgame));
        }
        return String.valueOf(fields);
    }

}
