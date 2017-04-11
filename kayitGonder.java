package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@ManagedBean
@RequestScoped
public class kayitGonder {
	String isim,soyisim;

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}
	
	public String veritabaninaGonder()
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme","root","");
			ps=conn.prepareStatement("insert into kisiler(isim,soyisim) values(?,?)");
			ps.setString(1, isim);
			ps.setString(2, soyisim);
			i=ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
		finally {
			try{
				conn.close();
				ps.close();
			}
			catch(Exception ex)
			{
				System.err.println("hata olustu : " + ex);
			}
		}
		
		if ( i > 0)
		{
			System.out.println(" kayit basarili ");
			return "basarili?faces-redirect=true";
		}
		else
		{
			System.out.println(" kayit basarisiz ");
			return "basarisiz?faces-redirect=true";
		}
	}
}
