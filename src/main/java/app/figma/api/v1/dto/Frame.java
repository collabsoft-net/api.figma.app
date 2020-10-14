package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.List;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Frame extends Node {

    @JsonDeserialize(using = NodeDeserializer.class)
    private Node[] children;

    private boolean locked;
    @Deprecated
    private Paint[] background;
    @Deprecated
    private Color backgroundColor;
    private Paint[] fills;
    private Paint[] strokes;
    private Double strokeWeight;
    private StrokeAlign strokeAlign;
    private Double cornerRadius;
    private Double[] rectangleCornerRadii;
    private ExportSetting[] exportSettings;
    private BlendMode blendMode;
    private Boolean preserveRatio;
    private LayoutConstraint constraints;
    private LayoutAlign layoutAlign;
    private String transitionNodeID;
    private double transitionDuration;
    private EasingType transitionEasing;
    private Double opacity;
    private Rect absoluteBoundingBox;
    private Vector2d size;
    private List<List<Double>> relativeTransform;
    private Boolean clipsContent;
    private LayoutMode string;
    private AxisSizingMode counterAxisSizingMode;
    private double horizontalPadding;
    private double verticalPadding;
    private double itemSpacing;
    private LayoutGrid[] layoutGrids;
    private OverflowDirection overflowDirection;
    private Effect[] effects;
    @JsonProperty("isMask")
    private Boolean mask;
    @JsonProperty("maskOutline")
    private Boolean maskOutline;
}

