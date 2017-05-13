package ASMGenerator;


import TDS.SymbolTable;

public class Method extends Block implements Generable {

    private SymbolTable tds;

    public Method(SymbolTable tds) {
        this.tds = tds;
    }

    @Override
    public String generate() {
        StringBuffer asm = new StringBuffer();
        asm.append(ASMUtils.formatASM("// ", "method " + tds.getName(), ""));

        asm.append(ASMUtils.stackStaticAndDynamic());
        for(Generable g: this.instructions) {
            asm.append(g.generate());
        }

        return asm.toString();
    }
}
