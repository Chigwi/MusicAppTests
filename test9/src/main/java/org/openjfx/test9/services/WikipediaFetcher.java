package org.openjfx.test9.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WikipediaFetcher {
    public static String fetchGenreDefinition(String genre) {
        String urlString = "https://en.wikipedia.org/w/api.php?action=query&prop=extracts&exintro&explaintext&format=json&titles=" + genre;
        StringBuilder result = new StringBuilder();
        
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Parse the JSON response
        JSONObject json = new JSONObject(result.toString());
        JSONObject pages = json.getJSONObject("query").getJSONObject("pages");

        // Check if there are any pages returned
        if (pages.length() == 0) {
            return "No definition found for the genre: " + genre;
        }

        // Get the first page (there should only be one)
        String pageId = pages.keys().next();
        String definition = pages.getJSONObject(pageId).optString("extract", "No definition available.");

        return definition;
    }
}
