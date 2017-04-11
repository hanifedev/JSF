package jsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class kayitSilme {
	String silmeMesaji;
	
	public String getSilmeMesaji() {
		return silmeMesaji;
	}

	public void setSilmeMesaji(String silmeMesaji) {
		this.silmeMesaji = silmeMesaji;
	}

	public void gorunurluguDegistir(Kisiler k)
	{
		k.setGuncellenebilirlik(true);
	}
	
	public void kaydiSil(Kisiler k)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root","root");
			ps=conn.prepareStatement("delete from kisiler where id=?");
			ps.setInt(1, k.getId());
			i=ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("hata meydana geldi" + e);
		}
		finally {
			try {
				conn.close();
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
				
			}
		}
		if(i>0)
		{
			silmeMesaji="Silme islemi basarili";
		}
		else
		{
			silmeMesaji="Silme hatali";
		}
		System.out.println(silmeMesaji);
	}
}
