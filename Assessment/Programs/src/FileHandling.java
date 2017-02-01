  import java.io.*;

    public class FileHandling {
        public static void main(String args[]) throws IOException {

            PrintWriter writer = new PrintWriter("/Users/nateshkumar/Documents/CoreJavaTraining/Files/input.txt");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();

            FileInputStream in = null;
            FileOutputStream out = null;

            try {
                in = new FileInputStream("/Users/nateshkumar/Documents/CoreJavaTraining/Files/input.txt");
                out = new FileOutputStream("/Users/nateshkumar/Documents/CoreJavaTraining/Files/output.txt");

                int c;
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
            }
            catch(FileNotFoundException f) {
                f.printStackTrace();
            }
            catch(IOException i)
            {
                i.printStackTrace();
            }

            finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        }

    }


