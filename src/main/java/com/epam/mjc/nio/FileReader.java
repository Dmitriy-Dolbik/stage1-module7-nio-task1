package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileReader {
      public Profile getDataFromFile(File file) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())){
            String line;
            while ((line = reader.readLine()) != null){
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (IOException e)
        {
            throw new ReadingFileException("File cannot be reading", e);
        }
        String[] keyValuePairs = resultStringBuilder.toString().split("\n");
        for (int i = 0; i < keyValuePairs.length; i++)
        {
            keyValuePairs[i] = keyValuePairs[i].split(": ")[1];
        }
        return new Profile(keyValuePairs[0], Integer.parseInt(keyValuePairs[1]), keyValuePairs[2], Long.parseLong(keyValuePairs[3]));




    }
}
