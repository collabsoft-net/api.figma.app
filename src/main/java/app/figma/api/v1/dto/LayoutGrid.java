package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LayoutGrid {
    private Pattern pattern;
    private double sectionSize;
    private boolean visible;
    private Color color;
    private Alignment alignment;
    private double gutterSize;
    private double offset;
    private double count;
}
