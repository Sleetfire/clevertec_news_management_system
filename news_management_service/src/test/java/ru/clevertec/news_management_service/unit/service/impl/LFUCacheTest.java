package ru.clevertec.news_management_service.unit.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.clevertec.news_management_service.service.Cache;
import ru.clevertec.news_management_service.service.impl.LFUCache;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class LFUCacheTest {

    private Cache<Integer, String> cache;

    @BeforeEach
    void setUp() {
        cache = new LFUCache<>(3);
    }

    @ParameterizedTest(name = "{index} - checked arg: {0}")
    @CsvSource(value = {
            "1, value1",
            "2, value-2",
            "3, value-3"
    })
    @DisplayName("Checking adding to the cache")
    void checkAddAndGetShouldReturnValue(int key, String value) {
        cache.add(key, value);

        Optional<String> optionalString = cache.get(key);

        assertThat(optionalString)
                .isEqualTo(Optional.of(value));
    }

    @Test
    @DisplayName("Checking getting value from empty cache")
    void checkGetShouldReturnOptionalEmpty() {
        assertThat(cache.get(1))
                .isEmpty();
    }

    @Test
    @DisplayName("Checking value updating")
    void checkUpdateShouldReturnUpdatedValue() {
        String firstValue = "first";
        String nextValue = "next";

        cache.add(1, firstValue);
        cache.add(1, nextValue);

        assertThat(cache.get(1))
                .isEqualTo(Optional.of(nextValue));
    }

    @Test
    @DisplayName("Checking deleting")
    void checkDeleteShouldReturnOptionalEmpty() {
        String value = "value";
        int key = 1;

        cache.add(key, value);
        cache.delete(key);

        assertThat(cache.get(key))
                .isEmpty();
    }

    @Test
    @DisplayName("Checking getting size for empty cache")
    void checkGetSizeForEmptyCacheShouldReturn0() {
        int result = cache.getSize();

        assertThat(result)
                .isZero();
    }

    @Test
    @DisplayName("Checking getting size for empty cache")
    void checkGetSizeCacheShouldReturn1() {
        cache.add(1, "1");

        int result = cache.getSize();

        assertThat(result)
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Checking getting cache's capacity")
    void checkGetCapacityShouldReturn3() {
        assertThat(cache.getCapacity())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Checking getting is cache empty")
    void checkIsEmptyShouldReturnTrue() {
        assertThat(cache.isEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("Checking clearing cache")
    void clear() {
        cache.add(1, "1");
        cache.add(2, "2");
        cache.add(3, "3");
        cache.add(4, "4");

        cache.clear();

        assertThat(cache.isEmpty())
                .isTrue();
    }
}
