package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Color {
    private double a;
    private double b;
    private double g;
    private double r;
}
