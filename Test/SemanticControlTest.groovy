import TDS.SymbolTable
import core.CommonTreeParser
import exceptions.MismatchOperationException
import exceptions.MismatchTypeException
import exceptions.SymbolAlreadyDeclaredException
import exceptions.UndeclaredClassException
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
}
