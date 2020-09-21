package dk.openfire.dateUtil;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSimpleDate {

    @Test
    public void testIsLeapYear() {

        // Test of the every 100 year is not leap year except every 400 years
        assertThat(SimpleDate.isLeapYear(1600)).isTrue();
        assertThat(SimpleDate.isLeapYear(1700)).isFalse();
        assertThat(SimpleDate.isLeapYear(1800)).isFalse();
        assertThat(SimpleDate.isLeapYear(1900)).isFalse();
        assertThat(SimpleDate.isLeapYear(2000)).isTrue();
        assertThat(SimpleDate.isLeapYear(2100)).isFalse();
        assertThat(SimpleDate.isLeapYear(2200)).isFalse();
        assertThat(SimpleDate.isLeapYear(2300)).isFalse();

        // Test every 4 years is leap year
        assertThat(SimpleDate.isLeapYear(2020)).isTrue();
        assertThat(SimpleDate.isLeapYear(2021)).isFalse();
        assertThat(SimpleDate.isLeapYear(2022)).isFalse();
        assertThat(SimpleDate.isLeapYear(2023)).isFalse();
        assertThat(SimpleDate.isLeapYear(2024)).isTrue();

    }
}
