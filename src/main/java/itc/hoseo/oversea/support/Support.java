package itc.hoseo.oversea.support;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Support {	
	private int num; 
    private String writer;
    private String subject;
    private String email;
    private String content;
    private Timestamp regDate;
    private int readCount;
    private String ip;
    private int ref;
    private int reStep;	
    private int reLevel;
	private String fileName;
    private String fileRealName;
    private int start;
    private int end;
    private String keyField;
    private String keyWord;
    
}
