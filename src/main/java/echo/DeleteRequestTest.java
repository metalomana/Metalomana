import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest {

    @Test
    void testDelete() {

        when()
                .delete("https://postman-echo.com/delete")
        .then()
                .statusCode(200);
    }
}
