package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class User
{
	private String email;
	private String displayName;
	private String password;
	
	public User()
	{
		super();
	}
	
	public User(String email, String displayName, String password)
	{
		super();
		this.email = email;
		this.displayName = displayName;
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User [email=" + email + ", displayName=" + displayName + ", password=" + password + "]";
	}
}
