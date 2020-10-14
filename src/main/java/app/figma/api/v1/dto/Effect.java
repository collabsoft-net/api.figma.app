package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Effect {
    private EffectType type;
    private boolean visible;
    private double radius;
    private Color color;
    private BlendMode blendMode;
    private Vector2d offset;
}
