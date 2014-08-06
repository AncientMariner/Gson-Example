package org.gnomes.app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gnomes.gson.serialize.DwarfSerializerWithoutName;
import org.gnomes.gson.serialize.DwarvesBandSerializer;
import org.gnomes.gson.serialize.FacialHairSerializer;
import org.gnomes.model.Dwarf;
import org.gnomes.model.DwarvesBand;
import org.gnomes.model.FacialHair;
import org.gnomes.util.BandUtil;

public class Complete {
    public static void main(String[] args) {
        DwarvesBand company = BandUtil.createBand();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Dwarf.class, new DwarfSerializerWithoutName())
                .registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
                .create();
        String json = gson.toJson(company);

        System.out.println(json);
    }
}