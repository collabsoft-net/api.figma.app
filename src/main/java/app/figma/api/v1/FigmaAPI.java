package app.figma.api.v1;

import app.figma.api.v1.dto.*;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static app.figma.api.v1.Constants.FIGMA_API_URL;
import static app.figma.api.v1.Constants.FIGMA_TOKEN_HEADER;
import static org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES;

public class FigmaAPI {

    private final HttpClient client;

    public FigmaAPI(String token) {
        List<Header> headers = new ArrayList<>();
        if (null != token) {
            headers.add(new BasicHeader(FIGMA_TOKEN_HEADER, token));
        }

        this.client = HttpClientBuilder.create().setDefaultHeaders(headers).useSystemProperties().build();
    }

    public User getMyself() throws Exception {
        return this.fetch(User.class, new URIBuilder(getUrl("/me")));
    }

    public File getFile(String key) throws Exception {
        return this.getFile(key, FileRequest.builder().build());
    }

    public File getFile(String key, FileRequest options) throws Exception {
        URIBuilder uri = new URIBuilder(getUrl(String.format("/files/%s", key)));

        if (options.getVersion() != null) {
            uri.addParameter("version", options.getVersion());
        }

        if (options.getDepth() != null) {
            uri.addParameter("depth", String.valueOf(options.getDepth()));
        }

        if (options.getGeometry() != null) {
            uri.addParameter("geometry", options.getGeometry());
        }

        if (options.getIds() != null && options.getIds().size() > 0) {
            uri.addParameter("ids", String.join(",", options.getIds()));
        }

        return fetch(File.class, uri);
    }

    public Images getImage(String key) throws Exception {
        return this.getImage(key, ImagesRequest.builder().build());
    }

    public Images getImage(String key, ImagesRequest options) throws Exception {
        URIBuilder uri = new URIBuilder(getUrl(String.format("/images/%s", key)));

        if (options.getIds() != null && options.getIds().size() > 0) {
            uri.addParameter("ids", String.join(",", options.getIds()));
        } else {
            throw new Exception("Parameter 'ids' is required");
        }

        if (options.getScale() != null) {
            uri.addParameter("scale", String.valueOf(options.getScale()));
        }

        if (options.getFormat() != null) {
            uri.addParameter("format", options.getFormat().name());
        }

        if (options.getSvg_include_id() != null && options.getSvg_include_id()) {
            uri.addParameter("svg_include_id", "true");
        }

        if (options.getSvg_simplify_stroke() != null && !options.getSvg_simplify_stroke()) {
            uri.addParameter("svg_simplify_stroke", "false");
        }

        if (options.getUse_absolute_bounds() != null && options.getUse_absolute_bounds()) {
            uri.addParameter("use_absolute_bounds", "true");
        }

        if (options.getVersion() != null) {
            uri.addParameter("version", options.getVersion());
        }

        return fetch(Images.class, uri);
    }

    private <T> T fetch(Class<T> type, URIBuilder uri) throws Exception {
        HttpResponse response = client.execute(new HttpGet(uri.build()));
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == 200) {
            InputStream stream = response.getEntity().getContent();
            String content = streamToString(stream);
            return new ObjectMapper()
                    .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(content, type);
        // As per https://www.figma.com/developers/api#errors
        } else if (statusCode == 400) {
            throw new Exception("400 Bad Request: Parameters are invalid or malformed. Please check the input formats.");
        } else if (statusCode == 404) {
            throw new Exception("404 Not found: The requested file or resource was not found.");
        } else if (statusCode == 429) {
            throw new Exception("429 Rate limit: In some cases API requests may be throttled or rate limited. Please wait a while before attempting the request again (typically a minute).");
        } else if (statusCode == 500) {
            throw new Exception("500 Internal server error: This most commonly occurs for very large image render requests, which may time out our server and return a 500. Please reduce the number and size of objects requested.");
        } else {
            throw new Exception(String.format("%s: an unknown error occurred", statusCode));
        }
    }

    private String streamToString(InputStream stream) throws Exception {
        InputStreamReader isReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuilder sb = new StringBuilder();
        String str;
        while((str = reader.readLine())!= null){
            sb.append(str);
        }
        return sb.toString();
    }

    private String getUrl(String path) {
        String pathWithPrefix = path.startsWith("/") ? path : "/" + path;
        return String.format("%s%s", FIGMA_API_URL, pathWithPrefix);
    }

}
