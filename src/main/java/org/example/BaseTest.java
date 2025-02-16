package org.example;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected RequestSpecification request;
    private static String BASE_URL;
    private static String TOKEN;

    @BeforeClass
    public void setup() {
        loadConfig();

        // Set base URI for RestAssured
        RestAssured.baseURI = BASE_URL;

        // Timeout Configuration
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 5000)
                        .setParam("http.socket.timeout", 5000)
                );

        // Request Installation
        request = RestAssured.given()
                .header("Authorization", "Bearer " + TOKEN) //
                .header("Content-Type", "application/json");
    }

    private void loadConfig() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
            BASE_URL = properties.getProperty("base_url");
            TOKEN = properties.getProperty("token");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }
}
