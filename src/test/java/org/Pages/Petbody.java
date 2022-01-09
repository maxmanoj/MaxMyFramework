package org.Pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;

public class Petbody {

    public static JSONObject Petbodydetails(int id, String Name, String Status, String Namectg, String Photourls, String Tagname ){

        JSONObject obj = new JSONObject();

        obj.put("id", id);
        obj.put("name", Name);
        obj.put("status", Status);

        LinkedHashMap category = new LinkedHashMap();

        category.put("id", 0);
        category.put("name", Namectg);
        obj.put("category", category);

        JSONArray photourls = new JSONArray();
        photourls.add(Photourls);
        obj.put("photourls", photourls);

        JSONArray tagname = new JSONArray();
        LinkedHashMap map  =  new LinkedHashMap();
        map.put("id", 0);
        map.put("name", Tagname);
        tagname.add(map);
        obj.put("tags", Tagname);

        System.out.println(obj);
        return obj;

    }
}
