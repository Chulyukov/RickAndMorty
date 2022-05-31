package ApiSteps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreationSteps {
    private static final String BASE_URI = "https://reqres.in";
    Response reqres;
    private JSONObject body;

    @Step("Создаем данные для отправки")
    public void createMainData() throws IOException {
        body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/json/potato.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat market");
    }

    @Step("Делаем запрос на создание юзера, меняем данные")
    public void doCreationResponse() {
        reqres = given()
                .filter(new AllureRestAssured())
                .body(body.toString())
                .when()
                .contentType(ContentType.JSON)
                .post(BASE_URI + "/api/users")
                .then().log().all()
                .extract()
                .response();
        Assert.assertEquals(201, reqres.getStatusCode());
    }

    @Step("Сверяем пришедший ответ с ожидаемым")
    public void assertCreationResponse() {

        JsonPath jsonPath = reqres.jsonPath();
        String name = jsonPath.get("name");
        String job = jsonPath.get("job");
        String id = jsonPath.get("id");
        String createdAt = jsonPath.get("createdAt");

        assertEquals("Tomato", name);
        assertEquals("Eat market", job);
        assertNotNull(id);
        assertNotNull(createdAt);
    }
}