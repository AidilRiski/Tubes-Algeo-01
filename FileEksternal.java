import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FileEksternal{
  public File file = new File ("aingcupu.txt");
  int GetNElmtFileSPL () {
    int count = 0;
    Scanner scan;
    try {
      scan = new Scanner (this.file);
      while (scan.hasNextDouble()){
        count = count + 1;
      }
    } catch (FileNotFoundException e1){
        e1.printStackTrace();
    }
    return count;
  }

  int GetNKolEff () {
    int count = 0;
    Scanner scan;
    try {
      scan = new Scanner (this.file);
      while (scan.hasNextDouble()){
        count = count + 1;
      }
    } catch (FileNotFoundException e1){
        e1.printStackTrace();
    }
    return count;
  }

  void BacaFileSPL () {
    Scanner scan;
    try {
      scan = new Scanner (this.file);
      while (scan.hasNextDouble()){
        System.out.println(scan.nextDouble() );
      }
    } catch (FileNotFoundException e1){
        e1.printStackTrace();
    }
  }
}
