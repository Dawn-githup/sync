package command;

import com.alibaba.fastjson.JSONPath;

import java.util.Calendar;

import static io.restassured.RestAssured.given;

/**
 * 1. @description:
 * 2. @author: Dawn
 * 3. @time: 2023/5/29
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        Calendar now = Calendar.getInstance();
//        int hour = now.get(Calendar.HOUR_OF_DAY);
//        System.out.println(hour);
//        monitoringTest block = new monitoringTest();
//        System.out.println(block.getBlock());

        int date = 1;

        for (int i = 0; i < 100; i++) {
            switch(date) {
                case 1:
                    System.out.println("0000");
                    if (date ==0){
                        break;
                    }
                    break;
                case 2:
                    System.out.println("11111");
                    break;
                default:
                    System.out.println("aaaaaaa");
            }
            Thread.sleep(10000);
        }



//        try {
//            String body = given()
//                    .header("Content-Type","application/json; charset=utf-8")
//                    .body("{\n" +
//                            "  \"id\": 42,\n" +
//                            "  \"jsonrpc\": \"2.0\",\n" +
//                            "  \"method\": \"get_tip_header\",\n" +
//                            "  \"params\": []\n" +
//                            "}")
//                    .post("http://18.162.235.225:8125/").asString();
//            System.out.println(body);
//            String hex = (String) JSONPath.read(body, "$.result.number");
//            Integer x = Integer.parseInt(hex.substring(2),16);
//            System.out.println(x);
//        }catch (Exception e){
//            System.out.println("111111");
//        }
    }
}
