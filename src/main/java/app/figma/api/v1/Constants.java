package app.figma.api.v1;

import java.util.regex.Pattern;

public class Constants {

    public final static String FIGMA_TOKEN_HEADER = "X-FIGMA-TOKEN";
    public final static String FIGMA_API_URL = "https://api.figma.com/v1";
    public final static Pattern FIGMA_KEY_REGEXP = Pattern.compile("[0-9a-zA-Z]{22,128}");
    public final static Pattern FIGMA_URL_REGEXP = Pattern.compile("https://([w.-]+.)?figma.com/(file|proto)/([0-9a-zA-Z]{22,128})(?:/.*)?$");

}
