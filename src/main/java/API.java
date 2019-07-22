import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileNotFoundException;

public class API {
    private static final String FILE_PATH = "src/main/java/ReversePolishNotation.java";

    public static void main(String[] args) throws FileNotFoundException {
        CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));

        //1. Check whether class ReversePolishNotation is declared
        ClassNameCollector collectorClass = new ClassNameCollector();
        AstNodeFinder finder = new AstNodeFinder(collectorClass, cu);
        System.out.println(finder.findNode("ReversePolishNotation"));

        //2. Check whether method calc is declared
        MethodNameCollector collectorMethods = new MethodNameCollector();
        AstNodeFinder finder2 = new AstNodeFinder(collectorMethods, cu);
        System.out.println((finder2.findNode("calc")));


    }
}
