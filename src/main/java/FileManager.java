import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VADYM on 22.03.2017.
 */
public class FileManager {

    private File cataloOne;
    private File cataloTwo;
    private ArrayList<File> distinctionList;

    public FileManager() {
    }

    public FileManager(File cataloOne, File cataloTwo) {
        this.cataloOne = cataloOne;
        this.cataloTwo = cataloTwo;
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

    protected void addAllFileToList(File file) {
      //  ArrayList<File> arrayList = new ArrayList<File>();
        File [] fileList = file.listFiles();
        for (File entry : fileList)
        {
            if (entry.isDirectory())
            {
                addAllFileToList(entry);
                continue;
            }
           // arrayList.add(entry);
            distinctionList.add(entry);
        }


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
        ArrayList<File> listOne = addFileToList(cataloOne);
        ArrayList<File> listTwo = addFileToList(cataloTwo);
        ArrayList<File> not = new ArrayList<File>();

            int tmp = 0;
            for (int i = 0; i < listOne.size(); i++) {
                for (int j = 0; j < listTwo.size(); j++) {
                    if ((listOne.get(i).getName()).equals(listTwo.get(j).getName())){
                        break;
                    }else {
                        tmp++;
                        if (tmp==listTwo.size()){
                            not.add(listOne.get(i));
                            tmp=0;
                            break;
                        }
                    }
            }
        }

        return not;
    }

    protected ArrayList<File> diffFiles(){
        ArrayList<File> listOne = addFileToList(cataloOne);
        ArrayList<File> listTwo = addFileToList(cataloTwo);
        ArrayList<File> not = new ArrayList<File>();


        for (int i = 0; i < listOne.size(); i++) {
            for (int j = 0; j < listTwo.size(); j++) {
                if (((listOne.get(i).getName()).equals(listTwo.get(j).getName())) && listOne.get(i).length() != listTwo.get(i).length()){
                    not.add(listOne.get(i));

                }
            }
        }
        return not;
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
