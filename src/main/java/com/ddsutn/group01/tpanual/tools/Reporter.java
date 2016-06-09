package com.ddsutn.group01.tpanual.tools;

import java.util.HashMap;

public interface Reporter {
    void updateReport(String key, Integer value, HashMap<String, Integer> data);
}
