import core.CommonTreeParser
import exceptions.*
import factories.CommonTreeParserFactory
import org.junit.Ignore

/**
 * Created by quentin on 30/03/2017.
 */
class SemanticControlTest extends GroovyTestCase {
    private CommonTreeParser treeParser

    void testMismatchTypeException() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/MismatchTypeException.looc")
        testException(treeParser, MismatchTypeException)

    }

    void testAlreadyDeclaredException() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/AlreadyDeclaredEx.looc")
        testException(treeParser, SymbolAlreadyDeclaredException)
    }

    void testUndeclaredClassEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredClassEx.looc")
        testException(treeParser, UndeclaredClassException)
    }

    void testReturnValTypeMisEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/ReturnValueTypeMismatchEx.looc")
        testException(treeParser, ReturnValueTypeMismatchException, UndeclaredMethodException)
    }

    void testStringOpEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/StringOpEx.looc")
        testException(treeParser, StringOperationException)
    }

    void testUndeclaredVar() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredVarEx.looc")
        testException(treeParser, UndeclaredVariableException)
    }

    void testInexactNumberParamsEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/InexactNumberParamsEx.looc")
        testException(treeParser, InexactParamsNumberException)
    }

    void testUndeclaredInheritanceEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredInheritanceEx.looc")
        testException(treeParser, UndeclaredInheritanceException, MismatchTypeException)
    }

    void testMismatchOperationException() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/OperationMismatch.looc")
        testException(treeParser, MismatchOperationException)
    }

    void testNotVoidMethod() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/NotVoidMethod.looc")
        testException(treeParser, MethodNonVoidException)
    }

    void testParameterTypeMismatchException() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/ParameterTypeMismatchException.looc")
        testException(treeParser, ParameterTypeMismatchException)
    }


    void testUndeclaredMethEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredMethEx.looc")
        testException(treeParser, UndeclaredMethodException)
    }

    void testReadUsageEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/ReadUsageEx.looc")
        testException(treeParser, ReadUsageException)
    }

    void testWriteUsageEx() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/WriteUsageEx.looc")
        testException(treeParser, WriteUsageException)
    }

    void testInexactUsesOfDoException() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/InexactUsesOfDoEx.looc")
        testException(treeParser, InexactUsesOfDoException)
    }

    void testUninitializedException() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/VarUninitializedException.looc")
        testException(treeParser, VarUninitializedException)
    }

    void testException(CommonTreeParser treeParser, Class... cls) {
        assertEquals("Should throw only one LoocException", cls.length, treeParser.getExceptions().size())
        for(int i = 0; i < cls.length; i++) {
            assertTrue("Should throw only " + cls[i].getSimpleName(), cls[i].isInstance(treeParser.getExceptions().get(i)))
        }

    }



}
