package java_server;
import java_server.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client_server {
        public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                try {
                        Socket soc = new Socket("10.160.82.155", 1000);
                        Socket soc_log = new Socket("10.160.82.155", 1001);
                        Socket soc_log1 = new Socket("10.160.82.155", 1001);

                        ObjectOutputStream writer = new ObjectOutputStream(soc.getOutputStream());
                        ObjectOutputStream writer1 = new ObjectOutputStream(soc.getOutputStream());
                        ObjectOutputStream writer_log = new ObjectOutputStream(soc_log.getOutputStream());
                        ObjectOutputStream writer_log1 = new ObjectOutputStream(soc_log.getOutputStream());
            InputStream reader = soc.getInputStream();
            InputStream reader_log = soc_log.getInputStream();
            InputStream reader_log1 = soc_log.getInputStream();

            System.out.println("INput UserName");
                        String UserName = in.nextLine();
                        
                       
                        writer.writeObject(UserName);
                        System.out.println(reader.read() == 1 ? "User registred suc cock":"User already exist");
                        
                        soc.close();
                        
                        soc = new Socket("10.160.82.155", 1000);
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
                        
                        write_log1.writeObject(UserLogin1);

                        EmailFile efile = new EmailFile(new File("C:\\Users\\fpm.shibitov\\Desktop\\test_file.txt"));
                        
                        String mes_sender = in.next();
                        String mes_resiver = in.next();
                        String mess = in.nextLine();
                        
                        Message messege = new Message(mes_sender, mes_resiver,efile,mess);
                        
                        writer11.writeObject(messege);
                        
                        
                        

                        soc.close();
                        soc_log.close();
                } catch (UnknownHostException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
}
