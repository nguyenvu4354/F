/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class Paging {
    private int numPerPage;
    private int start;
    private int size;

    private int totalPage;
    private int begin;
    private int end;
    
    private int pageStart;
    private int pageEnd;
    
    public Paging() {
    }
    
    public Paging(int numPerPage, int start, int size) {
        this.numPerPage = numPerPage;
        this.start = start;
        this.size = size;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }
    public void calc() {
        //Neu sluong page la kq phep chia va neu co du thi them 1 page nua
         totalPage = size/numPerPage+(size%numPerPage==0?0:1);
         start = start<0?0:start;
         start = start >= totalPage?(totalPage-1):start;
         //Tai moi page thi begin = tranghientai * so luong 1 trang
         begin = start*numPerPage; //[begin,end]
         end = begin+numPerPage;
         end = end>size?size:end;
         //page start = start - 2
         pageStart = start-2;
         pageStart = pageStart<0?0:pageStart;
         //page end = start + 2
         pageEnd = start+2;
         pageEnd = pageEnd>totalPage-1?totalPage-1:pageEnd;
    }
}
