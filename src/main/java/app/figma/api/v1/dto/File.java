package app.figma.api.v1.dto;

import lombok.Getter;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Map;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class File {
    private String name;
    private String role;
    private String lastModified;
    private String thumbnailUrl;
    private String version;
    private Map<String, Component> components;
    private Document document;
    private double schemaVersion;
}
