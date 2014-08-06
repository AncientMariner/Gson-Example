package org.gnomes.app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.gnomes.gson.WeaponsTypeAdapter;
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

public class CompleteWithAdapter {
    public static void main(String[] args) {
        DwarvesBand company = BandUtil.createBand();

        Type weaponsListType = new TypeToken<List<Weapon>>() {}.getType();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Dwarf.class, new DwarfSerializerWithTypeAdapter())
                .registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
                .registerTypeAdapter(weaponsListType, new WeaponsTypeAdapter())
                .create();
        String json = gson.toJson(company);

        System.out.println(json);
    }
}