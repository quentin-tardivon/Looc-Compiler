import TDS.SymbolTable
import core.CommonTreeParser
import exceptions.IncorrectParamsMethodException
import exceptions.MismatchOperationException
import exceptions.MismatchTypeException
import exceptions.ReturnValueTypeMismatchException
import exceptions.StringOperationException
import exceptions.SymbolAlreadyDeclaredException
import exceptions.UndeclaredClassException
import exceptions.UndeclaredInheritanceException
import exceptions.UndeclaredVariableException
import factories.CommonTreeParserFactory

/**
 * Created by quentin on 30/03/2017.
 */
class SemanticControlTest extends GroovyTestCase {
    private CommonTreeParser treeParser

    void testMismatchTypeException() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level0.looc");
    }

    void testAlreadyDeclaredException() {
        shouldFail(SymbolAlreadyDeclaredException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/AlreadyDeclaredEx.looc")
        }
    }

    void testUndeclaredClassEx() {
        shouldFail(UndeclaredClassException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredClassEx.looc")
        }
    }

    void testReturnValTypeMisEx() {
        shouldFail(ReturnValueTypeMismatchException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/ReturnValueTypeMisEx.looc")
        }
    }

    void testStringOpEx() {
        shouldFail(StringOperationException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/StringOpEx.looc")
        }
    }

    void testInexactNumberParamsEx() {
        shouldFail(IncorrectParamsMethodException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/InexactNumberParamsEx.looc")
        }
    }

    void testUndeclaredInheritanceEx() {
        shouldFail(UndeclaredInheritanceException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredInheritanceEx.looc")
        }
    }

    void testMismatchOperationException() {
        shouldFail(MismatchOperationException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/OperationMismatch.looc")
            treeParser.constructTDS(tree, new SymbolTable())
        }
    }

}
