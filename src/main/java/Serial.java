import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serial implements Serializable {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Class<Boardgame> aClass = Boardgame.class;

        Boardgame boardgame = new Boardgame();

        BGStore bgStore = new BGStore();

        String write = printFields(boardgame);

        write = write + printFields(bgStore);


        try (FileOutputStream out = new FileOutputStream("fileclass.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            assert write != null;
            byte[] buffer = write.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        FileReader fileReader = new FileReader("fileclass.txt");
        File f = new File("fileclass.txt");
        int f2 = (int) f.length();
        char [] a = new char[f2];
        fileReader.read(a);
        for(char c : a)
            System.out.print(c);
        fileReader.close();

    }



    private static String printFields(Object boardgame) throws IllegalAccessException {
        Field[] fields = boardgame.getClass().getDeclaredFields();
        String text = boardgame.getClass() + "\r\n";
        for (Field declaredField : fields) {
            text = text + (
                    Modifier.toString(declaredField.getModifiers()) + " " +
                            declaredField.getType().getSimpleName() + " " +
                            declaredField.getName() + ": ");
            declaredField.setAccessible(true);
            text = text + (declaredField.get(boardgame)) + "\r\n";
        }
        return text;
    }

}
