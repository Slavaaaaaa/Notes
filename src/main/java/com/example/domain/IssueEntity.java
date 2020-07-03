package com.example.domain;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.persistence.*;

@Entity
public class IssueEntity {

    @Id
    @GeneratedValue
    private long id;
    private long parent_id;
    private String tittle;
    private String discription;
    private Boolean done;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public IssueEntity() {}

    public IssueEntity(long parent_id, String tittle) {
        this(null, parent_id, tittle, "", false, null, null, null);

        LocalDateTime currentDataTime = LocalDateTime.now();
        this.createDate = Date.from(currentDataTime.atZone(ZoneId.systemDefault()).toInstant());
        this.updateDate = createDate;
    }

    public IssueEntity(Long id, long parent_id, String tittle, String discription, Boolean done,
                       Date createDate, Date updateDate, Date date) {
        this.id = id;
        this.parent_id = parent_id;
        this.tittle = tittle;
        this.discription = discription;
        this.done = done;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.date = date;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setParentId(Long parent_id){
        this.parent_id = parent_id;
    }

    public Long getParentId(Long parent_id){
        return parent_id;
    }

    public void setTittle(String tittle){
        this.tittle = tittle;
    }

    public String getTittle(){
        return tittle;
    }

    public void setDiscription(String discription){
        this.discription = discription;
    }

    public String getDiscription(){
        return discription;
    }

    public void setDone(Boolean done){
        this.done = done;
    }

    public Boolean getDone(){
        return done;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getate(){
        return date;
    }
}
