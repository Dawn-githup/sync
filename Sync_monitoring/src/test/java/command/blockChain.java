package command;

import com.alibaba.fastjson.JSONPath;

import static io.restassured.RestAssured.given;

/**
 * 1. @description:
 * 2. @author: Dawn
 * 3. @time: 2023/5/31
 */
public class blockChain {
    public Integer getBlock(){
        String body = given()
                .header("Content-Type","application/json; charset=utf-8")
                .body("{\n" +
                        "  \"id\": 42,\n" +
                        "  \"jsonrpc\": \"2.0\",\n" +
                        "  \"method\": \"get_tip_header\",\n" +
                        "  \"params\": []\n" +
                        "}")
                .post("http://18.162.180.86:8125/").asString();
        System.out.println(body);
        String hex = (String) JSONPath.read(body, "$.result.number");
        Integer x = Integer.parseInt(hex.substring(2),16);
        return x;
    }

    public boolean getBlocks(){
        try {
            String body = given()
                    .header("Content-Type","application/json; charset=utf-8")
                    .body("{\n" +
                            "  \"id\": 42,\n" +
                            "  \"jsonrpc\": \"2.0\",\n" +
                            "  \"method\": \"get_tip_header\",\n" +
                            "  \"params\": []\n" +
                            "}")
                    .post("http://18.162.180.86:8125/").asString();
            System.out.println(body);
            String hex = (String) JSONPath.read(body, "$.result.number");
            Integer x = Integer.parseInt(hex.substring(2),16);
            System.out.println(x);
            return true;
        }catch (Exception e){
            System.out.println("Synchronization error");
            return false;
        }
    }
}
