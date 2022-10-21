package com.spring.sevice.derivative.model;

import java.util.List;

public class Data {
    List<Derivative> data;
    private int currentPage;
    private int size;

    public List<Derivative> getData() {
        return data;
    }

    public void setData(List<Derivative> data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    private int totalElements;
    private int totalPages;
}
