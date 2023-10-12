package com.example.map.util;

import org.geotools.feature.FeatureCollection;
import org.geotools.geojson.GeoJSON;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.geom.GeometryJSON;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class db {

    public /*void*/ String readFile(){
        File inFile = new File("C:\\Users\\35987\\Desktop\\Map_Main\\src\\main\\resources\\db\\peshehodna_mreja_website.geojson");

        FeatureJSON featureJSON = new FeatureJSON(new GeometryJSON(15));
        FeatureCollection featureCollection = null;
        try {
            featureCollection = featureJSON.readFeatureCollection(inFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFeatureType simpleFeatureType = (SimpleFeatureType) featureCollection.getSchema();
        System.out.println(simpleFeatureType.getGeometryDescriptor().getLocalName());
        OutputStream ostream = new ByteArrayOutputStream();
        try {
            GeoJSON.write(featureCollection, ostream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(ostream);
        return featureCollection.toString();
    }

}
