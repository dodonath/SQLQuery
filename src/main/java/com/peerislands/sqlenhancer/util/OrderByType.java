package com.peerislands.sqlenhancer.util;

public enum OrderByType {
	
	ASC("ASC"), DESC("DESC");

    String status;

    OrderByType(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
