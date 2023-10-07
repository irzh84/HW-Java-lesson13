import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void querySimpleTaskContains() {
        boolean expected = true;
        boolean actual = simpleTask.matches("родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void querySimpleTaskContainsNot() {
        boolean expected = false;
        boolean actual = simpleTask.matches("бабушке");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void querySubtasksContains() {
        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void querySubtasksContainsNot() {
        boolean expected = false;
        boolean actual = epic.matches("Черешня");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void queryMeetingTopicContains() {
        boolean expected = true;
        boolean actual = meeting.matches("3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryMeetingTopicContainsNot() {
        boolean expected = false;
        boolean actual = meeting.matches("6");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryMeetingProjectContains() {
        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryMeetingProjectContainsNot() {
        boolean expected = false;
        boolean actual = meeting.matches("ДатаБанка");

        Assertions.assertEquals(expected, actual);
    }

}