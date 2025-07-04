import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropExample {

    @BeforeAll
    static void testBrowseConfiguration() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropAction() {
        open("/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(150, 0).release().perform();
        $("#column-a header").shouldHave(text("B"));
    }

    @Test
    void dragAndDrop() {
        open("/drag_and_drop"); // Открываем нужны сайт
        $("#column-a").dragAndDrop(to("#column-b")); // Аналог команды выше, но упрощенный в написании
        $("#column-a header").shouldHave(text("B"));
    }
}

