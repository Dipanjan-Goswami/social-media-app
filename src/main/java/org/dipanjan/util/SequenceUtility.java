package org.dipanjan.util;

public class SequenceUtility {
    private long primary_code;
    private String Section_Code;
    private long Sequence_Code;

    public SequenceUtility(String Section_Code) {
        this.primary_code = new PrimarySequenceGenerator().getNext();
        this.Section_Code = Section_Code;
        this.Sequence_Code = new SequenceCodeGenerator().getNext();
    }
    
    public String getValue(){
        String Sequence;
        String PrimarySequence = Lpad(String.valueOf(primary_code),4,'0');
        String CodeSequence = Lpad(String.valueOf(Sequence_Code),8,'0');
        Sequence = PrimarySequence + Section_Code + CodeSequence;
        return Sequence;
    }
    
    private String Lpad(String inputString, int length, char padString) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(padString);
        }
        sb.append(inputString);

        return sb.toString();
    }
}
