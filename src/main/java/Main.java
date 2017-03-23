import java.io.File;

/**
 * Created by VADYM on 22.03.2017.
 */
public class Main {
    public static void main(String[] args) {



        File catalogOne = new File ("c:/Users/VADYM/Downloads/package_1490163291/dev");
        File catalogTwo = new File ("c:/Users/VADYM/Downloads/package_1490163246/dev2");

        File file1 = new File("c:\\Users\\VADYM\\Downloads\\1\\");
        File file2 = new File("c:\\Users\\VADYM\\Downloads\\2\\");


        FileManager fm1 = new FileManager(file1,file2);
        FileManager fm2 = new FileManager(file2,file1);
    //    System.out.println("unique in " + file1.getName() + " - " + fm1.searchUniqueFiles());
     //   System.out.println("unique in " + file2.getName() + " - " + fm2.searchUniqueFiles());


        System.out.println("***");
        System.out.println("diffFiles - "+fm1.diffFiles());

        FileManager fileManager = new FileManager();
        System.out.println(fileManager.addAllFileToList(file1));
        System.out.println(fileManager.getCountFiles());














    }


}