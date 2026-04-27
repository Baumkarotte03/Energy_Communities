package org.example.energyjavafxgui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class GridModel {
    private static final DateTimeFormatter ISO_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


    private final ObjectMapper mapper = new ObjectMapper();

    private double communityPool = 0.0;
    private double gridPortion = 0.0;

    public void fetchCurrentPercentageData() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/energy/current"))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                CurrentPercentage data =
                        mapper.readValue(response.body(), CurrentPercentage.class);

                this.communityPool = data.communityDepleted();
                this.gridPortion = data.gridPortion();
            }

        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }

    public String getCommunityPool() {
        return String.format("Community Pool %.2f%% used", communityPool);
    }

    public String getGridPortion() {
        return String.format("Grid Portion %.2f%%", gridPortion);
    }


    /////////////////////////////////////////////////////////

    private double communityProduced = 0.0;
    private double communityUsed = 0.0;
    private double gridUsed = 0.0;

    public void fetchUsageData(LocalDate start, LocalDate end) {
        try {
            String startEncoded = URLEncoder.encode(
                    start.atStartOfDay().format(ISO_FMT), StandardCharsets.UTF_8);
            String endEncoded = URLEncoder.encode(
                    end.atTime(23, 59, 59).format(ISO_FMT), StandardCharsets.UTF_8);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/energy/historical?start=" + startEncoded + "&end=" + endEncoded))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                List<UsageData> results = mapper.readValue(response.body(), new TypeReference<List<UsageData>>() {});

                this.communityProduced = 0.0;
                this.communityUsed = 0.0;
                this.gridUsed = 0.0;

                for (UsageData data : results) {
                    this.communityProduced += data.communityProduced();
                    this.communityUsed += data.communityUsed();
                    this.gridUsed += data.gridUsed();
                }
            }

        } catch (Exception e) {
            System.err.println("Error fetching historical data: " + e.getMessage());
        }
    }

    public String getCommunityProduced() {
        return String.format("Community produced %.2f kWh", communityProduced);
    }

    public String getCommunityUsed() {
        return String.format("Community used %.2f kWh", communityUsed);
    }

    public String getGridUsed() {
        return String.format("Grid used %.2f kWh", gridUsed);
    }
}