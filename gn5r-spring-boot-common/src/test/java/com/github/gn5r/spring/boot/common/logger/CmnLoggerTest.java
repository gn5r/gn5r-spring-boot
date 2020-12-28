package com.github.gn5r.spring.boot.common.logger;

import org.junit.Test;

public class CmnLoggerTest {
    
    @Test
    public void test() {
        CmnLogger.info("テスト");
        CmnLogger.error("エラー");
    }
}
