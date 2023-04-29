
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 public class App {
    public static void main(String[] args) {
        try {
            String filename = args[0];
            if (!filename.endsWith(".arxml")) {
                throw new NotVaildAutosarFileException("Not Valid File Exception");
            }

            File file = new File(filename);

            if (file.length()==0){
                throw new EmptyAutosarFileException("Empty File");
            }

            int d;
            StringBuilder stringBuilder = new StringBuilder();
           // InputStream inputStream = new FileInputStream(file);
            FileReader reader = new FileReader(file);
                while ((d = reader.read()) != -1) {
                    stringBuilder.append((char) d);
                }


            String data = stringBuilder.toString();
            Scanner scanner = new Scanner(data);
            ArrayList<Container> containers = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains("<CONTAINER UUID=")) {

                    String uuId = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
                    String sName = scanner.nextLine().trim();
                    String s = sName.substring(sName.indexOf(">") + 1, sName.indexOf("</"));
                    String lName = scanner.nextLine().trim();
                    String l = lName.substring(lName.indexOf(">") + 1, lName.indexOf("</"));
                    Container container = new Container();
                    container.setUuid(uuId);
                    container.setShortname(sName);
                    container.setLongname(lName);
                    containers.add(container);
                }
            }
            scanner.close();

            Collections.sort(containers);
            String outName = filename.substring(0, filename.indexOf(".")) + "_mod.html";
            FileOutputStream outputStream = new FileOutputStream(outName);
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write("<AUTOSAR>\n".getBytes());
            for (int i = 0; i < containers.size(); i++) {
                outputStream.write(containers.get(i).toString().getBytes());
            }
            outputStream.write("</AUTOSAR>\n".getBytes());
            outputStream.close();

        } catch (NotVaildAutosarFileException e) {
            e.printStackTrace();
        } catch (EmptyAutosarFileException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
