package tour;

public class Map 
{
	protected String 	x;
	protected String   y;
	protected String title;
	protected String addr1;
	protected String cat1;
	protected String firstimage;
	protected String tel;
	
	public String getX() 
	{
		return x;
	}
	public Map setX(String x)
	{
		this.x = x;
		return this;
	}
	
	public String getY()
	{
		return y;
	}
	public Map setY(String y)
	{
		this.y = y;
		return this;
	}
	
	public String getTitle()
	{
		return title;
	}
	public Map setTitle(String title)
	{
		this.title = title;
		return this;
	}
	
	public String getAddr1()
	{
		return addr1;
	}
	public Map setAddr1(String addr1)
	{
		this.addr1 = addr1;
		return this;
	}
	
	public String getCat1()
	{
		return cat1;
	}
	public Map setCat1(String cat1)
	{
		this.cat1 = cat1;
		return this;
	}
	
	public String getFirstimage()
	{
		return firstimage;
	}
	public Map setFirstimage(String firstimage)
	{
		this.firstimage = firstimage;
		return this;
	}
	
	public String getTel()
	{
		return tel;
	}
	public Map setTel(String tel)
	{
		this.tel = tel;
		return this;
	}
}
