package app.figma.api.v1.dto;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NodeDeserializer extends JsonDeserializer<Node[]> {

    @Override
    public Node[] deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        // Get reference to ObjectCodec
        ObjectCodec codec = jp.getCodec();

        // Parse "object" node into Jackson's tree model
        JsonNode node = codec.readTree(jp);

        if (node.isArray()) {
            List<Node> result = new ArrayList<>();
            for (JsonNode child : node) {
                result.add(this.toNode(child, codec));
            }
            return result.toArray(new Node[] {});
        } else {
            throw new JsonMappingException("Element is not an array", jp.getCurrentLocation());
        }
    }

    private Node toNode(JsonNode node, ObjectCodec codec) throws IOException {
        // Get value of the "type" property
        String type = node.get("type").asText();
        NodeType nodeType = NodeType.valueOf(type);

        // Check the "type" property and map "object" to the suitable class
        switch (nodeType) {

            case DOCUMENT:
                return codec.treeToValue(node, Document.class);

            case CANVAS:
                return codec.treeToValue(node, Canvas.class);

            case FRAME:
            case GROUP:
            case COMPONENT:
                return codec.treeToValue(node, Frame.class);

            case VECTOR:
            case STAR:
            case LINE:
            case ELLIPSE:
            case REGULAR_POLYGON:
                return codec.treeToValue(node, Vector.class);

            case BOOLEAN:
            case BOOLEAN_OPERATION:
                return codec.treeToValue(node, BooleanOperation.class);

            case RECTANGLE:
                return codec.treeToValue(node, Rectangle.class);

            case TEXT:
                return codec.treeToValue(node, Text.class);

            case SLICE:
                return codec.treeToValue(node, Slice.class);

            case INSTANCE:
                return codec.treeToValue(node, Instance.class);

            default:
                throw new JsonMappingException("Invalid value for the \"type\" property: " + nodeType);
        }
    }
}