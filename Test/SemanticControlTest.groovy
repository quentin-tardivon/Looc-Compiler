import core.CommonTreeParser
import exceptions.*
import factories.CommonTreeParserFactory

/**
 * Created by quentin on 30/03/2017.
 */
class SemanticControlTest extends GroovyTestCase {
    private CommonTreeParser treeParser

    void testMismatchTypeException() {
        shouldFail(MismatchTypeException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/MismatchTypeException.looc")
        }
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
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/ReturnValueTypeMismatchEx.looc")
        }
    }

    void testStringOpEx() {
        shouldFail(StringOperationException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/StringOpEx.looc")
        }
    }

    void testUndeclaredVar() {
        shouldFail(UndeclaredVariableException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredVarEx.looc")
        }
    }

    void testInexactNumberParamsEx() {
        shouldFail(InexactParamsNumberException) {
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
        }
    }

    void testNotVoidMethod() {
        shouldFail(MethodNonVoidException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/NotVoidMethod.looc")
        }
    }

    void testParameterTypeMismatchException() {
        shouldFail(ParameterTypeMismatchException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/ParameterTypeMismatchException.looc")
        }
    }


    void testUndeclaredMethEx() {
        shouldFail(UndeclaredMethodException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/UndeclaredMethEx.looc")
        }
    }

    void testReadUsageEx() {
        shouldFail(ReadUsageException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/ReadUsageEx.looc")
        }
    }

    void testWriteUsageEx() {
        shouldFail(WriteUsageException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/WriteUsageEx.looc")

        }
    }

    void testInexactUsesOfDoException() {
        shouldFail(InexactUsesOfDoException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/InexactUsesOfDoEx.looc")


        }
    }

}
