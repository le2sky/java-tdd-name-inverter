package nameinverter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NameInverterTest {

    @Test
    void name() {
        assertThat(invert(null)).isEqualTo("");
        assertThat(invert("")).isEqualTo("");
        assertThat(invert("name")).isEqualTo("name");
        assertThat(invert("first last")).isEqualTo("last, first");
        assertThat(invert("   name    ")).isEqualTo("name");
    }

    private String invert(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        } else {
            String[] names = name.trim().split(" ");
            if (names.length == 2) {
                return String.format("%s, %s", names[1], names[0]);
            } else {
                return names[0];
            }
        }
    }
}