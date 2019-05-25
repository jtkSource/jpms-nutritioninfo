package com.jtk.nutrition.loader.internal;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class YAMLReader {

    private static final Logger logger = Logger.getLogger(YAMLReader.class.getName());

    private final Map<String, List<Pair<String, String>>> yamlDictionary = new HashMap<>();

    public void loadYAMLDictionary(String fileName) throws IOException {
        File inputFile = new File(fileName);
        yamlDictionary.clear();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String key = null;
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(" ") && key != null) {
                line = line.trim();
                String[] keyValue = line.split(":");
                if (keyValue.length > 1) {
                    yamlDictionary.get(key).add(new Pair<String, String>(keyValue[0].trim(), keyValue[1].trim()));
                }
            } else {
                key = line.trim().substring(0, line.length() - 1);
                yamlDictionary.put(key, new ArrayList<>());
            }
        }
        reader.close();
        logger.info("Yaml loaded " + yamlDictionary.toString());
    }

    public Map<String, String> getNutritionDetails(String product) {
        Map<String, String> info = new HashMap<>();
        if (yamlDictionary.containsKey(product)) {
            List<Pair<String, String>> nutriDetails = yamlDictionary.get(product);
            nutriDetails.stream().forEach(p -> {
                info.put(p.getLeft(), p.getRight());
            });
        }
        return info;
    }
}