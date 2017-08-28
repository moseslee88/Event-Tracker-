package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Ballplayer;

@Transactional
public class BallplayerDAOImpl implements BallplayerDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Ballplayer> index() {
		String queryString = "Select b from Ballplayer b";
		return em.createQuery(queryString, Ballplayer.class).getResultList();
	}

	@Override
	public Ballplayer show(int id) {
		return em.find(Ballplayer.class, id);
	}

	@Override
	public Ballplayer create(Ballplayer player) {
		    // TODO Auto-generated method stub
		em.persist(player);
		em.flush();
		return em.find(Ballplayer.class, player.getId());
	}

	@Override
	public Ballplayer update(int id, Ballplayer player) {
	        Ballplayer managed = null;
			try {
			
			managed=em.find(Ballplayer.class, id);
			managed.setName(player.getName());
			managed.setSeason(player.getSeason());
			managed.setAtBats(player.getAtBats());
			managed.setHomeRuns(player.getHomeRuns());
			managed.setAnnualSalary(player.getAnnualSalary());
			managed.setAtBatsPerHomeRun(player.getAtBatsPerHomeRun());

			//em.persist(player);  //here I am not ADDing another ballplayer, just now making the entity now residing in the Persistence Context to be moved to the database 
			em.flush();
		
			} catch (Exception e)  {
				e.printStackTrace();
			}
			return managed;
			
		}


	@Override
	public boolean destroy(int id) {
			Ballplayer deletedPlayer = em.find(Ballplayer.class, id);  
			em.remove(deletedPlayer);
			if (deletedPlayer==null) {
				return false;
			}	
			return true;
		}
	
	
}

