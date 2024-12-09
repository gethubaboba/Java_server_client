package java_server;
import java_server.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client_server {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Socket soc = new Socket("10.150.3.60", 1000);
            Socket soc_log = new Socket("10.150.3.60", 1001);
            Socket soc_log1 = new Socket("10.150.3.60", 1001);

            ObjectOutputStream writer = new ObjectOutputStream(soc.getOutputStream());
            ObjectOutputStream writer_log = new ObjectOutputStream(soc_log.getOutputStream());
            ObjectOutputStream writer_log1 = new ObjectOutputStream(soc_log1.getOutputStream());
            InputStream reader = soc.getInputStream();
            ObjectInputStream reader_log = new ObjectInputStream(soc_log.getInputStream());

            System.out.println("INput UserName");
            String UserName = in.nextLine();


            writer.writeObject(UserName);
            System.out.println(reader.read() == 1 ? "User registred suc cock":"User already exist");

            soc.close();

            soc = new Socket("10.150.3.60", 1000);
            ObjectOutputStream writer11 = new ObjectOutputStream(soc.getOutputStream());
            InputStream reader1 = soc.getInputStream();

            String UserName1 = in.nextLine();

            writer11.writeObject(UserName1);
            System.out.println(reader1.read() == 1 ? "User registred suc cock":"User already exist");



            System.out.println("INput Login");
            String UserLogin = in.nextLine();

            writer_log.writeObject(UserLogin);
            System.out.println(reader_log.read() == 1 ? "User logined suc cock":"UserLogin already exist");

            System.out.println("INput Login");
            String UserLogin1 = in.nextLine();

            ObjectInputStream reader_log1 = new ObjectInputStream(soc_log1.getInputStream());

            writer_log1.writeObject(UserLogin1);
            System.out.println(reader_log1.read() == 1 ? "User logined suc cock":"UserLogin already exist");

            EmailFile efile = new EmailFile(new File("C:\\Users\\fpm.shibitov\\Desktop\\test_file.txt"));
            System.out.println("write sender");
            String mes_sender = in.next();
            System.out.println("write resiver");
            String mes_resiver = in.next();
            in.nextLine();
            System.out.println("write messege");
            String mess = in.nextLine();

            Message messege = new Message(mes_sender, mes_resiver,efile,mess);

            writer_log.writeObject(messege);



            Message m = (Message) reader_log1.readObject();

            System.out.println(m.message);

            soc.close();
            soc_log.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
