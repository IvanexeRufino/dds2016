package com.ddsutn.group01.tpanual.tools.metrics;

public interface MetricsSource {
    void reportStat(String criteria, int resultsCount, long timeLapsed);
}
