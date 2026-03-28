public class App {
    public static void main(String[] args) {
        FileMaker f =  new FileMaker("E:\\CDAC PGCP\\jaa vaa\\classMaker\\newfile.java");
        // f.makePackage("com.aman");
        f.makePublicClass();
        f.makeFeild("age", 1);
        f.makeFeild("type", 2);
        f.makeFeild("year", 3);

        f.makeMethod("method1", 1, true);
        f.makeMethod("method2", 1, true);
        f.writeAll();
        
   
        
    }

    
}
