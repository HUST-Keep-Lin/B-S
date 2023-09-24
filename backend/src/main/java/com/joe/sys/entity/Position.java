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
@TableName("position")
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Double x;

    private Double y;

    private Double z;

    private Integer stay;

    private String timestamp;

    private Integer batch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }
    public Integer getStay() {
        return stay;
    }

    public void setStay(Integer stay) {
        this.stay = stay;
    }
    public String  getTimestamp() {
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
        return "Position{" +
            "id=" + id +
            ", x=" + x +
            ", y=" + y +
            ", z=" + z +
            ", stay=" + stay +
            ", timestamp=" + timestamp +
            ", batch=" + batch +
        "}";
    }
}
