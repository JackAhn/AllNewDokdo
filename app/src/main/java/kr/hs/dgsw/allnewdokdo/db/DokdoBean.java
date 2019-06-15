package kr.hs.dgsw.allnewdokdo.db;

public class DokdoBean {
    private int sequenceNumber;
    private String kind;
    private int imgNo;
    private String content;

    public DokdoBean(){

    }

    public DokdoBean(String kind, int imgNo, String content){
        this.kind = kind;
        this.imgNo = imgNo;
        this.content = content;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getImgNo() {
        return imgNo;
    }

    public void setImgNo(int imgNo) {
        this.imgNo = imgNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
