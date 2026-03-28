import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileMaker {
    //flags 
    boolean ispackage = false;
    boolean ispublicclass = false;


    String filepath;

    File fileObj;
    FileWriter writer;
    String integer = "int";
    String character = "char";
    String voidString = "void";

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
                default:
                    break;
            }
            writer.append(methodname);
            writer.append("(){\n  // write your code here \n} ");



        }
        catch(IOException e){
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







