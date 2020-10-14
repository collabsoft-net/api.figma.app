package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slice extends Node {
    private ExportSetting[] exportSettings;
    private Rect absoluteBoundingBox;
    private Vector2d size;
    private List<List<Double>> relativeTransform;
}
