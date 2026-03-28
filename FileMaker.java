import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMaker {
    //flags 
    boolean ispackage = false;
    boolean ispublicclass = false;


    String filepath;

    File fileObj;
    FileWriter writer;
    Scanner scobj = new Scanner(System.in);

    FileMaker(String path) {
        filepath = path;
        fileObj = new File(filepath);
        try {
            writer = new FileWriter(fileObj);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void makePackage(String pkgname){
        try {
            writer.append("package ");
            writer.append(pkgname);
            writer.append("; \n\r");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void makePublicClass(){
        try {
            writer.append("public class ");
            writer.append(getfilenameString());
            writer.append("{ \n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getfilenameString(){
        String filename = fileObj.getAbsoluteFile().toString();
        int start = filename.lastIndexOf("\\");
        int end = filename.indexOf(".java"); 
        filename = filename.substring(start+1, end);
        return filename;
    }

    public void makeFeild(String feildname, int dtypechoice){
        try{
            switch (dtypechoice) {
                case 1:
                    writer.append("int ");
                    break;
                 case 2:
                    writer.append("char ");
                    break;
                 case 3:
                    writer.append("boolean ");
                    break;
                 case 4:
                    writer.append("float ");
                    break;
                default:
                    break;
            }
            writer.append(feildname);
            writer.append("; \n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }



        public void makeMethod(String methodname, int dtypechoice,boolean isStatic){
        try{
            writer.append("public ");
            if(isStatic) writer.append(" static ");
            switch (dtypechoice) {
                case 1:
                    writer.append("void ");
                    break;
                 case 2:
                    writer.append("int ");
                    break;
                 case 3:
                    writer.append("boolean ");
                    break;
                 case 4:
                    writer.append("float ");
                    break;
                case 5:
                    writer.append("String ");
                    break;
                default:
                    break;
            }
            writer.append(methodname);
            writer.append("(");
            System.out.println("do yo have parmeters");
            boolean option =  scobj.nextBoolean();
            if(option){
            System.out.println("How many parameters you have");
            int numberOfParameters =  scobj.nextInt();
            while( numberOfParameters -- > 0){
            AddParameters();}}
            writer.append("){\n  // write your code here \n} \n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void AddParameters() {
         try{
            String  parametername =scobj.next() ;
            String DataType = scobj.next();
            writer.append(DataType);
            writer.append(" ");
            writer.append(parametername);
            writer.append(", ");
        }
         catch (IOException e) {
            e.printStackTrace();
        }

        
    }

    public void writeAll(){
        try{
            writer.append("\n\r }");
            writer.flush();
        } catch (IOException e) {
        }
    }


    }







