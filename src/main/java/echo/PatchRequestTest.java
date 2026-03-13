import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchRequestTest {

    @Test
    void testPatch() {

        String json = """
        {
          "status": "active"
        }
        """;

        given()
                .contentType("application/json")
                .body(json)
        .when()
                .patch("https://postman-echo.com/patch")
        .then()
                .statusCode(200)
                .body("json.status", equalTo("active"));
    }
}
