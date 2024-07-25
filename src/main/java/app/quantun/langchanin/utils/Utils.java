package app.quantun.langchanin.utils;

import app.quantun.langchanin.ai.Assistant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class Utils {


    public static Path toPath(String relativePath) {
        try {
            URL fileUrl = Utils.class.getClassLoader().getResource(relativePath);
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            log.error("Error while converting relative path to absolute path {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
