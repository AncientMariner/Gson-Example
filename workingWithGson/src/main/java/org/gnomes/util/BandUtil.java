package org.gnomes.util;

import org.gnomes.model.*;

import java.util.LinkedList;
import java.util.List;

public class BandUtil {
    public static DwarvesBand createBand() {
        DwarvesBand company = new DwarvesBand();

        Dwarf tmpDwarf;

        tmpDwarf = new Dwarf("Orin", 90);
        tmpDwarf.setLunch("Ale with chicken");
        tmpDwarf.setFacialHair(new FacialHair(true, true, "black"));

        List<Weapon> weaponList = new LinkedList<>();
        weaponList.add(new UniqueWeapon("sword", "Slasher", "Gondolin"));
        weaponList.add(new UniqueWeapon("shield", "Oaken Shield", "Moria"));
        weaponList.add(new Weapon("dagger"));

        tmpDwarf.addWeapon(weaponList);

        List<Dwarf> dwarves = new LinkedList<>();
        dwarves.add(tmpDwarf);

        tmpDwarf = new Dwarf("Kori", 60);
        // no lunch :(
        tmpDwarf.setFacialHair(new FacialHair(false, true, "red"));
        List<Weapon> anotherWeaponList = new LinkedList<>();
        anotherWeaponList.add(new Weapon("mace"));
        anotherWeaponList.add(new Weapon("bow"));
        tmpDwarf.addWeapon(anotherWeaponList);

//        company.addDwarves(tmpDwarf);
        dwarves.add(tmpDwarf);

        tmpDwarf = new Dwarf("Billy Bob", 45);
        tmpDwarf.setLunch("Ale with chicken and potatoes, tea with some cakes");
        tmpDwarf.setFacialHair(new FacialHair(false, false, ""));
//        company.addDwarves(tmpDwarf);
        dwarves.add(tmpDwarf);

        company.addDwarves(dwarves);

        return company;
    }
}