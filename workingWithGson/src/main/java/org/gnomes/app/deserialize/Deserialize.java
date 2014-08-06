package org.gnomes.app.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gnomes.gson.deserialize.DwafDeserializer;
import org.gnomes.gson.deserialize.DwarvesBandDeserializer;
import org.gnomes.gson.deserialize.FacialHairDeserializer;
import org.gnomes.gson.serialize.DwarfSerializerWithoutName;
import org.gnomes.gson.serialize.DwarvesBandSerializer;
import org.gnomes.gson.serialize.FacialHairSerializer;
import org.gnomes.model.Dwarf;
import org.gnomes.model.DwarvesBand;
import org.gnomes.model.FacialHair;
import org.gnomes.util.BandUtil;

public class Deserialize {
    public static void main(String[] args) {
        DwarvesBand company = BandUtil.createBand();

        Gson gson;
        gson = new GsonBuilder()
                .registerTypeAdapter(Dwarf.class, new DwarfSerializerWithoutName())
                .registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
                .create();
        String json = gson.toJson(company);

        gson = new GsonBuilder()
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandDeserializer())
                .registerTypeAdapter(FacialHair.class, new FacialHairDeserializer())
                .registerTypeAdapter(Dwarf.class, new DwafDeserializer())
                .create();
        DwarvesBand bandIsBack = gson.fromJson(json, DwarvesBand.class);

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        System.out.println(gson.toJson(bandIsBack));
    }
}