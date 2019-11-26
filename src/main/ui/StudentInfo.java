package ui;

public class StudentInfo {
   	private String ID;
   	private String name;

   	public StudentInfo(String name,String ID) {
   	    super();
   	    this.ID = ID;
   	    this.name =name;
   	   	}

   	   	public String getIdnum() {	return ID;	}

   	   	public void setIdnum(String ID) {	this.ID = ID;	}

   	   	public String getName() {  return name;	}

   	   	public void setName(String name) {	this.name = name;	}

}
