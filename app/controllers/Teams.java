package controllers;

import java.util.List;
import models.Team;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;
public class Teams extends Controller {
    public static void index() {
        List<Team> entities = models.Team.all().fetch();
        render(entities);
    }

    public static void create(Team team) {
        render(team);
    }

    public static void show(java.lang.Long id) {
        Team team = Team.findById(id);
        render(team);
    }

    public static void edit(java.lang.Long id) {
        Team team = Team.findById(id);
        render(team);
    }

    public static void delete(java.lang.Long id) {
        Team team = Team.findById(id);
        team.delete();
        index();
    }
    
    public static void save(@Valid Team team) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@create", team);
        }
        team.save();
        flash.success(Messages.get("scaffold.created", "Team"));
        index();
    }

    public static void update(@Valid Team team) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@edit", team);
        }
                      team = team.merge();
                team.save();
        flash.success(Messages.get("scaffold.updated", "Team"));
        index();
    }
}
