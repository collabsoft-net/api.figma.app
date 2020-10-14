package app.figma.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Map;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeStyle {
    private String fontFamily;
    private String fontPostScriptName;
    private double paragraphSpacing;
    private double paragraphIndent;
    private boolean italic;
    private double fontWeight;
    private double fontSize;
    private TextCase textCase;
    private TextDecoration textDecoration;
    private TextAutoResize textAutoResize;
    private TextAlignHorizontal textAlignHorizontal;
    private TextAlignVertical textAlignVertical;
    private double letterSpacing;
    private Paint[] fills;
    private Hyperlink hyperlink;
    private Map<String, Number> opentypeFlags;
    private double lineHeightPx;
    private double lineHeightPercent;
    private double lineHeightPercentFontSize;
    private String lineHeightUnit;
}
