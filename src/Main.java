import com.controller.Controller;
import com.model.Model;
import com.view.View;
import org.json.JSONException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        Model m = new Model();
        Controller c = new Controller();
        View v = new View();

        m.registerView(v);
        c.setModel(m);
        v.setActionListener(c);

    }
}
