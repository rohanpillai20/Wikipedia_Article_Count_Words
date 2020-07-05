import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiRequest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter topic: ");
        String topic = in.nextLine();

        System.out.println(getTopicCount(topic));
    }

    public static int getTopicCount(String topic) {
        int count = 0;
        String apiUrl = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic;

        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

            String[] textArray =
                    jsonObject.getAsJsonObject("parse").get("text").toString().replaceAll("[^a-zA-Z0-9]+", " ")
                              .split(" ");

            for (String s : textArray) {
                if (topic.equals(s)) {
                    count++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return count;
    }
}

