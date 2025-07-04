package bot;

import com.fasterxml.jackson.databind.ObjectMapper;

import bot.models.FormData;

import java.io.File;
import java.io.IOException;

public class GPTFieldFiller {
    public static FormData loadFormData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), FormData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
