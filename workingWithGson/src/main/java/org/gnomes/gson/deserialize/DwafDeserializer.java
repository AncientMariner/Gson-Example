package org.gnomes.gson.deserialize;

import com.google.gson.*;
import org.gnomes.model.Dwarf;
import org.gnomes.model.FacialHair;
import org.gnomes.model.UniqueWeapon;
import org.gnomes.model.Weapon;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DwafDeserializer implements JsonDeserializer<Dwarf> {
    @Override
    public Dwarf deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
            JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Dwarf dwarf = new Dwarf();
        dwarf.setDwarfAge(jsonObject.get("age").getAsInt());

        dwarf.setFacialHair((FacialHair) context.deserialize(jsonObject.get("facialHair"), FacialHair.class));

        JsonArray weapons = jsonObject.getAsJsonArray("weapons");
        for (JsonElement weapon : weapons) {
            if (weapon.isJsonPrimitive()) {
                List<Weapon> weaponList = new ArrayList<>();
                weaponList.add(new Weapon(weapon.getAsString()));
                dwarf.addWeapon(weaponList);
            } else {
                List<Weapon> weaponList = new ArrayList<>();
                weaponList.add((UniqueWeapon) context.deserialize(weapon, UniqueWeapon.class)); // UniqueWeapon
                dwarf.addWeapon(weaponList);
            }
        }

        return dwarf;
    }
}