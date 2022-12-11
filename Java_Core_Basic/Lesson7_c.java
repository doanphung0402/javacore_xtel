package Java_Core_Basic;

import java.io.FileInputStream;
import java.io.IOException;

public class Lesson7_c  {
    public void swap(int[]arr,int num1 , int num2){    //ham doi gia tri trong mang
         int temp = arr[num1];
         arr[num1] = arr[num2];
         arr[num2] = temp ;
    }

    public void  quickSort(int []arr, int left , int right) {
        int middle = left + (right - left) / 2;
        int pivot = arr[middle]; // chon phan tu pivot
        if(arr.length ==0 || arr ==null){
              return ;
        }
        if(left >= right){
             return ;
        }
        int i = left ; int j = right;
        while(arr[i]<pivot){
            i++;
        }
        while(arr[j]>pivot){
             j--;
        }
        if (i <=j){
             swap(arr,i,j);
             i++;
             j--;
        }
        quickSort(arr,left,j);
        quickSort(arr,i,right);
    }
     public String readFile() throws IOException {
         StringBuilder stringFile = new StringBuilder();
         FileInputStream fin = null;
         try {
             fin = new FileInputStream("G:\\Project_Xtel\\Java_Core_Basic\\resources\\input.txt");
             int i = 0;
             while ((i = fin.read()) != -1) {
                 stringFile.append((char)i);
             }
             fin.close();
         } catch (Exception e) {
             System.out.println(e);
         } finally {
             fin.close();
         }
         return stringFile.toString() ;
     }

    public static void main(String[] args) {
       try {
          String contentFile = new Lesson7_c().readFile();
          String[] string_array_file = contentFile.split(" ");
          int [] number_array_file = new int[string_array_file.length];
          int i = 0 ;
          for(String c : string_array_file){
               number_array_file[i] = Integer.valueOf(c);
               i++;
          }
           System.out.println("Chuoi can xap sep la : ");
          for(int l : number_array_file){
              System.out.print(l +" ");
          }
           System.out.println();
           System.out.println("Chuoi sau xap sep la");
          new Lesson7_c().quickSort(number_array_file,0,number_array_file.length-1);
          for(int x : number_array_file){
              System.out.print(x+" ");
          }
       }catch (IOException e){
           System.out.println("ko doc dc file");
       }
    }
}
