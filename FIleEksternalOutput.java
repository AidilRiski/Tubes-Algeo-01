import java.io.FileOutputStream;  


class FileEksternalOutput {  
    public static void main(String args[]){    
           try{    
             FileOutputStream fout=new FileOutputStream("D:\\testout.txt");    
             String s="ALGEO ASIK KOK SUMPAH";    
             byte b[]=s.getBytes();    
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
      }    

}  