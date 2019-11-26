import model.StudentInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentInfoTest {
    private StudentInfo stu1;
    private StudentInfo stu2;

    @BeforeEach
    void runBefore() {
        stu1 = new StudentInfo("Karry", "w2c2b");
        stu2 = new StudentInfo("Jacob", "ha");
    }

    @Test
    void GetNameTest() {
        assertEquals (stu1.getName(), "Karry");
        assertEquals (stu2.getName(), "Jacob");
    }

    @Test
    void GetIdTest() {
        assertEquals (stu1.getIdnum(), "w2c2b");
        assertEquals (stu2.getIdnum(), "ha");
    }


}
