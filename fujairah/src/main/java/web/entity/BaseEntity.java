package web.entity;

/**
 * Created by yuhao.zx on 14-9-21.
 */
public class BaseEntity {
    private Boolean pagging = true;
    private Integer startRow;
    private Integer pageSize;

    public Boolean getPagging() {
        return pagging;
    }

    public void setPagging(Boolean pagging) {
        this.pagging = pagging;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
