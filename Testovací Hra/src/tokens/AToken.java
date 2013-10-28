

package tokens;

import java.util.Collection;


public abstract class AToken {
	private Team team;
	private String name;

	public AToken(Team team, String name){
		this.team=team;
		this.name=name;
	}
	
	public Collection<AToken> getTargetsInRange(){
		return null;
	}

	public String getTeam(){
		return team.toString();
	}
	public void setTeam(Team team){
		this.team=team;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	@Override
	public String toString(){
		return team.toString()+" "+name;
	}
}
