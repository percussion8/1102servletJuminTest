package jumin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.State;

import jumin.util.DBConnectionPool;
import jumin.vo.JuminVO;

public class JuminDao {
	
	DBConnectionPool connPool;
	
	public void setConnection(DBConnectionPool connPool) { 
		this.connPool = connPool;
	}
	
	//컨트롤러에서 호출할 메서드/쿼리를 작성할것
	
	public List<JuminVO> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = connPool.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select pno, pname, personid, paddr, phone, siblings, family from person order by pno asc");
			System.out.println("쿼리문성공");
			ArrayList<JuminVO> jumins = new ArrayList<JuminVO>();
			
			while(rs.next()) {
				jumins.add(new JuminVO()
						.setNo(rs.getInt("pno"))
						.setName(rs.getString("pname"))
						.setId(rs.getString("personid"))
						.setAddr(rs.getString("paddr"))
						.setPhone(rs.getString("phone"))
						.setSiblings(rs.getInt("siblings"))
						.setLastname(rs.getString("family"))
						);
			}
			System.out.println("쿼리결과 옮겨담기완료");
			return jumins;
		
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		}
		
	}
	
	public int insert (JuminVO jumin) throws Exception {
		PreparedStatement pstmt = null;
		Connection connection = null;
		PreparedStatement pstmt0 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			connection = connPool.getConnection();
			pstmt = connection.prepareStatement("insert into person(pname, personid, paddr, phone, siblings, Family) values (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, jumin.getName());
			pstmt.setString(2, jumin.getId());
			pstmt.setString(3, jumin.getAddr());
			pstmt.setString(4, jumin.getPhone());
			pstmt.setInt(5, jumin.getSiblings());
			pstmt.setString(6, jumin.getLastname());
			pstmt.executeUpdate();
			
			pstmt0 = connection.prepareStatement("alter table person auto_increment=1");
			pstmt1 = connection.prepareStatement("set @count = 0");
			pstmt2 = connection.prepareStatement("update person set person.pno = @count:=@count+1");
			pstmt0.executeUpdate();
			System.out.println("stmt0완료");
			pstmt1.executeUpdate();
			System.out.println("stmt1완료");
			return pstmt2.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
			try {if (pstmt0 != null) pstmt0.close();} catch(Exception e) {}
			try {if (pstmt1 != null) pstmt1.close();} catch(Exception e) {}
			try {if (pstmt2 != null) pstmt2.close();} catch(Exception e) {}
		}
	}
	
	public JuminVO selectOne(int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = connPool.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select pno, pname, personid, paddr, phone, siblings, family from person where pno =" + no);
			
			if(rs.next()) {
				return new JuminVO()
						.setNo(rs.getInt("pno"))
						.setName(rs.getString("pname"))
						.setId(rs.getString("personid"))
						.setAddr(rs.getString("paddr"))
						.setPhone(rs.getString("phone"))
						.setSiblings(rs.getInt("siblings"))
						.setLastname(rs.getString("family"));
			} else {
				throw new Exception("해당하는 주민이 없습니다.");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(rs!=null) rs.close();} catch(Exception e) {}

		}
	}
	
	public int update(JuminVO jumin) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = connPool.getConnection();
			pstmt = connection.prepareStatement("update person set pname=?, "
					+ "personid=?, paddr=?, phone=?, siblings=?, family=? where pno =?");
			pstmt.setString(1, jumin.getName());
			pstmt.setString(2, jumin.getId());
			pstmt.setString(3, jumin.getAddr());
			pstmt.setString(4, jumin.getPhone());
			pstmt.setInt(5, jumin.getSiblings());
			pstmt.setString(6, jumin.getLastname());
			pstmt.setInt(7, jumin.getNo());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		} finally {
			try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		}
	}
	
	public List<JuminVO> selectName(String name) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = connPool.getConnection();
			pstmt = connection.prepareStatement("select pno, pname, personid, paddr, phone, siblings, family from person where pname =? order by pno asc");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();;
			ArrayList<JuminVO> jumins = new ArrayList<JuminVO>();
			
			while(rs.next()) {
				String year = rs.getString("personid").substring(0, 2);
				int age = 2020-1900 - Integer.parseInt(year);
				if (age>100) {
					age -= 100;
				}
				jumins.add(new JuminVO()
						.setNo(rs.getInt("pno"))
						.setName(rs.getString("pname"))
						.setId(rs.getString("personid"))
						.setAddr(rs.getString("paddr"))
						.setPhone(rs.getString("phone"))
						.setSiblings(rs.getInt("siblings"))
						.setLastname(rs.getString("family"))
						.setAge(age)
						);
			}
			return jumins;
		
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		}
		
	}
	
	public int delete (int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt0 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			connection = connPool.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate("delete from person where pno =" + no);
			System.out.println("삭제 완료");
			
			
			pstmt0 = connection.prepareStatement("alter table person auto_increment=1");
			pstmt1 = connection.prepareStatement("set @count = 0");
			pstmt2 = connection.prepareStatement("update person set person.pno = @count:=@count+1");
			pstmt0.executeUpdate();
			System.out.println("stmt0완료");
			pstmt1.executeUpdate();
			System.out.println("stmt1완료");
			return pstmt2.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (pstmt0 != null) pstmt0.close();} catch(Exception e) {}
			try {if (pstmt1 != null) pstmt1.close();} catch(Exception e) {}
			try {if (pstmt2 != null) pstmt2.close();} catch(Exception e) {}

		}
	}

}
