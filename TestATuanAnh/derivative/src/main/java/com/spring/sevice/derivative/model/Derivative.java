package com.spring.sevice.derivative.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@javax.persistence.Entity
@Table(name = "derivative", uniqueConstraints = {@UniqueConstraint(columnNames = "deri_composite_code")})
public class Derivative {
    private String deri_composite_code;
    private String derivative_code;
    private Date effective_date;
    private Date expiration_date;
    private Date created_date;
    private String created_by;
    private Date modified_date;
    private String modified_by;
    private String underlying_type;

    public Derivative(){}

    //khai báo các trường trong bảng
    @Id
    @GeneratedValue
    @Pattern(regexp = "^[a-zA-z0-9]*")
    @Column(name = "deri_composite_code",unique = true,nullable = false)
    public String getDeri_composite_code(){
        return deri_composite_code;
    }

    public void setDeri_composite_code(String deri_composite_code) {
        this.deri_composite_code = deri_composite_code;
    }

    @Pattern(regexp = "^[a-zA-z0-9]*")
    @Column(name = "derivative_code",unique = true,nullable = false)
    public String getDerivative_code() {
        return derivative_code;
    }

    public void setDerivative_code(String derivative_code) {
        this.derivative_code = derivative_code;
    }

    @Column(name = "effective_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    public Date getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(Date effective_date) {
        this.effective_date = effective_date;
    }

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Column(name = "created_by")
    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    @Column(name = "modified_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    @Column(name = "modified_by")
    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Column(name = "underlying_type")
    public String getUnderlying_type() {
        return underlying_type;
    }

    public void setUnderlying_type(String underlying_type) {
        this.underlying_type = underlying_type;
    }
}
