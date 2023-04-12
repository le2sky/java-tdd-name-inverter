package nameinverter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NameInverterTest {

    @Test
    void name() {
        assertThat(invert(null)).isEqualTo("");
        assertThat(invert("")).isEqualTo("");
        assertThat(invert("name")).isEqualTo("name");
        assertThat(invert("first last")).isEqualTo("last, first");
        assertThat(invert("   name    ")).isEqualTo("name");
        assertThat(invert("first     last")).isEqualTo("last, first");
        assertThat(invert("Mr. first last")).isEqualTo("last, first");
        assertThat(invert("Mrs. first last")).isEqualTo("last, first");
    }

    private String invert(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        } else {
            List<String> names = new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
            if (names.size() > 1 && isHonorific(names)) {
                names.remove(0);
            }
            if (names.size() == 2) {
                return String.format("%s, %s", names.get(1), names.get(0));
            } else {
                return names.get(0);
            }
        }
    }

    private boolean isHonorific(List<String> names) {
        return (names.get(0).equals("Mr.")) || names.get(0).equals("Mrs.");
    }
}