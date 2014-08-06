package org.gnomes.model;

import java.util.LinkedList;
import java.util.List;

public class DwarvesBand {
    List<Dwarf> dwarves = new LinkedList<>();

    public List<Dwarf> getDwarves() {
        return dwarves;
    }

    public void setDwarves(List<Dwarf> dwarves) {
        this.dwarves = dwarves;
    }


    public void addDwarves(List<Dwarf> dwarves) {
        this.dwarves.addAll(dwarves);
    }
}