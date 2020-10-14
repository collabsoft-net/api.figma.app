package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Canvas extends Node {
    @JsonDeserialize(using = NodeDeserializer.class)
    private Node[] children;

    private Color backgroundColor;
    private String prototypeStartNodeID;
    private ExportSetting[] exportSettings;
}