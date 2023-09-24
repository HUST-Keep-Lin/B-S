package com.joe.sys.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@TableName("result")
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double xr;

    private Double yr;

    private Double arg;

    private Double error;

    private Double cdfx;

    private Double cdfy;

    private Double perror;

    public Double getXr() {
        return xr;
    }

    public void setXr(Double xr) {
        this.xr = xr;
    }

    public Double getYr() {
        return yr;
    }

    public void setYr(Double yr) {
        this.yr = yr;
    }

    public Double getArg() {
        return arg;
    }

    public void setArg(Double arg) {
        this.arg = arg;
    }

    public Double getError() {
        return error;
    }

    public void setError(Double error) {
        this.error = error;
    }

    public Double getCdfx() {
        return cdfx;
    }

    public void setCdfx(Double cdfx) {
        this.cdfx = cdfx;
    }

    public Double getCdfy() {
        return cdfy;
    }

    public void setCdfy(Double cdfy) {
        this.cdfy = cdfy;
    }

    public Double getPerror() {
        return perror;
    }

    public void setPerror(Double perror) {
        this.perror = perror;
    }

    @Override
    public String toString() {
        return "Result{" +
                "xr=" + xr +
                ", yr=" + yr +
                ", arg=" + arg +
                ", error=" + error +
                ", cdfx=" + cdfx +
                ", cdfy=" + cdfy +
                ", perror=" + perror +
                '}';
    }
}
