package TDS.entries;

import TDS.Entry;


public class Attribute extends Variable {

    public Attribute(String type, int depl, String nameAttribute) {
        super(Entry.ATTRIBUTE,type, depl, nameAttribute);
    }

}
