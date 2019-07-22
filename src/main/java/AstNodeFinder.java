import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.util.ArrayList;
import java.util.List;

/*
* This class takes a Compilation unit and visitor in its constructor
* Its findNode function searches the AST beneath the compilation unit
* and returns true if it finds a matching node to the given name
* */
public class AstNodeFinder {

    VoidVisitor<List<String>> _visitor;
    CompilationUnit _compilationUnit;

    public AstNodeFinder(VoidVisitor<List<String>>  visitor, CompilationUnit compilationUnit){
        _visitor = visitor;
        _compilationUnit = compilationUnit;
    }

    //Returns a list of the names of all nodes that are of type declared inside _visitor
    private List<String> crawlAST(){
        List<String> matches = new ArrayList<>();
        _visitor.visit(_compilationUnit, matches);
        return matches;
    }

    //Takes the name of node and returns true when it is present in the AST
    public boolean findNode(String name){
        List<String> matches = crawlAST();
        System.out.println(matches);
        int index = matches.indexOf(name);
        if(index == -1){
            return false;
        }
        return true;
    }
}
