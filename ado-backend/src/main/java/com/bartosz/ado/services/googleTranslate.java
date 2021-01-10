package com.bartosz.ado.services;
import com.google.cloud.translate.*;

import java.util.HashMap;
import java.util.Map;

public class googleTranslate {
    Translate translate = TranslateOptions.getDefaultInstance().getService();

    public Map<String, String> doTranslation(Map<String, Float> text){

        Translation translation = translate.translate(MapToString(text),
                Translate.TranslateOption.sourceLanguage("en"),
                Translate.TranslateOption.targetLanguage("pl"));
        return StringToMap(translation.getTranslatedText());
    }

    public String MapToString (Map<String, Float> map){
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + "/");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }

    public Map<String, String> StringToMap(String text){
        text = text.substring(1, text.length()-1);
        String[] keyValuePairs = text.split("/");
        Map<String, String> map = new HashMap<>();

        for(String pair : keyValuePairs)
        {

            String[] entry = pair.split("=");
            entry[1] = entry[1].replaceAll(",", ".");
            String tempEntry = " ";
            if (Float.parseFloat(entry[1]) > 0.98){
                tempEntry = "Perfekcyjna";
            } else if (Float.parseFloat(entry[1]) > 0.95){
                tempEntry = "Wyborna";
            }
            else if (Float.parseFloat(entry[1]) > 0.90){
                tempEntry = "Bardzo dobra";
            }
            else if (Float.parseFloat(entry[1]) > 0.86){
                tempEntry = "Dobra";
            }
            else if (Float.parseFloat(entry[1]) > 0.80){
                tempEntry = "Wystarczająca";
            }
            else if (Float.parseFloat(entry[1]) > 0.70){
                tempEntry = "Srednia";
            }
            else if (Float.parseFloat(entry[1]) > 0.60){
                tempEntry = "Słaba";
            } else{
                tempEntry = "Bardzo Słaba";
            }

            map.put(entry[0].trim(),  tempEntry);
        }
        return map;
    }
}
