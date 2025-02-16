import org.example.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

@Epic("GorestAPI")
@Feature("https://gorest.co.in/")
public class GoRestAPITest extends BaseTest {

    private int userId;

    @Test(priority = 1)
    @Story("Create a new user")
    @Description("This test verifies the creation of a new user in the API")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateUser() {
        String uniqueEmail = "user_" + System.currentTimeMillis() + "@example.com";

        String requestBody = "{" +
                "\"name\": \"Irene Testing\"," +
                "\"email\": \"" + uniqueEmail + "\"," +
                "\"gender\": \"Female\"," +
                "\"status\": \"active\"}";

        Response response = request
                .body(requestBody)
                .when()
                .post("/users");


        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 201, "User creation failed");
        userId = response.jsonPath().getInt("id");
    }

    @Test(priority = 2, dependsOnMethods = "testCreateUser")
    @Story("Get the user")
    @Description("This test verifies the Get Data of a user in the API")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetUser() {
        Response response = request
                .when()
                .get("/users/" + userId);

        Assert.assertEquals(response.getStatusCode(), 200, "User retrieval failed");
        Assert.assertEquals(response.jsonPath().getInt("id"), userId, "User ID mismatch");
    }

    @Test(priority = 3, dependsOnMethods = "testGetUser")
    @Story("Update user")
    @Description("This test verifies update user in the API")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateUser() {
        String requestBody = "{" +
                "\"name\": \"Jane Due\"," +
                "\"status\": \"inactive\"}";

        Response response = request
                .body(requestBody)
                .when()
                .put("/users/" + userId);

        Assert.assertEquals(response.getStatusCode(), 200, "User update failed");
        Assert.assertEquals(response.jsonPath().getString("name"), "Jane Due", "Name mismatch");
        Assert.assertEquals(response.jsonPath().getString("status"), "inactive", "Status mismatch");
    }

    @Test(priority = 4, dependsOnMethods = "testUpdateUser")
    @Story("Delete user")
    @Description("This test verifies to delete of user in the API")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteUser() {
        Response response = request
                .when()
                .delete("/users/" + userId);

        Assert.assertEquals(response.getStatusCode(), 204, "User deletion failed");
    }
}
