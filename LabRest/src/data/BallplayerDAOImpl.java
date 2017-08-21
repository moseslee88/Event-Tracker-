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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
