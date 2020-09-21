package dk.openfire.dateUtil;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class TestSimpleDate {

    @Test
    public void testConstructor_ValidDate_zero_days() {
        // Given
        final int year = 2000;
        final int month = 1;
        final int day = 1;

        // when
        SimpleDate simpleDate = new SimpleDate(year, month, day);

        // then
        assertThat(simpleDate.daysSinceEpoc).isEqualTo(0);
    }

    @Test
    public void testConstructor_ValidDate_10_days() {
        // Given
        LocalDate ld = LocalDate.of(2000, 1, 1).plusDays(10);

        // when
        SimpleDate simpleDate = new SimpleDate(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

        // then
        assertThat(simpleDate.daysSinceEpoc).isEqualTo(10);
    }

    @Test
    public void testConstructor_ValidDate_50_days() {
        // Given
        LocalDate ld = LocalDate.of(2000, 1, 1).plusDays(50);

        // when
        SimpleDate simpleDate = new SimpleDate(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

        // then
        assertThat(simpleDate.daysSinceEpoc).isEqualTo(50);
    }

    @Test
    public void testConstructor_ValidDate_100_days() {
        // Given
        LocalDate ld = LocalDate.of(2000, 1, 1).plusDays(100);

        // when
        SimpleDate simpleDate = new SimpleDate(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

        // then
        assertThat(simpleDate.daysSinceEpoc).isEqualTo(100);
    }

    @Test
    public void testConstructor_ValidDate_500_days() {
        // Given
        LocalDate ld = LocalDate.of(2000, 1, 1).plusDays(500);

        // when
        SimpleDate simpleDate = new SimpleDate(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

        // then
        assertThat(simpleDate.daysSinceEpoc).isEqualTo(500);
    }

    @Test
    public void testConstructor_ValidDate_5000_days() {
        // Given
        LocalDate ld = LocalDate.of(2000, 1, 1).plusDays(5000);

        // when
        SimpleDate simpleDate = new SimpleDate(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

        // then
        assertThat(simpleDate.daysSinceEpoc).isEqualTo(5000);
    }


    @Test
    public void testConstructor_invalidDate() {
        // Given
        final int year = 2000;
        final int month = 16;
        final int day = 1;

        // when
        try {
            SimpleDate simpleDate = new SimpleDate(year, month, day);
            fail("expected exception to be thrown");
        } catch(IllegalArgumentException e) {

        }
    }


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

    @Test
    public void testFindDifference_1000days() {

        // Given

        // Using java data as control
        final LocalDate today =  LocalDate.now();
        final LocalDate thousandDaysFromNow = today.plusDays(1000);

        final SimpleDate sdToday = new SimpleDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        final SimpleDate sdThousandDaysFromNow = new SimpleDate(thousandDaysFromNow.getYear(), thousandDaysFromNow.getMonthValue(), thousandDaysFromNow.getDayOfMonth());

        // When
        int difference = sdToday.findDifference(sdThousandDaysFromNow);
        int reverseDifference = sdThousandDaysFromNow.findDifference(sdToday);

        // Then
        assertThat(difference).isEqualTo(1000);
        assertThat(reverseDifference).isEqualTo(1000);
    }

    @Test
    public void testFindDifference_10000days() {

        // Given

        // Using java data as control
        final LocalDate today =  LocalDate.now();
        final LocalDate thousandDaysFromNow = today.plusDays(10000);

        final SimpleDate sdToday = new SimpleDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        final SimpleDate sdThousandDaysFromNow = new SimpleDate(thousandDaysFromNow.getYear(), thousandDaysFromNow.getMonthValue(), thousandDaysFromNow.getDayOfMonth());

        // When
        int difference = sdToday.findDifference(sdThousandDaysFromNow);
        int reverseDifference = sdThousandDaysFromNow.findDifference(sdToday);

        // Then
        assertThat(difference).isEqualTo(10000);
        assertThat(reverseDifference).isEqualTo(10000);
    }


}
