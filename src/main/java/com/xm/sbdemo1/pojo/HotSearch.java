package com.xm.sbdemo1.pojo;

public class HotSearch {

    private Long hotsearchid;

    private String hotwords;

    private Long searchtimes;

    private Integer note;

    public Long getHotsearchid() {
        return hotsearchid;
    }

    public void setHotsearchid(Long hotsearchid) {
        this.hotsearchid = hotsearchid;
    }

    public String getHotwords() {
        return hotwords;
    }

    public void setHotwords(String hotwords) {
        this.hotwords = hotwords;
    }

    public Long getSearchtimes() {
        return searchtimes;
    }

    public void setSearchtimes(Long searchtimes) {
        this.searchtimes = searchtimes;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
