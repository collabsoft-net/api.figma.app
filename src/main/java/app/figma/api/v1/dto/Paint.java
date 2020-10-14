package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paint {
    private FillType type;
    private boolean visible;
    private double opacity;
    private Color color;
    private BlendMode blendMode;
    private Vector2d[] gradientHandlePositions;
    private ColorStop[] gradientStops;
    private ScaleMode scaleMode;
    private List<List<Double>> imageTransform;
    private double scalingFactor;
    private double rotation;
    private String imageRef;
    private String gifRef;
}
