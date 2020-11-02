package jumin.vo;

public class JuminVO {
	protected int no;
	protected String name;
	protected String id;
	protected String addr;
	protected String phone;
	protected int siblings;
	protected String lastname;
	protected int age;
	
	public JuminVO() {}
	
	public JuminVO(int no, String name, String id, String addr, String tel, int bro, String last) {
		this.no = no;
		this.name = name;
		this.id = id;
		this.addr = addr;
		this.phone = tel;
		this.siblings = bro;
		this.lastname = last;
	}

	public int getNo() {return no;}
	public JuminVO setNo(int no) {this.no = no; return this;}

	public String getName() {return name;}
	public JuminVO setName(String name) {this.name = name; return this;}

	public String getId() {return id;}
	public JuminVO setId(String id) {this.id = id; return this;}

	public String getAddr() {return addr;}
	public JuminVO setAddr(String addr) {this.addr = addr; return this;}

	public String getPhone() {return phone;}
	public JuminVO setPhone(String phone) {this.phone = phone; return this;}

	public int getSiblings() {return siblings;}
	public JuminVO setSiblings(int siblings) {this.siblings = siblings; return this;}

	public String getLastname() {return lastname;}
	public JuminVO setLastname(String lastname) {this.lastname = lastname; return this;}
	
	public int getAge() {return age;}
	public JuminVO setAge(int age) {this.age = age; return this;}
	
	
	
	
}
