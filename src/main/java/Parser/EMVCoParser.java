package Parser;

import Model.EmvObject;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by User on 07/03/2018.
 */
public class EMVCoParser {
    private static final int Length = 2;

    String emvcoQrValue;
    int tag, subTag;
    boolean hasSubTag;

    public EMVCoParser(String emvcoQrValue, int tag) {
        this.emvcoQrValue = emvcoQrValue;
        this.tag = tag;
    }

    public EMVCoParser(String emvcoQrValue, int tag, int subTag) {
        this.emvcoQrValue = emvcoQrValue;
        this.tag = tag;
        this.subTag = subTag;
        hasSubTag = true;
    }

    public String getParsingValue() {
        Map<Integer, EmvObject> parsingValues = parseEmvcoQR(emvcoQrValue);
        EmvObject obj = parsingValues.get(tag);
        if (hasSubTag) {
            return parseEmvcoQR(obj.getValues()).get(subTag).getValues();
        }
        return obj.getValues();
    }

    private Map<Integer, EmvObject> parseEmvcoQR(String str) {
        Map <Integer, EmvObject> result = new HashMap<Integer, EmvObject>();
        int i = 0;

        while (i < str.length()) {

            int tagInd = i + Length;

            int tag = Integer.parseInt(str.substring(i, tagInd));
            int lengthValue = Integer.parseInt(str.substring(tagInd, tagInd + Length ));

            EmvObject emvObject = new EmvObject();
            emvObject.setLength(lengthValue);
            emvObject.setValues(str.substring(tagInd + Length , tagInd + Length + lengthValue));

            System.out.println("Index Tag/SubTag : " + tagInd + " Length : " + lengthValue + " Values " + str.substring(tagInd + Length , tagInd + Length + lengthValue));
            result.put(tag, emvObject);

            i = tagInd + Length + lengthValue;

        }

        return result;
    }
}
