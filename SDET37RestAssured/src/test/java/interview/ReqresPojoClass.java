package interview;

public class ReqresPojoClass {

//declare the variables for creating the user	
	String name;
	String job;
//create a empty constructor
public ReqresPojoClass() {
	
}
//create the parameterized constructor
public ReqresPojoClass(String name, String job) {
	super();
	this.name=name;
	this.job=job;
}
//create the getter and setter methods
public String getname() {
return name;
}
public void setname(String name) {
	this.name=name;
}
public String getjob() {
	return job;
}
public void setjob(String job) {
	this.job=job;
}
}
