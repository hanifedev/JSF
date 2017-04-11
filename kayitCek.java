package jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class kayitCek {
	List<Kisiler> sorguSonucu;

	public List<Kisiler> getSorguSonucu() {
		return sorguSonucu;
	}

	public void setSorguSonucu(List<Kisiler> sorguSonucu) {
		this.sorguSonucu = sorguSonucu;
	}
	
	@PostConstruct
	public void veritabanindanKayitCek()
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		sorguSonucu=new ArrayList<Kisiler>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme","root","");
			ps=conn.prepareStatement("select * from kisiler");
			rs=ps.executeQuery();
			while(rs.next())
			{
				Kisiler kisiler= new Kisiler();
				kisiler.setId(rs.getInt("id"));
				kisiler.setIsim(rs.getString("isim"));
				kisiler.setSoyisim(rs.getString("soyisim"));
				sorguSonucu.add(kisiler);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("hata meydana geldi");
		}
		finally {
			try
			{
				conn.close();
				ps.close();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
