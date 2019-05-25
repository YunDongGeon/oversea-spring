package itc.hoseo.oversea.board;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Board {
	private int num; 
	private String writer;
    private String subject;
    private String email;
    private String content;
    private Timestamp reg_date;
    private int readcount;
    private String ip;
    private int ref;
    private int reStep;	
    private int reLevel;
	private String fileName;
    private String fileRealName;         
}

