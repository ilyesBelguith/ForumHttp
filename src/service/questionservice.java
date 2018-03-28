package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.QuestionLocal;
import metier.entities.Question;
@Stateless
@Path("/")
public class questionservice {

	@EJB
	private QuestionLocal metier;

	@POST
	@Path("/Questions")
	@Produces(MediaType.APPLICATION_JSON)
	public Question addquestion(Question q) {
		return metier.addquestion(q);
	}
	@GET
	@Path("/Questions/{Q_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Question getquestion(@PathParam(value="Q_id") Long Q_id) {
		return metier.getquestion(Q_id);
	}
	@GET
	@Path("/Questions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> getquestions() {
		return metier.getquestions();
	}
}
