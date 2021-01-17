//Import libraries
import java.net.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;

....

//Inside main function
try{
    URL obj = new URL("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    
    
    StringBuilder response = new StringBuilder();

    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }

    Gson gson = new Gson();
    JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

    String text = jsonObject.getAsJsonObject("parse").get("text").toString();
            
    int index = text .indexOf(topic);
    while (index >= 0) {
        count++;
        index = text.indexOf(topic, index + 1);
    }

}catch(Exception e){
    e.printStackTrace();
}
