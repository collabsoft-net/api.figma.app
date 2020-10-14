package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.Map;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vector extends Node {
    private boolean locked;
    private ExportSetting[] exportSettings;
    private BlendMode blendMode;
    private Boolean preserveRatio;
    private LayoutAlign layoutAlign;
    private LayoutConstraint constraints;
    private String transitionNodeID;
    private double transitionDuration;
    private EasingType transitionEasing;
    private Double opacity;
    private Rect absoluteBoundingBox;
    private Effect[] effects;
    private Vector2d size;
    private List<List<Double>> relativeTransform;
    @JsonProperty("isMask")
    private Boolean mask;
    private Paint[] fills;
    private Paint[] strokes;
    private Double strokeWeight;
    private StrokeCap strokeCap;
    private StrokeJoin strokeJoin;
    private double[] strokeDashes;
    private double strokeMiterAngle;
    private StrokeAlign strokeAlign;
    private Map<StyleType, String> styles;
}

