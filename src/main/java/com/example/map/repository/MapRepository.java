package com.example.map.repository;

import com.example.map.entity.Feature;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MapRepository extends JpaRepository<Feature, Long> {

    @Query(value = "select feature_info from features", nativeQuery = true)
    List<JSONObject> findMap();

    @Query(value = "select feature_info from features where id=:id", nativeQuery = true)
    JSONObject findByIdCustom(@Param("id") Long id);

    Feature findTopByOrderByIdDesc();

    @Query(value = "WITH start_point AS (\n" +
            "    SELECT ST_SetSRID(ST_MakePoint(x1=:x1, y1=:y1), 0) AS geom\n" +
            "), end_point AS (\n" +
            "    SELECT ST_SetSRID(ST_MakePoint(x2=:x2, y2=:y2), 0) AS geom\n" +
            "), shortest_path AS (\n" +
            "    SELECT ST_MakeLine(start_point.geom, end_point.geom) AS geom\n" +
            "    FROM start_point, end_point\n" +
            ")\n" +
            "SELECT features.geometry\n" +
            "FROM features, shortest_path\n" +
            "WHERE _ST_Intersects(features.geometry, shortest_path.geom);", nativeQuery = true)
    List<String> findPath(@Param("x1") Double x1, @Param("y1") Double y1, @Param("x2") Double x2, @Param("y2") Double y2);
}
