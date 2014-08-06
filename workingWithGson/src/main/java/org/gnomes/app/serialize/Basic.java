package org.gnomes.app.serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gnomes.model.DwarvesBand;
import org.gnomes.util.BandUtil;

public class Basic {
    public static void main(String[] args) {
        DwarvesBand band = BandUtil.createBand();

        Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
        String json = gson.toJson(band);

        System.out.println(json);
    }
}