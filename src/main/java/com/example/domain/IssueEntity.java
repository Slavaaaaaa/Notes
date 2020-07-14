package com.example.domain;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.persistence.*;

@Entity
public class IssueEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long parent_id;
    private String title;
    private String discription;
    private Boolean done;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public IssueEntity() {}

    public IssueEntity(Long parent_id, String title) {
        this(null, parent_id, title, null, false, null, null, null);

        LocalDateTime currentDataTime = LocalDateTime.now();
        this.createDate = Date.from(currentDataTime.atZone(ZoneId.systemDefault()).toInstant());
        this.updateDate = createDate;
    }

    public IssueEntity(Long id, Long parent_id, String title, String discription, Boolean done,
                      Date createDate, Date updateDate, Date date) {
        this.id = id;
        this.parent_id = parent_id;
        this.title = title;
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

    public Long getParentId(){
        return parent_id;
    }

    public void setTitle(String tittle){
        this.title = tittle;
    }

    public String getTitle(){
        return title;
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