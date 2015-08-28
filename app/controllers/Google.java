package controllers;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.*;

public class Google extends Controller{

    public static Result getImages()
    {
        Client client = Client.create();

        WebResource webResource = client
                .resource("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=hello&rsz=8");

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        ChartData chartDataHeight = new ChartData();
        ChartData chartDataWidth = new ChartData();

        ArrayList height = new ArrayList();
        ArrayList width = new ArrayList();

        JSONObject jsonObj = null;
        JSONArray array = new JSONArray();
        try {
            jsonObj = (JSONObject)new JSONParser().parse(output);
            JSONObject jsonObject= (JSONObject) jsonObj.get("responseData");
            JSONArray jsonArray= (JSONArray) jsonObject.get("results");

            for( int i=0;i< jsonArray.size();i++)
            {
                JSONObject jobject= (JSONObject) jsonArray.get(i);
                height.add(Integer.parseInt(jobject.get("height").toString()));
                width.add(Integer.parseInt(jobject.get("width").toString()));


            }
            chartDataHeight.setName("Height");
            chartDataHeight.setData(height);

            chartDataWidth.setName("Width");
            chartDataWidth.setData(width);


            array.add(chartDataHeight);
            array.add(chartDataWidth);


        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return ok(Json.toJson(array));
    }

    public static Result getHeight()
    {
        Client client = Client.create();

        WebResource webResource = client
                .resource("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=hello&rsz=8");

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        TreeMap<String,Float> treeMap = new TreeMap<String,Float>();

        ArrayList height = new ArrayList();

        JSONObject jsonObj = null;

        try {
            jsonObj = (JSONObject)new JSONParser().parse(output);
            JSONObject jsonObject= (JSONObject) jsonObj.get("responseData");
            JSONArray jsonArray= (JSONArray) jsonObject.get("results");

            float total=0;

            for( int i=0;i< jsonArray.size();i++)
            {
                JSONObject jobject= (JSONObject) jsonArray.get(i);
                height.add(Integer.parseInt(jobject.get("height").toString()));

                total = total+(int)(height.get(i));
            }

            treeMap.put("Image1", (total- (total- (((int) height.get(0))*100) ))/total);
            treeMap.put("Image2", (total- (total- (((int) height.get(1))*100) ))/total);
            treeMap.put("Image3", (total- (total- (((int) height.get(2))*100) ))/total);
            treeMap.put("Image4", (total- (total- (((int) height.get(3))*100) ))/total);
            treeMap.put("Image5", (total- (total- (((int) height.get(4))*100) ))/total);

            treeMap.put("Image6", (total- (total- (((int) height.get(5))*100) ))/total);
            treeMap.put("Image7", (total- (total- (((int) height.get(6))*100) ))/total);
            treeMap.put("Image8", (total- (total- (((int) height.get(7))*100) ))/total);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return ok(Json.toJson(treeMap));
    }

    public static Result getWidth()
    {
        Client client = Client.create();

        WebResource webResource = client
                .resource("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=hello&rsz=8");

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        TreeMap<String,Float> treeMap = new TreeMap<String,Float>();

        ArrayList width = new ArrayList();

        JSONObject jsonObj = null;

        try {
            jsonObj = (JSONObject)new JSONParser().parse(output);
            JSONObject jsonObject= (JSONObject) jsonObj.get("responseData");
            JSONArray jsonArray= (JSONArray) jsonObject.get("results");

            float total=0;

            for( int i=0;i< jsonArray.size();i++)
            {
                JSONObject jobject= (JSONObject) jsonArray.get(i);
                width.add(Integer.parseInt(jobject.get("width").toString()));

                total = total+(int)(width.get(i));
            }

            treeMap.put("Image1", (total- (total- (((int) width.get(0))*100) ))/total );
            treeMap.put("Image2", (total- (total- (((int) width.get(1))*100) ))/total);
            treeMap.put("Image3", (total- (total- (((int) width.get(2))*100) ))/total);
            treeMap.put("Image4", (total- (total- (((int) width.get(3))*100) ))/total);
            treeMap.put("Image5", (total- (total- (((int) width.get(4))*100) ))/total);
            treeMap.put("Image6", (total- (total- (((int) width.get(5))*100) ))/total);
            treeMap.put("Image7", (total- (total- (((int) width.get(6))*100) ))/total);
            treeMap.put("Image8", (total- (total- (((int) width.get(7))*100) ))/total);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return ok(Json.toJson(treeMap));
    }

   /* public static Result getDonutChart()
    {
        return ok();
    }*/
}



class ChartData{

    public  String name;
    ArrayList data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }
}