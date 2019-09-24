package com.example.controllers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/adress")
@Api(description = " 地址控制器")
public class LocationUtils {

    @ApiOperation(value="地址获取")
    @RequestMapping(value = "/di",method = {RequestMethod.GET},produces = "application/json;charset=utf-8")
    public Map<String, Object> getLocation(String lng, String lat) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String KEY = "TCUBZ-W5L36-SSTSU-ERXQ5-PT4VF-26F54";
        // 参数解释：lng：经度，lat：维度。KEY：腾讯地图key，get_poi：返回状态。1返回，0不返回
        String urlString =
                "https://apis.map.qq.com/ws/geocoder/v1/?location=" + lat + "," + lng + "&get_poi=1&key=" + KEY;
        String result = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            // 腾讯地图使用GET
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 获取地址解析结果
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }
        // 转JSON格式
        JSONObject jsonObject = JSONObject.fromObject(result).getJSONObject("result");
        // 获取地址（行政区划信息） 包含有国籍，省份，城市
        JSONObject adInfo = jsonObject.getJSONObject("ad_info");
        resultMap.put("nation", adInfo.get("nation"));
        resultMap.put("nationCode", adInfo.get("nation_code"));
        resultMap.put("province", adInfo.get("province"));
        resultMap.put("provinceCode", adInfo.get("adcode"));
        resultMap.put("city", adInfo.get("city"));
        resultMap.put("cityCode", adInfo.get("city_code"));
        return resultMap;
    }

}