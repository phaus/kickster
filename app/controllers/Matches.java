package controllers;

import java.util.List;
import models.Match;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;
public class Matches extends Controller {
    public static void index() {
        List<Match> entities = models.Match.all().fetch();
        render(entities);
    }

    public static void create(Match match) {
        render(match);
    }

    public static void show(java.lang.Long id) {
        Match match = Match.findById(id);
        render(match);
    }

    public static void edit(java.lang.Long id) {
        Match match = Match.findById(id);
        render(match);
    }

    public static void delete(java.lang.Long id) {
        Match match = Match.findById(id);
        match.delete();
        index();
    }
    
    public static void save(@Valid Match match) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@create", match);
        }
        match.save();
        flash.success(Messages.get("scaffold.created", "Match"));
        index();
    }

    public static void update(@Valid Match match) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@edit", match);
        }
                      match = match.merge();
                match.save();
        flash.success(Messages.get("scaffold.updated", "Match"));
        index();
    }
}
