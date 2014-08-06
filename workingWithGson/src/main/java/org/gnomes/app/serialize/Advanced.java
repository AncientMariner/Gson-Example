package org.gnomes.app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gnomes.gson.serialize.DwarfSerializer;
import org.gnomes.gson.serialize.FacialHairSerializer;
import org.gnomes.model.Dwarf;
import org.gnomes.model.DwarvesBand;
import org.gnomes.model.FacialHair;
import org.gnomes.util.BandUtil;

public class Advanced {
    public static void main(String[] args) {
        DwarvesBand company = BandUtil.createBand();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Dwarf.class, new DwarfSerializer())
                .registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
                .create();
        String json = gson.toJson(company);

        System.out.println(json);
    }
}