import java.awt.Image;

public class Entity 
{

	//basic stats
	private int totalHealth;
	private int currentHealth;
	private int attack;
	private int defense;
	private Image image;
	
	//constructor for basic stats
	public Entity(int totH, int a, int d, Image i)
	{
		totalHealth = totH;
		attack = a;
		defense = d;
		image = i;
	}
}