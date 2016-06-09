package com.ddsutn.group01.tpanual.tools.reporters;

import java.util.HashMap;

public interface Reporter {
    void updateReport(String key, Integer value, HashMap<String, Integer> data);
}
