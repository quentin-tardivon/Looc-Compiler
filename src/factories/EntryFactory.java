package factories;

import TDS.entries.Class;
import TDS.entries.*;
import core.Keywords;

/**
 * Factory for a Entry class, mainly used for tests.
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class EntryFactory {

    public static Class createClass(String cls) {  return new Class(cls); }
    public static Class createInheritClass(String cls, String inherit) {  return new Class(cls, inherit);  }

    public static Variable createVariable(String type) {
        return new Variable(type, "X");
    }
    public static Variable createStringVariable() {
        return new Variable(Keywords.STRING, "X");
    }
    public static Variable createIntVariable() {  return new Variable(Keywords.INTEGER, "X"); }

    public static Method createMethod() {  return new Method(); }
    public static Method createMethodReturnInt() {  return new Method(Keywords.INTEGER); }

    public static Variable createIntAttribute() {  return new Attribute(Keywords.INTEGER, 0, "a"); }
    public static Variable createStringAttribute() {  return new Attribute(Keywords.STRING, 0, "a"); }

    public static Variable createStringParameter() {  return new Parameter(Keywords.STRING, -2, "a"); }
    public static Variable createIntParameter(String type) {  return new Parameter(Keywords.INTEGER, -2, "b"); }

    public static If createIf(String type) {  return new If(); }

    public static AnonymousBloc createAnonymousBlock() {  return new AnonymousBloc(); }

    public static ForLoop createForLoop() {
        return new ForLoop();
    }
}
