import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequestTest {

    @Test
    void testPut() {

        String json = """
        {
          "name": "Alex"
        }
        """;

        given()
                .contentType("application/json")
                .body(json)
        .when()
                .put("https://postman-echo.com/put")
        .then()
                .statusCode(200)
                .body("json.name", equalTo("Alex"));
    }
}
