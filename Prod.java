import java.io.File;
import java.io.IOException;
import java.util.*;


public class Prod{

    Prod(){
        System.out.println("Application Name: Project 1");
        System.out.println("Developer: Jenish T S \n");
        System.out.println("Welcome To the Application");
        System.out.println("Select an Option");
        System.out.println("\n 1.Files List \n 2.File Manipulation \n 3.Close Application \n" );
        System.out.println("Choose an Option:");

    }

    void loptions(){
        System.out.println("Application Name: Project 1");
        System.out.println("Developer: Jenish T S \n");
        System.out.println("Welcome To the Application");
        System.out.println("Select an Option");
        System.out.println("\n 1.Files List \n 2.File Manipulation \n 3.Close Application \n" );
        System.out.println("Choose an Option:");

    }
    void Filesare_option1(Prod b, File f){
        System.out.println("The Files are");
        b.list(f);
    }










    public static void main(String args[]) {

        Prod p= new Prod();

        File f= new File("C:\\Users\\jenis\\Documents\\project");
        int choice=0;
        Scanner input= new Scanner(System.in);

        int check=0;
        do {
            try {
                choice = input.nextInt();
                for(int i=1;i<4;i++) {
                    if(i==choice) {
                        check++;
                        break;
                    }
                }
                if(check!=1) {
                    System.out.println("Enter a valid Number");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Enter a Valid Input");
                input.next();
            }
        }while(check ==0);

//-------------------------choice1----------------------
//        if(choice ==1) {
//            System.out.println("The Files are");
//            p.list(f);
//        }

//        Changed it in to method
        if(choice ==1) {
            p.Filesare_option1(p,f);
        }




//------------------------------choice 2-------------------
        else if(choice == 2) {
            System.out.println("Enter an Option");
            System.out.println("\n 1.Add File \n 2.Search File \n 3.Delete File");
            int num=0;
            do {
                try {

                    num= input.nextInt();
                    for(int i=1;i<4;i++) {
                        if(i==num) {
                            check++;
                            break;
                        }
                    }
                    if(check!=1) {
                        System.out.println("Enter a valid Number");//if integer other than 1,2,3
                    }
                }
                catch(InputMismatchException e) {
                    System.out.println("Enter a Valid Input");//if non integer
                    input.next();
                }
            }while(check ==0);

            //--------2---choice1-----------------------
            if(num ==1) {
                System.out.println("New File Name:");
                do {
                    if(p.addFile(input.next())) {
                        System.out.println("File Created");
                        break;
                    }
                    else
                        System.out.println("Enter a file name with valid extension");

                }while(true);


            }
            //-------2--------choice 2--------------------
            else if(num==2) {
                System.out.println("Enter the file name with valid Extension");
                String name=input.next();
                check=0;
                for(String s: f.list()) {
                    if(s.equalsIgnoreCase(name)) {
                        System.out.println("The file is present");
                        check++;
                        break;
                    }

                }
                if(check==0) {
                    System.out.println("file not present");
                }

            }
            //------2---------choice3-------------------------
            else if(num==3) {
                System.out.println("File to be Deleted:");
                String name=input.next();
                check=0;
                File[] listFiles = f.listFiles();
                for(int i=0;i<listFiles.length;i++) {
                    if(name.equalsIgnoreCase(listFiles[i].getName())) {
                        check++;
                        if(listFiles[i].delete()) {
                            System.out.println("File deleted");
                        }
                        else
                            System.out.println("Retry deleting the file");
                        break;

                    }
                }
                if(check==0) {
                    System.out.println("No such File exists");
                }
            }




        }
//----------------choice3-----------------------------
        else if(choice == 3) {
            System.out.println("Thanks for using the Application");
            System.exit(0);
        }

    }

    public void list(File f) {

        String[] fileName = f.list();
        Arrays.sort(fileName);
        for(String s: fileName)
            System.out.println(s);


    }


    public boolean addFile(String newFile){
            File file = new File("C:\\Users\\jenis\\Documents\\project" + newFile);
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create file");
            }
            return (file.exists());




    }


}


