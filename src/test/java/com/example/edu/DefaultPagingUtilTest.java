package com.example.edu;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class DefaultPagingUtilTest {

    @Test
    void REQUEST_NULL() {
        int size = DefaultPagingUtil.extractSize(null);

        Assert.isTrue(size == DefaultPagingUtil.DEFAULT_SIZE, "");
    }

    @Test
    void REQUEST_OK() {
        int reqSize= 30;
        int size = DefaultPagingUtil.extractSize(reqSize);

        Assert.isTrue(size == reqSize, "");
    }

    @Test
    void REQUEST_OVER() {
        int reqSize= 100000000;
        int size = DefaultPagingUtil.extractSize(reqSize);
        Assert.isTrue(size == DefaultPagingUtil.MAX_SIZE, "");
    }
}
