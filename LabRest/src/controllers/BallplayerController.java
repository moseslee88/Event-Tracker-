package controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.BallplayerDAO;
import entities.Ballplayer;

@RestController
public class BallplayerController {

	@Autowired
	private BallplayerDAO dao;

	@RequestMapping(path = "/ping")
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "ballplayers", method = RequestMethod.GET)
	public List<Ballplayer> index() {

		return dao.index();
	}

	@RequestMapping(path = "ballplayers/{id}", method = RequestMethod.GET)
	public Ballplayer show(@PathVariable int id) {
		return dao.show(id);
	}
	   
	//controller method for creating a new Ballplayer
	@RequestMapping(path = "ballplayers", method = RequestMethod.POST)
	public Ballplayer create(@RequestBody String labJSON, HttpServletResponse res) {
		if (labJSON != null) {
			res.setStatus(202);
			ObjectMapper mapper = new ObjectMapper();
			Ballplayer player = null;
			try {
				player = mapper.readValue(labJSON, Ballplayer.class);
				return dao.create(player);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		res.setStatus(400);
		return null;

	}

	@RequestMapping(path = "ballplayers/{id}", method = RequestMethod.PUT)
	public Ballplayer update(@PathVariable int id, @RequestBody String labJSON, HttpServletResponse res) {
		if (labJSON != null) {
			res.setStatus(202);
			ObjectMapper mapper = new ObjectMapper();
			Ballplayer updatedPlayer = null;
			try {
				updatedPlayer = mapper.readValue(labJSON, Ballplayer.class);
				dao.update(id, updatedPlayer);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dao.update(id, updatedPlayer);
		}
		res.setStatus(400);
		return null;
	}

	@RequestMapping(path = "ballplayers/{id}", method = RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id) {

		return dao.destroy(id);
	}
	
}