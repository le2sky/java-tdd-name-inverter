package nameinverter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NameInverterTest {

    @Test
    void name() {
        assertThat(invert(null)).isEqualTo("");
    }

    private String invert(String name) {
        return "";
    }
}