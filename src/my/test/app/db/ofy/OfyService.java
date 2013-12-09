package my.test.app.db.ofy;



import my.test.app.entity.Mark;
import my.test.app.entity.Student;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;


public class OfyService {
    static {
        factory().register(Student.class);
        factory().register(Mark.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.begin();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}