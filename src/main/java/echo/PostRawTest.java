import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRawTest {

    @Test
    void testPostRaw() {

        String body = "Hello World";

        given()
                .body(body)
        .when()
                .post("https://postman-echo.com/post")
        .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}
