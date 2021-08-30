package browse;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetApiCallBDD {

    @Test
    void test_numberOfCircuitsFor2017_Season() {

        // Basic API testing
        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                statusCode(200).
                and().

                body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
                and().
                header("Content-Length",equalTo("4551")).
                and().
                header("Content-Type","application/json; charset=utf-8");
    }


}
