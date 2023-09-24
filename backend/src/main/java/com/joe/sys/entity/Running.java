package com.joe.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author joe
 * @since 2023-02-19
 */
@TableName("running")
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Running implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer accx;

    private Integer accy;

    private Integer accz;

    private Integer gyroscopex;

    private Integer gyroscopey;

    private Integer gyroscopez;

    private Integer stay;

    private String timestamp;

    private Integer batch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAccx() {
        return accx;
    }

    public void setAccx(Integer accx) {
        this.accx = accx;
    }
    public Integer getAccy() {
        return accy;
    }

    public void setAccy(Integer accy) {
        this.accy = accy;
    }
    public Integer getAccz() {
        return accz;
    }

    public void setAccz(Integer accz) {
        this.accz = accz;
    }
    public Integer getGyroscopex() {
        return gyroscopex;
    }

    public void setGyroscopex(Integer gyroscopex) {
        this.gyroscopex = gyroscopex;
    }
    public Integer getGyroscopey() {
        return gyroscopey;
    }

    public void setGyroscopey(Integer gyroscopey) {
        this.gyroscopey = gyroscopey;
    }
    public Integer getGyroscopez() {
        return gyroscopez;
    }

    public void setGyroscopez(Integer gyroscopez) {
        this.gyroscopez = gyroscopez;
    }
    public Integer getStay() {
        return stay;
    }

    public void setStay(Integer stay) {
        this.stay = stay;
    }
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Running{" +
            "id=" + id +
            ", accx=" + accx +
            ", accy=" + accy +
            ", accz=" + accz +
            ", gyroscopex=" + gyroscopex +
            ", gyroscopey=" + gyroscopey +
            ", gyroscopez=" + gyroscopez +
            ", stay=" + stay +
            ", timestamp=" + timestamp +
            ", batch=" + batch +
        "}";
    }
}
