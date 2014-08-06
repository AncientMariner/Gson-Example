package org.gnomes.app.deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.gnomes.gson.WeaponsTypeAdapter;
import org.gnomes.gson.deserialize.DwafDeserializerWithTypeAdapter;
import org.gnomes.gson.deserialize.DwarvesBandDeserializer;
import org.gnomes.gson.deserialize.FacialHairDeserializer;
import org.gnomes.gson.serialize.DwarfSerializerWithTypeAdapter;
import org.gnomes.gson.serialize.DwarvesBandSerializer;
import org.gnomes.gson.serialize.FacialHairSerializer;
import org.gnomes.model.Dwarf;
import org.gnomes.model.DwarvesBand;
import org.gnomes.model.FacialHair;
import org.gnomes.model.Weapon;
import org.gnomes.util.BandUtil;

import java.lang.reflect.Type;
import java.util.List;

public class DeserializeWithAdapter {
    public static void main(String[] args) {
        DwarvesBand company = BandUtil.createBand();

        Gson gson;
        Type weaponsType = new TypeToken<List<Weapon>>() {}.getType();

        gson = new GsonBuilder()
                .registerTypeAdapter(Dwarf.class, new DwarfSerializerWithTypeAdapter())
                .registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
                .registerTypeAdapter(weaponsType, new WeaponsTypeAdapter())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(company);
        System.out.println("Serialized:");
        System.out.println(json);

        gson = new GsonBuilder()
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandDeserializer())
                .registerTypeAdapter(FacialHair.class, new FacialHairDeserializer())
                .registerTypeAdapter(Dwarf.class, new DwafDeserializerWithTypeAdapter())
                .registerTypeAdapter(weaponsType, new WeaponsTypeAdapter())
                .create();
        DwarvesBand companyIsBack = gson.fromJson(json, DwarvesBand.class);

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        System.out.println("Deserialized:");
        System.out.println(gson.toJson(companyIsBack));
    }
}