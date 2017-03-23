import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VADYM on 22.03.2017.
 */
public class FileManager {

    private File cataloOne;
    private File cataloTwo;
    private ArrayList<File> distinctionList = new ArrayList<File>();
    private ArrayList<File> uniqueFileList = new ArrayList<File>();
    private ArrayList<File> allFilesList = new ArrayList<File>();
    private int countFiles = 0;
    private File fileOne;
    private File fileTwo;

    public FileManager() {
    }

    public FileManager(File cataloOne, File cataloTwo) {
        this.cataloOne = cataloOne;
        this.cataloTwo = cataloTwo;
    }

    public int getCountFiles() {
        return countFiles;
    }

    public FileManager(File cataloOne) {
        this.cataloOne = cataloOne;
    }

    public File getCataloOne() {
        return cataloOne;
    }

    public void setCataloOne(File cataloOne) {
        this.cataloOne = cataloOne;
    }

    public File getCataloTwo() {
        return cataloTwo;
    }

    public void setCataloTwo(File cataloTwo) {
        this.cataloTwo = cataloTwo;
    }

    public void setDistinctionList(ArrayList<File> distinctionList) {

        this.distinctionList = distinctionList;
    }

    public List getDistinctionList() {
        return distinctionList;
    }

    protected ArrayList<File> addAllFileToList(File file) {

        File [] fileList = file.listFiles();
        for (File entry : fileList)
        {
            if (entry.isDirectory())
            {
                addAllFileToList(entry);
                continue;
            }
            allFilesList.add(entry);
            countFiles++;
        }

        return allFilesList;


    }


    protected ArrayList addFileToList(File file) {
        ArrayList<File> fileArrayList = new ArrayList<File>();
        File [] fileList = file.listFiles();
        for (File ff: fileList) {
            if (ff.isFile()){
                fileArrayList.add(ff);
            }else addFileToList(ff);

        }

        return fileArrayList;
    }

    protected ArrayList searchUniqueFiles(){
        ArrayList<File> listOne = addAllFileToList(cataloOne);
        ArrayList<File> listTwo = addAllFileToList(cataloTwo);

            int tmp = 0;
            for (int i = 0; i < listOne.size(); i++) {
                for (int j = 0; j < listTwo.size(); j++) {
                    if ((listOne.get(i).getName()).equals(listTwo.get(j).getName())){
                        break;
                    }else {
                        tmp++;
                        if (tmp==listTwo.size()){
                            uniqueFileList.add(listOne.get(i));
                            tmp=0;
                            break;
                        }
                    }
            }
        }

        return uniqueFileList;
    }

    protected ArrayList<File> diffFiles(){
        ArrayList<File> tmplistOne = addAllFileToList(cataloOne);
        ArrayList<File> listOne = (ArrayList<File>) tmplistOne.clone();
        allFilesList.clear();
        ArrayList<File> tmplistTwo = addAllFileToList(cataloTwo);
        ArrayList<File> listTwo = (ArrayList<File>) tmplistTwo.clone();
        allFilesList.clear();


        for (int i = 0; i < listOne.size(); i++) {
            fileOne = listOne.get(i);
            for (int j = 0; j < listTwo.size(); j++) {
                fileTwo = listTwo.get(i);
                if (((listOne.get(i).getName()).equals(listTwo.get(j).getName())) && listOne.get(i).length() != listTwo.get(i).length()){
                    distinctionList.add(listOne.get(i));
                    System.out.println(listOne.get(i));


                }
            }
        }
        return distinctionList;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileManager)) return false;

        FileManager that = (FileManager) o;

        if (getCataloOne() != null ? !getCataloOne().equals(that.getCataloOne()) : that.getCataloOne() != null)
            return false;
        return getCataloTwo() != null ? getCataloTwo().equals(that.getCataloTwo()) : that.getCataloTwo() == null;
    }

    @Override
    public int hashCode() {
        int result = getCataloOne() != null ? getCataloOne().hashCode() : 0;
        result = 31 * result + (getCataloTwo() != null ? getCataloTwo().hashCode() : 0);
        return result;
    }
    */
}
