package dk.openfire.dateUtil;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TestMonths {

    @Test
    public void testInvalidIndex() {
        try {
            Month.valueOf(-1);
            fail("Expected exception to be thrown");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("-1 is not a valid index");
        }
    }

    @Test
    public void testValidIndex() {
        // Given
        final int janIndex = 1;

        // when
        Month month = Month.valueOf(janIndex);

        // then
        assertThat(month).isEqualTo(Month.JAN);
    }
}
