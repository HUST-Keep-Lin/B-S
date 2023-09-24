package com.joe.sys.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@TableName("truth")
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Truth implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer step;

    private Double xt;

    private Double yt;

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Double getXt() {
        return xt;
    }

    public void setXt(Double xt) {
        this.xt = xt;
    }

    public Double getYt() {
        return yt;
    }

    public void setYt(Double yt) {
        this.yt = yt;
    }

    @Override
    public String toString() {
        return "Truth{" +
                "step=" + step +
                ", xt=" + xt +
                ", yt=" + yt +
                '}';
    }
}
