import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostFormTest {

    @Test
    void testPostForm() {

        given()
                .formParam("name", "Alex")
                .formParam("age", "25")
        .when()
                .post("https://postman-echo.com/post")
        .then()
                .statusCode(200)
                .body("form.name", equalTo("Alex"))
                .body("form.age", equalTo("25"));
    }
}
