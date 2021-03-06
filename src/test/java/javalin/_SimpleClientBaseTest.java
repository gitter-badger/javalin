package javalin;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import javalin.util.SimpleHttpClient;

public class _SimpleClientBaseTest {

    static Javalin app;
    static String origin = "http://localhost:7777";

    static SimpleHttpClient simpleHttpClient;

    @BeforeClass
    public static void setup() throws IOException {
        app = Javalin.create()
            .port(7777)
            .start()
            .awaitInitialization();
        simpleHttpClient = new SimpleHttpClient();
    }

    @After
    public void clearRoutes() {
        app.errorMapper.clear();
        app.exceptionMapper.clear();
        app.pathMatcher.clear();
    }

    @AfterClass
    public static void tearDown() {
        app.stop();
        app.awaitTermination();
    }
}
